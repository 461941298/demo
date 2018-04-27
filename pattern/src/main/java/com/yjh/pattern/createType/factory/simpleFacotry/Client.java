package com.yjh.pattern.createType.factory.simpleFacotry;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/25 11:52
 * Version: 1.0
 * Desc: 简单工厂
 */
public class Client {

    @Test
    public void test() {
        Person wuKong = PersonFactory.getPerson(Monkey.class);
        System.out.println(wuKong instanceof Monkey);
        System.out.println(wuKong instanceof Pig);
    }
}
