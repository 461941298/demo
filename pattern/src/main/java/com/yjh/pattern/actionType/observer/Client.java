package com.yjh.pattern.actionType.observer;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 9:42
 * Version: 1.0
 * Desc: 观察者模式
 */
public class Client {

    /**
     * 观察者模式定义了一种一对多的依赖关系,当被观察者的状态有所改变时可以通知被观察者有所回应
     * <p>
     * 观察者模式中有如下几个角色:
     * 1. 抽象被观察者(持有一个观察者的集合, 并定义了可以 添加/删除 观察者的接口)
     * 2. 抽象观察者
     * 3. 具体被观察者
     * 4. 具体观察者
     */

    @Test
    public void test1() {

        //被观察者发令枪
        Subject gun = new Gun();

        //观察者1运动员
        Observer runner = new Runner();
        //观察者2摄影师
        Observer shooter = new Shooter();

        //将观察者1/2,订阅被观察者
        gun.add(runner);
        gun.add(shooter);

        //被观察者状态改变发出通知
        gun.notifyObjects();
    }
}
