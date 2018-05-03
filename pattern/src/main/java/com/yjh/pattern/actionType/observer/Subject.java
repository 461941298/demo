package com.yjh.pattern.actionType.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: yjh
 * Date: 2018/5/3 21:19
 * Desc: 抽象被观察者
 */
public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObjects();

}

interface Observer {

    void receive();
}


