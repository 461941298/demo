package com.yjh.pattern.actionType.templateMethod;

/**
 * Author: yjh
 * Date: 2018/5/10 23:34
 * Desc:
 */
public abstract class App {

    private void setUp() {
        System.out.println("操作系统为app分配内存");
        System.out.println("操作系统为app分配IO");
    }

    protected abstract void run();

    protected abstract void shutdown();

    public void runApp() {
        setUp();
        run();
        shutdown();
    }
}

class MyApp extends App{

    @Override
    public void run() {
        System.out.println("Hello World");
    }

    @Override
    public void shutdown() {
        System.out.println("myApp 释放IO");
        System.out.println("myApp 释放内存");
    }
}
