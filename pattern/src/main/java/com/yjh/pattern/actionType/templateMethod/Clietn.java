package com.yjh.pattern.actionType.templateMethod;

import com.sun.javafx.logging.JFRPulseEvent;
import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 9:42
 * Version: 1.0
 * Desc: 模板方法模式
 */
public class Clietn {

    /**
     * 模板方法模式定义了一个算法的骨架,而将一些具体一的算法延迟到了子类中去实现
     *
     * 抽象类App,模拟操作系统为App留下的接口
     * 当一个app要运行时,
     * 1.由操作系统为其分配各种资源
     * 2.app运行
     * 3.app运行完,归还所有资源,并释放内存
     */
    @Test
    public void test1(){
        App myapp = new MyApp();
        myapp.runApp();
    }

}
