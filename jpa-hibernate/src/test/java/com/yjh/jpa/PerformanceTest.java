package com.yjh.jpa;

import com.yjh.jpa.domain.PerformanceEntity;
import org.junit.Test;

import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/25 11:20
 * Version: 1.0
 * Desc:
 */
public class PerformanceTest extends BaseTest {


    @Test
    public void addTest() {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        PerformanceEntity performanceEntity1 = new PerformanceEntity();
        performanceEntity1.setTitle("大河之舞");
        entityManager.persist(performanceEntity1);
        transaction.commit();

        List<PerformanceEntity> performanceEntities = entityManager
                .createQuery("SELECT p FROM PerformanceEntity as p where p.title LIKE '%大河%'")
                .getResultList();

        System.out.println(performanceEntities);
    }


}
