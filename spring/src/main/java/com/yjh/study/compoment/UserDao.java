package com.yjh.study.compoment;

import com.yjh.study.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public UserEntity findById(){
        return entityManager.find(UserEntity.class, 1L);
    }
}
