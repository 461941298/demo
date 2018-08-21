package com.yjh.springMVC.config;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut("within(com.yjh.springMVC..*)")
    public void common(){
        System.out.println("common ---------");
    }
}
