package com.wenny.learn.base.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchA {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(3);

        new Thread(){public void run() {
            System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
            latch.countDown();
        }}.start();

        new Thread(){ public void run() {
            System.out.println("子线程2"+Thread.currentThread().getName()+"正在执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
            latch.countDown();
        };}.start();
        System.out.println("等待 2 个子线程执行完毕...");
        latch.await();
        System.out.println("2 个子线程已经执行完毕");
        System.out.println("继续执行主线程");

    }
}
