package com.wh.demo.spring.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@NoArgsConstructor
@SuperBuilder
public class UserLifecycle extends User {

    @PostConstruct
    public void init() {
        System.out.println("UserLifecycle->PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserLifecycle->PreDestroy");
    }
}
