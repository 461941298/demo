package com.yjh.jpa.test;

import com.yjh.jpa.domain.PerformanceEntity;
import com.yjh.jpa.utils.MyJPA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.spi.PersistenceUnitInfo;
import java.util.UUID;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/25 11:20
 * Version: 1.0
 * Desc:
 */
public class PerformanceTest {

    private EntityManager entityManager;

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

    @Test
    public void addTest(){
        PerformanceEntity performanceEntity1 = new PerformanceEntity();
        entityManager.persist(performanceEntity1);
    }


}
