package com.wh.demo.spring.component;

import org.springframework.context.Lifecycle;

public class ApplicationContextLifecycle implements Lifecycle {

    private boolean running = false;

    @Override
    public void start() {
        running = true;
        System.out.println("context-start");
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("context-stop");
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
