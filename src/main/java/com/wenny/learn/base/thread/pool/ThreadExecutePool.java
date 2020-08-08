package com.wenny.learn.base.thread.pool;

import javafx.concurrent.Worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadExecutePool {

    //线程任务什么时候应该被打断 interrupt
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while(true) {
            // 提交多个线程任务，并执行
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running ..");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }



}
