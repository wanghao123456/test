package com.wh.demo.spring;

import com.wh.demo.spring.bean.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class AnnotationConfigApplicationContextDemo {

    /**
     * applicationContext 常用加载 beanDefinition 的方式
     */
    private static void applicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //XML资源加载
        new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("/user-bean.xml");
        //注册配置类
        applicationContext.register(AnnotationConfigApplicationContextDemo.class);
        //手动构建BeanDefinition（手动命名）
        applicationContext.registerBeanDefinition("beanDefinitionBuilder", getUserBeanDefinition());
        //手动构建BeanDefinition（自动命名）
        BeanDefinitionReaderUtils.registerWithGeneratedName(getUserBeanDefinition(), applicationContext);
        System.out.println(applicationContext.getDefaultListableBeanFactory().getBeansOfType(User.class));
        applicationContext.refresh();
        applicationContext.getBeanProvider(User.class).stream().forEach(System.out::print);
        System.out.println();
        System.out.println(applicationContext.getBean("javaConfigUser"));
        applicationContext.close();
    }

    private static AbstractBeanDefinition getUserBeanDefinition() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        return beanDefinitionBuilder.addPropertyValue("name", "wh").addPropertyValue("age", "28")
                .addPropertyValue("beanSource", "beanDefinitionBuilder").getBeanDefinition();
    }

    @Bean
    public User javaConfigUser() {
        return User.builder().name("wh").age(28).beanSource("javaConfig").build();
    }

    public static void main(String[] args) {
        applicationContext();
    }
}
