package com.yjh.pattern.constructionType.bridge;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 9:34
 * Version: 1.0
 * Desc: 桥接模式1
 */
public class Client {

    /**
     * 下面这句话是从网上总结来的:
     * (如果一个 事物存在多个维度(n),且每个维度都有自己不同的变化时(m),应该考虑使用桥接模式, 否则会出现类爆炸的现象 n*m)
     * 有一个疑问: 如果一开始就意识到一个事物的多个维度变化,那么一个开始就将这些维度抽象成接口, 一个对象有多个维护接口的成员变量,那不就万事大吉了吗?
     *
     * 所以感觉:
     * 桥接模式 和 适配器模式 一样,都是一种补救模式
     * 如果已存在一个(抽象类)(有一些代码了), 但是现在又需要从别的维度去扩展它的功能时, 可以考虑桥接模式
     * 这里提到扩展功能,又让我想到 装饰者 模式, 它与装饰者模式的区别在于, 装饰者模式 是事先就考虑到了后续要动态扩展对象的功能,
     * 而 桥接模式 作为一种补救模式,解决的就是事先不知道要扩展对象功能,但后续出现了要扩展不同维度功能的需求.
     *
     * 桥接模式有如下几个角色:
     * 1.抽象角色(最开始时考虑到要创建的对象模型)
     * 2.功能接口(新的需求, 需要新加的不同维度的功能接口)
     * 3.重新定义的抽象角色(继承自抽象角色, 持有一个功能接口的引用, 并通过构造方法或者set方法将功能接口注入,  并重写抽象角色定义的方法)
     * 4.具体功能接口(不用多解释)
     */


    /**
     * 第一版代码:
     * 有一个car抽象类,能 run()
     * 有几个具体实现 Baoma
     * 这些车跑起来都没有问题
     */
    @Test
    public void test1() {
        Car baoma = new Baoma("宝马");
        baoma.run();
    }

    /**
     * 第二版代码
     * 定义一个 新的功能接口 : 档操作, 有两个具体变化: 人工驾驶, 自动驾驶
     * 定义一个 NewCar 类继承自 Car 重写方法
     */
    @Test
    public void test2() {
        NewCar baoma = new NewCar("宝马");
        NewCar aodi = new NewCar("奥迪");
        Operation manOpe = new manOperation();
        Operation auto = new Automate();

        baoma.setOperation(manOpe);
        baoma.run();

        baoma.setOperation(auto);
        baoma.run();

        aodi.run();
        aodi.setOperation(manOpe);
        aodi.run();
    }
}

abstract class Car {

    protected String brandName;

    public Car(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    abstract void run();
}

interface Operation {

    void operation();
}

class Automate implements Operation {

    @Override
    public void operation() {
        System.out.println("自动驾驶...");
    }
}

class manOperation implements Operation {

    @Override
    public void operation() {
        System.out.println("人工驾驶...");
    }
}

class NewCar extends Car {

    protected Operation operation;

    public NewCar(String brandName) {
        super(brandName);
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    void run() {
        if (null != operation) {
            operation.operation();
        }
        System.out.println(brandName + "车跑...");
    }
}

class Baoma extends Car {

    public Baoma(String brandName) {
        super(brandName);
    }

    @Override
    void run() {
        System.out.println(brandName + "跑...");
    }
}
