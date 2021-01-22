package com.wh.demo.spring;

import com.wh.demo.spring.component.ApplicationContextLifecycle;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationContextLifecycleDemo {

    private static void applicationContext() {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        //applicationContext 的生命周期
        applicationContext.registerBeanDefinition("ApplicationContextLifecycle",
                BeanDefinitionBuilder.rootBeanDefinition(ApplicationContextLifecycle.class).getBeanDefinition());
        //applicationContext 的事件监听器，非常丰富的事件种类，覆盖applicationContext 的各个阶段
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationContextEvent>() {
            @Override
            public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
                System.out.println("ApplicationContextEvent-Thread:" + Thread.currentThread().getName()
                        + "-Event:" + applicationContextEvent.toString());
            }
        });
        applicationContext.refresh();
        applicationContext.start();
        applicationContext.stop();
        applicationContext.close();
    }

    public static void main(String[] args) {
        applicationContext();
    }
}
