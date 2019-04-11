package com.wh.demo.lock;

public class SynchronizedThisDemoTest {

    private SynchronizedThisDemo synchronizedThisDemoA = new SynchronizedThisDemo();

    private SynchronizedThisDemo synchronizedThisDemoB = new SynchronizedThisDemo();

    private void test() {

        Thread threadA = new Thread(() -> {
            try {
                synchronizedThisDemoA.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A");

        Thread threadB = new Thread(() -> {
            try {
                synchronizedThisDemoB.sayWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B");

        Thread threadC = new Thread(() -> {
            try {
                synchronizedThisDemoA.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C");

        Thread threadD = new Thread(() -> {
            try {
                synchronizedThisDemoB.sayWorld();
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
        SynchronizedThisDemoTest synchronizedThisDemoTest = new SynchronizedThisDemoTest();
        synchronizedThisDemoTest.test();
    }

}
