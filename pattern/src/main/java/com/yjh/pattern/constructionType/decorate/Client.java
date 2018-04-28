package com.yjh.pattern.constructionType.decorate;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/27 15:28
 * Version: 1.0
 * Desc: 装饰模式
 */
public class Client {

    public static void main(String[] args) {

        /**
         * 装饰者模式的作用在于: 动态的扩展原有对象的功能
         *
         * 有如下几个角色:
         * 1. 主题(可以被扩展的部分的一个抽象表现) Change72
         * 2. 被装饰者(没什么好解释的) Monkey
         * 3. 装饰者(装饰者可以作为一个抽象类并拥有一个被装饰者对象, 装饰者 与 被装饰者 都实现 主题 接口) SuperMonkey
         * 4. 具体饰者(动态添加的具体功能) Fish, Bird(如果猴子要变成cat, 只要加一个Cat类并继承 SuperMonkey 就好了, 不用修改原代码)
         *
         * java中的IO就是采用了装饰者模式
         */
        Monkey monkey = new Monkey();
        monkey.change();

        SuperMonkey fish = new Fish(monkey);
        fish.change();

        SuperMonkey bird = new Bird(fish);
        bird.change();
    }
}
