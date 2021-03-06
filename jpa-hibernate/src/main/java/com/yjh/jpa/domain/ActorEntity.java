package com.yjh.jpa.domain;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/25 16:46
 * Version: 1.0
 * Desc:
 */
@Entity
@Table(name = "my_actor")
public class ActorEntity {
    private Long id;
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 32, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
