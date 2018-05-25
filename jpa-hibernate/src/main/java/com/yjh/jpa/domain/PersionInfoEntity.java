package com.yjh.jpa.domain;

import javax.persistence.*;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/5/25 18:05
 * Version: 1.0
 * Desc:
 */
@Entity
@Table(name = "my_persion_info")
public class PersionInfoEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", length = 32, nullable = false)
    private String name;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "mobile", length = 32)
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
