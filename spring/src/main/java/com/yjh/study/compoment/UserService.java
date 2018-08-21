package com.yjh.study.compoment;

import com.yjh.study.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    UserDao userDao;

    public String findAll() {
        return "user1, user2, user3";
    }

    public UserEntity findById(){
        return userDao.findById();
    }
}
