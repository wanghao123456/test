package com.wh.demo.annotation;


import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCheck {

    ParamType type() default ParamType.STRING;

    int length() default 11;

}
