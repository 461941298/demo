package com.yjh.jpa.domain;

import javax.persistence.*;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/25 16:28
 * Version: 1.0
 * Desc: 场次
 */
@Entity
@Table(name = "my_ronda")
public class RondaEntity {
    private Long id;
    private String name;
    private PerformanceEntity performance;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 64, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "performance_id", foreignKey = @ForeignKey)
    public PerformanceEntity getPerformance() {
        return performance;
    }

    public void setPerformance(PerformanceEntity performance) {
        this.performance = performance;
    }
}
