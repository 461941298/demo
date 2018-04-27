package com.yjh.pattern.createType.factory.factoryMethod;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/25 11:56
 * Version: 1.0
 * Desc: 工厂方法
 */
public class Client {

    @Test
    public void test1() {
        Factory factory = new MonkeyFactory();
        Person wuKong = factory.getPerson();
        System.out.println(wuKong instanceof Monkey);
        System.out.println(wuKong instanceof Pig);
    }
}
