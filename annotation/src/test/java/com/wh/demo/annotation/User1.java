package com.wh.demo.annotation;

public class User1 {

    @ParamCheck(type = ParamType.STRING)
    private String name;
    @ParamCheck(type = ParamType.STRING)
    private String sex;

    public User1(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
