package com.wenny.learn.base.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.concurrent.*;

@Component
@Slf4j
public class ThreadPoolRejectTest {
    private ThreadPoolTaskExecutor asyncTaskExecutor;

    @PostConstruct
    private void init() {
        asyncTaskExecutor = new ThreadPoolTaskExecutor();
        ThreadFactory factory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("threadName" + "%d").build();
        asyncTaskExecutor.setThreadFactory(factory);
        asyncTaskExecutor.setCorePoolSize(1);
        asyncTaskExecutor.setMaxPoolSize(1);
        asyncTaskExecutor.setAllowCoreThreadTimeOut(true);
        asyncTaskExecutor.setQueueCapacity(10);
        asyncTaskExecutor.setKeepAliveSeconds(3);
        asyncTaskExecutor.setDaemon(true);
        asyncTaskExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                log.error("转MQ处理");
                executorFailSendMQ(r);
            }
        });
        asyncTaskExecutor.initialize();


    }

    private void executorFailSendMQ(Runnable r){
        FutureTask task = (FutureTask) r;
        Student student = null;
        //从线程池失败中获取student对象
        try {
            Field callableField = task.getClass().getDeclaredField("callable");
            callableField.setAccessible(true);
            Callable callable = (Callable) callableField.get(task);

            Field taskField = callable.getClass().getDeclaredField("task");
            taskField.setAccessible(true);
            AsyncSaveTask asyncSaveTask = (AsyncSaveTask) taskField.get(callable);

            student = asyncSaveTask.getStudent();
        }catch (Exception e){
            log.error("executorFailSendMQ error",e);
        }
        if(student != null){
            log.info("executorFailSendMQ send ={}",student.toString());
            //重新发送mq
        }else{
            log.error("executorFailSendMQ null");
        }
    }
    public static void main(String[] args){

        ThreadPoolRejectTest test = new ThreadPoolRejectTest();
        test.init();
        ThreadPoolTaskExecutor asyncTaskExecutor = test.asyncTaskExecutor;
        for(int i =0; i < 4; i ++){
            AsyncSaveTask saveTask =  new AsyncSaveTask(new Student(i,"hello"+i));
            asyncTaskExecutor.execute(saveTask);


        }

    }




}
