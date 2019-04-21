package com.wh.demo.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WorkerHandler implements InvocationHandler {

    private Object object;

    public WorkerHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("go to work");
        Object result = method.invoke(object, args);
        System.out.println("go off work");
        return result;
    }
}
