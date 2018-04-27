package com.yjh.pattern.constructionType.proxy;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/27 16:09
 * Version: 1.0
 * Desc:
 */
public interface Singer {

    void sing();
}

class Star implements Singer {

    @Override
    public void sing() {
        System.out.println("能不能给我一顿饭的时间...");
    }
}

class Agent implements Singer {

    Star star = new Star();

    @Override
    public void sing() {
        System.out.println("经纪人给歌手吃个盒饭呗!");
        star.sing();
    }
}
