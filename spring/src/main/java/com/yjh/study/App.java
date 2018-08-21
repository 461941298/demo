package com.yjh.study;

import com.yjh.study.compoment.UserController;
import com.yjh.study.config.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UserController userController = context.getBean(UserController.class);
//        System.out.println(userController.findAll());
        userController.findById();
    }
}
