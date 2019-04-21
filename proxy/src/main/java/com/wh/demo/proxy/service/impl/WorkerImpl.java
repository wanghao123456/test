package com.wh.demo.proxy.service.impl;

import com.wh.demo.proxy.service.Worker;

public class WorkerImpl implements Worker {
    @Override
    public void work() {
        System.out.println("working");
    }
}
