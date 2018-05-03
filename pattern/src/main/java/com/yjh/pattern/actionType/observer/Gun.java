package com.yjh.pattern.actionType.observer;

/**
 * Author: yjh
 * Date: 2018/5/3 21:33
 * Desc: 发令枪
 */
public class Gun extends Subject {
    @Override
    public void notifyObjects() {
        observers.forEach(
                o -> o.receive()
        );
    }
}

class Runner implements Observer{

    @Override
    public void receive() {
        System.out.println("运动员收到信号, 开始奔跑...");
    }
}

class Shooter implements Observer{

    @Override
    public void receive() {
        System.out.println("摄影师开始给运动员拍摄...");
    }
}
