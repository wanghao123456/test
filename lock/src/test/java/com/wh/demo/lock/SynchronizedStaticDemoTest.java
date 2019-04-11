package com.wh.demo.lock;

public class SynchronizedStaticDemoTest {

    private void test() {

        Thread threadA = new Thread(() -> {
            try {
                SynchronizedStaticDemo.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A");

        Thread threadB = new Thread(() -> {
            try {
                SynchronizedStaticDemo.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B");

        Thread threadC = new Thread(() -> {
            try {
                SynchronizedStaticDemo.sayWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C");

        Thread threadD = new Thread(() -> {
            try {
                SynchronizedStaticDemo.sayWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "D");

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    public static void main(String[] args) {
        SynchronizedStaticDemoTest synchronizedStaticDemoTest = new SynchronizedStaticDemoTest();
        synchronizedStaticDemoTest.test();
    }
}
