package com.yjh.pattern.actionType.command;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 17:41
 * Version: 1.0
 * Desc:
 */
public interface Command {

    void exe();
}

class OnCommand implements Command {

    private TV tv = new TV();

    @Override
    public void exe() {
        tv.on();
    }
}

class OffCommand implements Command {

    private TV tv = new TV();

    @Override
    public void exe() {
        tv.off();
    }
}
