package com.wh.demo.spring.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@NoArgsConstructor
@SuperBuilder
public class UserLifecycle extends User implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    @PostConstruct
    public void postConstruct() {
        System.out.println("UserLifecycle->PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("UserLifecycle->PreDestroy");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("UserLifecycle->beanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("UserLifecycle->name:" + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("UserLifecycle->destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserLifecycle->afterPropertiesSet");
    }
}
