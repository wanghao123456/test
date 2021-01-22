package com.wh.demo.spring.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class UserInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    private static final String BEAN_NAME = "userLifecycle";

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (BEAN_NAME.equals(beanName)) {
            System.out.println("postProcessBeforeInstantiation->beanClass:" + beanClass + "-beanName:" + beanName);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (BEAN_NAME.equals(beanName)) {
            System.out.println("postProcessAfterInstantiation->bean:" + bean + "-beanName:" + beanName);
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (BEAN_NAME.equals(beanName)) {
            System.out.println("postProcessProperties->pvs:" + pvs + "bean:" + bean + "-beanName:" + beanName);
        }
        return null;
    }
}
