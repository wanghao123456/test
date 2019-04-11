package com.wh.demo.lock;

public class SynchronizedStaticDemo {

    synchronized static public void sayHello() throws InterruptedException {
        Thread.sleep(10_000);
        System.out.println(Thread.currentThread().getName() + "say:" + "hello" + "->" + System.currentTimeMillis());
    }


    synchronized static public void sayWorld() throws InterruptedException {
        Thread.sleep(10_000);
        System.out.println(Thread.currentThread().getName() + "say:" + "world" + "->" + System.currentTimeMillis());
    }

}
