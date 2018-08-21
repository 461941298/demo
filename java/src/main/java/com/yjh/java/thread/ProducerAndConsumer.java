package com.yjh.java.thread;

public class ProducerAndConsumer {

    // true 表示生产者不用工作
    public static boolean isEmpty = true;
    public static Object lock = new Object();

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    @Override
    public void run() {

        synchronized (ProducerAndConsumer.lock) {
            while (true) {
                if (!ProducerAndConsumer.isEmpty) {
                    try {
                        ProducerAndConsumer.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("producer...");
                ProducerAndConsumer.isEmpty = false;
                ProducerAndConsumer.lock.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {

    @Override
    public void run() {
        synchronized (ProducerAndConsumer.lock) {
            while (true) {

                if (ProducerAndConsumer.isEmpty) {
                    try {
                        System.out.println("black is empty");
                        ProducerAndConsumer.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consumer...");
                ProducerAndConsumer.isEmpty = true;
                ProducerAndConsumer.lock.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
