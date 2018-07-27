package com.yjh.springMVC.service;

import com.yjh.springMVC.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("yjh");
        userEntity.setPassword("321");
        return userEntity;
    }
}
