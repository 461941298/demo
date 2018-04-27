package com.yjh.pattern.createType.factory.simpleFacotry;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/27 14:57
 * Version: 1.0
 * Desc:
 */
public class PersonFactory {

    public static Person getPerson(Class zlass) {
        try {
            return (Person) zlass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("人物获取失败");
    }
}
