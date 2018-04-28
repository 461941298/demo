package com.yjh.pattern.constructionType.adaptor;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 11:34
 * Version: 1.0
 * Desc: 适配器模式
 */
public class Client {

    /**
     * 适配器模式是在已有功能不能满足需求时使用的(如: 通过 适配器 将 高压电 变为我们 日常用的220v电)
     * 适配器模式有如下角色
     * 1.被适配者(拥有某种特殊功能,但不能满足当下需求)
     * 2.目标接口(可以满足当下需求的接口)==>适配器模式就是将不能被直接使用的接口变为可以被直接使用的接口
     * 3.适配器(继承自 被适配者, 同时实现 目标接口)(它是整个模式的核心)
     *
     * 总结:
     * 适配器模式更多担当的是一个补救者的角色,所以有系统设计时应尽量避免使用(设计时就用了适配器,那还设计个毛线啊)
     */
    @Test
    public void test1() {
        HV hv = new HV();
        hv.output();

        LV lv = new Adaptor();
        int llv = lv.outputLV();
        System.out.println("低电压是 :　" + llv);

    }
}
