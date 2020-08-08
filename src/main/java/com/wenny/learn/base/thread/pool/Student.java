package com.wenny.learn.base.thread.pool;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int age;

    public Student(int age,String name){
        this.age = age;
        this.name = name;

    }
}
