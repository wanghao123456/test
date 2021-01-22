package com.wh.demo.spring;

import com.wh.demo.spring.bean.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class DefaultListableBeanFactoryDemo {

    private static DefaultListableBeanFactory beanFactory(String xmlResourcePath) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        return beanFactory;
    }

    /**
     * 验证不同的beanFactory独立加载相同的资源，各自生成各自的bean，说明相同定义的单例Bean只在自己的beanFactory中唯一
     */
    private static void hierarchicalBeanFactoryDemo() {
        DefaultListableBeanFactory parentBeanFactory = beanFactory("/user-bean.xml");
        DefaultListableBeanFactory beanFactory = beanFactory("/vipUser-bean.xml");
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println(parentBeanFactory.getBeansOfType(User.class));
        System.out.println(beanFactory.getBeansOfType(User.class));
    }

    /**
     * 验证beanFactory在加载资源时，并不会使用上一层次beanFactory中已有的资源
     */
    private static void hierarchicalBeanFactoryDemo2() {
        DefaultListableBeanFactory parentBeanFactory = beanFactory("/user-bean.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("/vipUser-bean.xml");
        System.out.println(parentBeanFactory.getBeansOfType(User.class));
        System.out.println(beanFactory.getBeansOfType(User.class));
    }


    /**
     * 验证在查找Bean时，当前层次beanFactory不存在时会去上一层次beanFactory中查找，
     * 当前beanFactory存在符合条件的Bean时，即使上一层次beanFactory也存在符合条件的Bean，也不会再去查找。
     */
    private static void hierarchicalBeanFactoryDemo3() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.addPropertyValue("name", "wh").addPropertyValue("age", "28")
                .addPropertyValue("beanSource", "beanDefinitionBuilder").getBeanDefinition();
        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        parentBeanFactory.registerBeanDefinition("parentBeanFactoryUser", beanDefinition);
        DefaultListableBeanFactory beanFactory = beanFactory("/vipUser-bean.xml");
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println(parentBeanFactory.getBeansOfType(User.class));
        System.out.println(beanFactory.getBeansOfType(User.class));
        System.out.println(beanFactory.getBean("parentBeanFactoryUser"));
    }

    public static void main(String[] args) {
        hierarchicalBeanFactoryDemo();
        hierarchicalBeanFactoryDemo2();
        hierarchicalBeanFactoryDemo3();
    }
}
