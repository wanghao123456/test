package com.wh.demo.lock;

public class SynchronizedStaticThisDemoTest {

    private SynchronizedStaticThisDemo synchronizedStaticThisDemoA = new SynchronizedStaticThisDemo();

    private SynchronizedStaticThisDemo synchronizedStaticThisDemoB = new SynchronizedStaticThisDemo();

    private void test() {

        Thread threadA = new Thread(() -> {
            try {
                SynchronizedStaticThisDemo.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A");

        Thread threadB = new Thread(() -> {
            try {
                SynchronizedStaticThisDemo.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B");

        Thread threadC = new Thread(() -> {
            try {
                synchronizedStaticThisDemoA.sayWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C");

        Thread threadD = new Thread(() -> {
            try {
                synchronizedStaticThisDemoA.sayWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "D");


        Thread threadE = new Thread(() -> {
            try {
                synchronizedStaticThisDemoB.sayWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "E");

        Thread threadF = new Thread(() -> {
            try {
                synchronizedStaticThisDemoB.sayWorld();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "F");

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
        threadF.start();
    }


    public static void main(String[] args) {
        SynchronizedStaticThisDemoTest synchronizedStaticThisDemoTest = new SynchronizedStaticThisDemoTest();
        synchronizedStaticThisDemoTest.test();
    }
}
