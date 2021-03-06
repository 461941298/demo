package com.yjh.jpa.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/24 18:45
 * Version: 1.0
 * Desc: 演出
 */
@Entity
@Table(name = "my_performance")
public class PerformanceEntity {
    private Long id;
    private String title;
    private List<RondaEntity> rondas;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", length = 64, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "performance")
    public List<RondaEntity> getRondas() {
        return rondas;
    }

    public void setRondas(List<RondaEntity> rondas) {
        this.rondas = rondas;
    }
}
