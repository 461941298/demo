package com.yjh.jpa;

import com.yjh.jpa.utils.MyJPA;
import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/25 16:34
 * Version: 1.0
 * Desc:
 */
public class BaseTest {

    protected EntityManager entityManager;

    @Before
    public void setup() {
        this.entityManager = MyJPA.getManager();
    }

    @After
    public void tearDown() {
        if (null != this.entityManager) {
            entityManager.close();
        }
    }
}
