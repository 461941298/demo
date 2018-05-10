package com.yjh.pattern.actionType.state;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 9:45
 * Version: 1.0
 * Desc: 状态模式
 */
public class Client {


    /**
     * 使用场景:
     * 1.当一个对象的行为严重依赖于它所处的状态时,可以考虑使用状态模式
     * 2.当一个对象的方法中依赖多重条件转移语句(其中有大量代码)时,可以考虑使用状态模式
     * <p>
     * 状态模式有如下几个角色:
     * 1.抽象状态
     * 2.具体状态
     * 3.环境(持有一个状态成员变量)
     */

    @Test
    public void test1() {
        State shallow = new Shallow();
        State middle = new Middle();
        State deep = new Deep();

        Monitor monitor = new Monitor(shallow);
        monitor.report();
        monitor.setState(middle);
        monitor.report();
        monitor.setState(deep);
        monitor.report();
        monitor.setState(null);
        monitor.report();
    }
}
