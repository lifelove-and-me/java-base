package com.wenny.learn.base.thread.producer;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/*
  *Producer Consumer Problem solution using BlockingQueue in Java.
   BlockingQueue not only provide a data structure to store data *
   but also gives you flow control, require for inter thread communication.
  * */
public class ProducerAndConsumer {

    public static  void main(String[] args){
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
         Producer producer = new Producer(blockingDeque);

         Consumer consumer = new Consumer(blockingDeque);

         producer.start();
         consumer.start();

    }


}
