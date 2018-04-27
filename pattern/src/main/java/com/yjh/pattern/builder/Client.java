package com.yjh.pattern.builder;

import org.junit.Test;

public class Client {

    /**
     * 建造者模式适用于
     * 1. 所要创建的对象非常复杂，往往其内部有好多"零件"(别的对象)
     * 2. 所要创建的对象内部属性在赋值时有一定严格的顺序要求
     * <p>
     * 建造者模式有如下四个角色
     * 1. 抽象产品  Person
     * 2. 抽象构造者 PersonBuilder
     * 3. 具体构造者 MonkeyBuilder, PigBuilder
     * 4. 导演类   Director
     * <p>
     * 分析:
     * 1.建造者模式可以看作是策略模式的一种特殊形式,不同点在于它们关注的业务不同.策略模式关注于算法之间的替换, 建造者模式关注于复杂对象的创建
     * 2.建造者模式中,客户端不需要知道一个对象是怎么创建的,只需要知道是否存在客户端所想要的对象的建造者,如果有则把这个建造者给导演,然后向导演
     * 索要想要得到的对象就好
     * 3.对于第二点的总结: 1) 有点策略模式的味道 2)客户端只和导演类打交道
     * <p>
     * 再次总结
     * 1. 将复杂对象 零件们 的 "赋值" 让 具体的建造者 来完成 (这一部分是变化的)
     * 2. 将复杂对象 零件们 的 "拼装" 让 导演类 来完成 (这一部分是不变化的)
     */

    @Test
    public void test() {

        Person monkey = new Director(new MonkeyBuilder()).getPerson();
        System.out.println(monkey);

        Person pig = new Director(new PigBuilder()).getPerson();
        System.out.println(pig);
    }
}
