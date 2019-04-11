package com.wh.demo.lock;

public class SynchronizedThisDemo {

    synchronized public void sayHello() throws InterruptedException {
        Thread.sleep(10_000);
        System.out.println(Thread.currentThread().getName() + "say:" + "hello" + "->" + System.currentTimeMillis());
    }


    synchronized public void sayWorld() throws InterruptedException {
        Thread.sleep(10_000);
        System.out.println(Thread.currentThread().getName() + "say:" + "world" + "->" + System.currentTimeMillis());
    }

}
