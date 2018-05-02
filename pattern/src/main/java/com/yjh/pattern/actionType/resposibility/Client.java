package com.yjh.pattern.actionType.resposibility;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 9:38
 * Version: 1.0
 * Desc: 责任链模式
 */
public class Client {

    /**
     *  责任链模式其实就是通过链表数据结构实现的，
     *  它省略了if-esle-的判断，将所有具体的判断都放到了具体的类中来实现
     *
     *  责任链模式中的角色：
     *  1. 抽象请求处理类（持有一个抽象请求类的成员变量）
     *  2. 具体请求处理类
     *
     *  所有具体请求处理类，最终组成一个请求处理链
     */

    RequestHandler numberHandler = new NumberType();
    RequestHandler stringHandler = new StringType();
    RequestHandler objectHandler = new ObjectType();

    @Test
    public void test1(){

        RequestHandler requestHandler = numberHandler;
        numberHandler.setRequestHandler(stringHandler);
        stringHandler.setRequestHandler(objectHandler);

        requestHandler.handleRequest(7);
    }
}
