package com.wenny.learn.base.thread.producer;

import java.util.concurrent.BlockingDeque;

public class Consumer extends Thread {

    private BlockingDeque<Integer> blockingDeque ;

    Consumer(BlockingDeque<Integer> blockingDeque){
        super("consumer");
        this.blockingDeque = blockingDeque;

    }

    @Override
    public void run(){

        try {
            while (true){
                int data = blockingDeque.take();
                System.out.println(getName() + " consumed " + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
