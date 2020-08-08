package com.wenny.learn.base.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class RunnableQueueDemo {

    private final LinkedList<Runnable> taskQueue = new LinkedList<>();

    public Runnable getTask() throws InterruptedException {

        synchronized (taskQueue){
            while(taskQueue.isEmpty()){
               log.info(Thread.currentThread().getName() + " says task queue is empty. i will wait");
                taskQueue.wait();
            }

        }
        return taskQueue.removeFirst();

    }

    public void addTask(Runnable runnable){
        synchronized (taskQueue){
            taskQueue.add(runnable);
            taskQueue.notifyAll();
        }

    }
}
