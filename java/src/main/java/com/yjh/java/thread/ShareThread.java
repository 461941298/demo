package com.yjh.java.thread;

public class ShareThread implements Runnable {

    private int total = 100;

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName());
        while(total >0){
            System.out.println(" " + total--);
        }
    }

    public static void main(String[] args) {
        ShareThread shareThread = new ShareThread();
        Thread thread1 = new Thread(shareThread, "thread1");
        Thread thread2 = new Thread(shareThread, "thread2");
        Thread thread3 = new Thread(shareThread, "thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
