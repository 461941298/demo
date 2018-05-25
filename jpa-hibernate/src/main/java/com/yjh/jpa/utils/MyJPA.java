package com.yjh.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/24 18:55
 * Version: 1.0
 * Desc:
 */
public class MyJPA {

    public static EntityManager getManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("yjh.jpa.study");
        return emf.createEntityManager();
    }
}
