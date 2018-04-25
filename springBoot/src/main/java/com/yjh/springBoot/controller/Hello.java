package com.yjh.springBoot.controller;

import com.yjh.springBoot.Application;
import com.yjh.springBoot.component.A;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/25 15:03
 * Version: 1.0
 * Desc:
 */
@RestController
public class Hello implements CommandLineRunner {

    //    @Autowired
    A a;

    {

    }

    @GetMapping("/")
    public String hello() {
        String str = null;
        assert  str != null;
        System.out.println(a);
        a.test();
        System.out.println(a);
        return "hello world";
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        a = context.getBean(A.class);
    }
}
