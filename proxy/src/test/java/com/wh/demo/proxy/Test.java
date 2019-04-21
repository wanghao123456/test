package com.wh.demo.proxy;

import com.wh.demo.proxy.handler.WorkerHandler;
import com.wh.demo.proxy.service.Worker;
import com.wh.demo.proxy.service.impl.WorkerImpl;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        Worker worker = new WorkerImpl();
        worker.work();

        Worker workerProxy = (Worker) Proxy.newProxyInstance(worker.getClass().getClassLoader(), worker.getClass().getInterfaces(), new WorkerHandler(worker));
        workerProxy.work();
    }
}
