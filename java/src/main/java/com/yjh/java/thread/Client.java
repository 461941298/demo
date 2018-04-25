package com.yjh.java.thread;

import org.junit.Test;

/**
 * Copyright © 2017/12/18 Shanxi WenDao Culture and Technology Co., Ltd. All rights reserved.
 * <p>
 * Author: yjh
 * Date: 2018/4/25 18:02
 * Version: 1.0
 * Desc:
 */
public class Client {

    @Test
    public void threadTest() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new ThreadTest1().start();
        }
    }
}

class ThreadTest1 extends Thread {

    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
