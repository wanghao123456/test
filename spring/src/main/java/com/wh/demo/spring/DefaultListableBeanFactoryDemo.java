package com.wh.demo.spring;

import com.wh.demo.spring.bean.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class DefaultListableBeanFactoryDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlResourcePath = "/user-bean.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}
