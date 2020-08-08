package com.wenny.learn.base.thread.producer;

import java.util.concurrent.BlockingDeque;

public class Producer extends Thread {


    private BlockingDeque<Integer> blockingDeque;


     Producer(BlockingDeque<Integer> blockingDeque){
         super("producer");
         this.blockingDeque = blockingDeque;

    }

    @Override
    public void run(){

        for(int i =0; i < 10; i ++){

            try {
                System.out.println(getName() + " produced " + i);
                blockingDeque.put(i);
                sleep(10);//休眠让消费者不至于阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
