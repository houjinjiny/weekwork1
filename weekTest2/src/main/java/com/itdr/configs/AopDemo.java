package com.itdr.configs;

import org.springframework.stereotype.Component;

@Component
public class AopDemo {
    public void a(){
        System.out.println("前置通知");
    }
}
