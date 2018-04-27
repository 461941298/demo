package com.yjh.pattern.createType.factory.simpleFacotry;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/27 14:56
 * Version: 1.0
 * Desc:
 */
public abstract class Person {

    protected String name;
    protected String arms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArms() {
        return arms;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", arms='" + arms + '\'' +
                '}';
    }
}

class Monkey extends Person {

}

class Pig extends Person {

}
