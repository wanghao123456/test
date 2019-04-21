package com.wh.demo.hotload;

import com.wh.demo.hotload.service.HelloWorld;

import java.lang.reflect.InvocationTargetException;

public class Test {

    private static HotLoadClassLoader hotLoadClassLoader = new HotLoadClassLoader("D:\\Code\\temp\\hotload\\HelloWorldImpl.class");
    private static HotLoadClassLoader hotLoadClassLoader1 = new HotLoadClassLoader("D:\\Code\\temp\\hotload\\HelloWorldImpl.class");

    public static void main(String[] args) {
        try {
            Class helloClass = hotLoadClassLoader.loadClass("com.wh.demo.hotload.HelloWorldImpl");
            HelloWorld helloWorld = (HelloWorld) helloClass.getDeclaredConstructor().newInstance();
            helloWorld.hello();

            Class helloClass1 = hotLoadClassLoader1.loadClass("com.wh.demo.hotload.HelloWorldImpl");
            HelloWorld helloWorld1 = (HelloWorld) helloClass1.getDeclaredConstructor().newInstance();
            helloWorld1.hello();

            if (helloClass != helloClass1) {
                System.out.println("不同的ClassLoader加载同一份字节码得到的Class对象不是同一个。");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
