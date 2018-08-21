package com.yjh.study.config;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("within(com.yjh.study..*))")
    public void common(){
        System.out.println("common ---------");
    }
}
