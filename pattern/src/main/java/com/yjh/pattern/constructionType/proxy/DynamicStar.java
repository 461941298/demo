package com.yjh.pattern.constructionType.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/27 16:18
 * Version: 1.0
 * Desc: 利用jdk提供的动态代理技术,就要实现 IvocationHandler
 */
public class DynamicStar implements InvocationHandler {

    private Object subject;

    public DynamicStar(Object proxy) {
        this.subject = proxy;
    }

    /**
     * @param proxy  被代理的真实对象
     * @param method 应该调取被代理对象的哪个方法
     * @param args   方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        // invoke 中 要把真实的 被代理对象作为调用对象参给第一个参数而不是 proxy(坑啊... proxy 放这里干什么的???)
        Object object = method.invoke(subject, args);
        after();
        return object;
    }

    public void before() {
        System.out.println("被调用之前...");
    }

    public void after() {
        System.out.println("被调用之后...");
    }
}
