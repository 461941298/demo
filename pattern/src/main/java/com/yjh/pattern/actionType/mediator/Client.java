package com.yjh.pattern.actionType.mediator;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 9:40
 * Version: 1.0
 * Desc: 中介者模式
 */
public class Client {

    /**
     * 中介者模式将对象间: 网状的交互拓补图,变为星型的交互拓补图
     * <p>
     * 一组对象(2个或2个以上)的其中一个状态发生改变时,就必须通知其它对象也跟着改变时(其它对象改变时亦然),可以考虑中介者模式
     * <p>
     * 中介者是对对象间交互行为的封装,一旦中介者出现故障(那就玩完了!!)
     * <p>
     * 中介者模式有如下几个角色:
     * 1. 抽象同事
     * 2. 具体同事类
     * 3. 抽象中介者
     * 4. 具体中介者
     * <p>
     * 总结:
     * 实现中的微信就是一个中介者,人们通过微信来交流,并不需要面对面交流(只需要将要交互的内容按照微信的要求填入并操作即可达到交互的目的)
     * http 同样是网络的中介者,它定义了交互的数据结构
     * <p>
     * 可见:中介者其实更像是一种工具,它定义了对象间复杂交互的(1.数据结构 2.交互流程)
     */

    @Test
    public void test1() {
        /**
         * 同事类A,B;要求 无论怎么变都使得 A.number = 2 * B.number 成立
         */
        System.out.println("初始状态");
        test();

        Mediator mediator = new ConcreteMediator();

        A.number = 2;
        System.out.println("A number 变为2后交托给中介者");
        mediator.affect(new A());
        System.out.println("B number 是:" + B.number);
        test();

    }

    private void test() {
        System.out.println("A.number == 2 * B.number ? " + (A.number == 2 * B.number));
    }
}

/**
 * 定义一个抽象同事类
 */
abstract class Colleague {

}

class A extends Colleague {
    public static int number = 0;
}

class B extends Colleague {
    public static int number = 0;
}


/**
 * 定义一个抽象中介者
 */
abstract class Mediator {

    public abstract void affect(Colleague colleague);

}

class ConcreteMediator extends Mediator {

    @Override
    public void affect(Colleague colleague) {
        if (colleague instanceof A)
            B.number = A.number / 2;
        else
            A.number = B.number * 2;

    }
}
