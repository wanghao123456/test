package com.wh.demo.spring;

import com.wh.demo.spring.bean.UserLifecycle;
import com.wh.demo.spring.component.UserInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class BeanLifecycleDemo {

    private static void applicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getBeanFactory().addBeanPostProcessor(new UserInstantiationAwareBeanPostProcessor());
        applicationContext.register(BeanLifecycleDemo.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("userLifecycle"));
        applicationContext.close();
    }

    @Bean
    public UserLifecycle userLifecycle() {
        return UserLifecycle.builder().name("wh").age(28).beanSource("javaConfig").build();
    }

    public static void main(String[] args) {
        applicationContext();
    }

}