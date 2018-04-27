package com.yjh.pattern.constructionType.flyweight;

import org.junit.Test;

public class Client {

    /**
     * 享元模式的主要目的在于:将多个事物间共同的部内拿来共享,从而可以节省内存
     * 它将一些事物视为 1)个各事物间共同的部分(内蕴状态) 2)个各事物之间不同的部分(外蕴状态)
     * 也就是说: 内蕴状态享元自己维护; 外蕴状态客户端存储并通过方法传递给享元
     * <p>
     * 享元模式的主要角色
     * 1. 抽象享元 (Model定义外蕴状态传递方法)
     * 2. 具体享元 (ProfessionalModel Tramp, 觉得具体内蕴重复,可以将重复内蕴放到抽象享元中(抽象类))
     * 3. 享元工厂(这是整个模式的核心)
     * 4. 客户端
     */

    @Test
    public void test1() {
        Clothes clothes1 = new Clothes("红色");
        Clothes clothes2 = new Clothes("绿色");
        Clothes clothes3 = new Clothes("白色");
        Clothes clothes4 = new Clothes("黑色");

        Model model1 = ModelFactory.getProfessonalModel("张亮");
        Model model2 = ModelFactory.getProfessonalModel("张亮");

        System.out.println("model1...");
        model1.wear(clothes1);
        System.out.println("model2...");
        model2.wear(clothes2);
        System.out.println("model1 和 model2 是同一个吗?" + (model1 == model2));

        Model model3 = ModelFactory.getTramp("犀利哥");
        System.out.println("model3...");
        model3.wear(clothes3);
        model3.wear(clothes4);

        Model model4 = ModelFactory.getModel("塑料模特");
        System.out.println("model4...");
        model4.wear(clothes1);
        model4.wear(clothes2);
        model4.wear(clothes3);
        model4.wear(clothes4);
    }
}
