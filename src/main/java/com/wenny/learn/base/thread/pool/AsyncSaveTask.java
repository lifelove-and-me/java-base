package com.wenny.learn.base.thread.pool;

public class AsyncSaveTask implements Runnable {
    private Student student ;

    public AsyncSaveTask(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        System.out.println("AsyncSaveTask thread ={}" + Thread.currentThread().getName());
    }
}
