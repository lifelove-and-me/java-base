package com.wenny.learn.base.thread.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class SynchronizeScopeDemo implements Runnable{

    public synchronized  void testA(){

        log.info("==============method ");

    }

    public static  synchronized void testS(){
        log.info("==============method static ");
    }

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,3,
                1L, TimeUnit.MINUTES,new ArrayBlockingQueue<>(3),new ThreadPoolExecutor.AbortPolicy());


        Stream.iterate(1,item -> item + 1).limit(4).forEach(
                item -> {executor.execute(new SynchronizeScopeDemo()); } );

    }


    @Override
    public void run() {
//        testA();
        testS();
    }
}
