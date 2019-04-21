package com.wh.demo.annotation;

public class User {

    @ParamCheck(type = ParamType.STRING)
    private String name;
    @ParamCheck(type = ParamType.STRING)
    private String sex;
    @ParamCheck(type = ParamType.BO)
    private User1 user1;

    public User(String name, String sex, User1 user1) {
        this.name = name;
        this.sex = sex;
        this.user1 = user1;
    }
}
