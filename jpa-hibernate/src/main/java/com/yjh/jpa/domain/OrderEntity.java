package com.yjh.jpa.domain;

import javax.persistence.*;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/25 16:42
 * Version: 1.0
 * Desc:
 */
@Entity
@Table(name = "order")
public class OrderEntity {
    private Long id;
    private String code;
    private Double amount;
    private Double createdTime;
    private Long rondaId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", length = 64, nullable = false, unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "amount", nullable = false)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "created_time", nullable = false)
    public Double getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Double createdTime) {
        this.createdTime = createdTime;
    }

    @Column(name = "ronda_id", nullable = false)
    public Long getRondaId() {
        return rondaId;
    }

    public void setRondaId(Long rondaId) {
        this.rondaId = rondaId;
    }
}
