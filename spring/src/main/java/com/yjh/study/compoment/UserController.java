package com.yjh.study.compoment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    @Autowired
    UserService userService;

    public String findAll(){
        return userService.findAll();
    }

    public void findById(){
        System.out.println(userService.findById());
    }
}
