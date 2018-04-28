package com.yjh.pattern.actionType.command;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/28 17:44
 * Version: 1.0
 * Desc:
 */
public class Controller {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand() {
        command.exe();
    }
}
