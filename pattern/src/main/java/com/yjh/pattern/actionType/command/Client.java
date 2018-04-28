package com.yjh.pattern.actionType.command;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/27 15:23
 * Version: 1.0
 * Desc: 命令模式
 */
public class Client {

    /**
     * 命令模式将 请求一方 和 接收一方 解耦开
     * <p>
     * 有如下四个角色:
     * 1.接收者(命令执行者) TV
     * 2.抽象命令接口 Command
     * 3.具体命令(实现命令接口)
     * 4.请求者
     * 命令实体拥有一个接收者的成员变量
     *
     * 为什么要使用命令模式???
     */

    @Test
    public void test() {
         Command on = new OnCommand();
         Command off = new OffCommand();
         Controller controller = new Controller();
         controller.setCommand(on);
         controller.runCommand();
         controller.setCommand(off);
         controller.runCommand();
    }
}
