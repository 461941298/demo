package com.yjh.jpa;

import com.yjh.jpa.domain.RondaEntity;
import org.junit.Test;

import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/25 16:34
 * Version: 1.0
 * Desc:
 */
public class RondaTest extends BaseTest {

    @Test
    public void addTest() {
        // 开启事务
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();

        RondaEntity rondaEntity1 = new RondaEntity();
        rondaEntity1.setName("2018-5-25 15:30");
        rondaEntity1.setPerformanceId(1L);

        RondaEntity rondaEntity2 = new RondaEntity();
        rondaEntity2.setName("2018-5-26 15:30");
        rondaEntity2.setPerformanceId(1L);

        this.entityManager.persist(rondaEntity1);
        this.entityManager.persist(rondaEntity2);

        // 提交事务
        transaction.commit();
    }
}
