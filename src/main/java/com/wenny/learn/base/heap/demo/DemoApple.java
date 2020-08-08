package com.wenny.learn.base.heap.demo;

import com.wenny.learn.base.heap.entity.Apple;

public class DemoApple {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            newApple();
        }
        System.out.println("take time:" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void newApple() {
        new Apple();
    }

}
