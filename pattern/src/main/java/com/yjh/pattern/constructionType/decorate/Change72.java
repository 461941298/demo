package com.yjh.pattern.constructionType.decorate;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/27 17:09
 * Version: 1.0
 * Desc:
 */

public interface Change72 {

    void change();
}

abstract class SuperMonkey implements Change72 {

    Monkey monkey;

    public SuperMonkey(Monkey monkey) {
        this.monkey = monkey;
    }
}

class Monkey implements Change72 {

    @Override
    public void change() {
        System.out.println("猴子会72变");
    }
}

class Fish extends SuperMonkey {

    public Fish(Monkey monkey) {
        super(monkey);
    }

    @Override
    public void change() {
        System.out.println("变成鱼在水中游...");
    }
}

class Bird extends SuperMonkey {

    public Bird(Monkey monkey) {
        super(monkey);
    }

    @Override
    public void change() {
        System.out.println("变成鸟在天上飞...");
    }
}