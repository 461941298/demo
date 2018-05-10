package com.yjh.pattern.actionType.state;

/**
 * Author: yjh
 * Date: 2018/5/10 23:11
 * Desc: 水位监测器
 */
public class Monitor {

    private State state;

    public Monitor(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void report() {
        if (null == this.state) {
            System.out.println("未监测到数据");
        } else {
            System.out.println("监测器监测到:" + state.describe());
        }

    }
}
