package com.wh.demo.annotation;

public enum ParamType {

    BO("自定义BO"),
    STRING("字符串"),
    INTEGER("整数");


    ParamType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
