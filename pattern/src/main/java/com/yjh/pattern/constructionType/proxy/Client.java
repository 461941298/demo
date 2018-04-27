package com.yjh.pattern.constructionType.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/27 15:26
 * Version: 1.0
 * Desc: 代理模式
 */
public class Client {

    @Test
    public void test1() {

        //静态代理
        new Agent().sing();
    }

    @Test
    public void test2() {

        //动态代理
        Singer star = new Star();

        Singer singer = (Singer) Proxy.newProxyInstance(
                Star.class.getClassLoader(), //学习的demo中用的是 DynamicStar 拿到的类加载器,但这里用 Star 也行, jvm有关的东西不太懂!
                star.getClass().getInterfaces(), //获取被代理类所实现的所有接口
                new DynamicStar(star) //与被代理对象绑定的InvocationHandler对象
        );

        singer.sing();
    }
}
