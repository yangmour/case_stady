package com.xiwen.juc.day03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AqsDemo {


    public static void main(String[] args) throws InterruptedException {

        DataThree dataThree = new DataThree();
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                dataThree.incr();
                countDownLatch.countDown();
            }, "").start();
        }

        countDownLatch.await();
        System.out.println(dataThree.getNum());
    }
}

class DataThree {

    private volatile int num;
//    Mutex mutex = new Mutex();

    private final Lock lock = new ReentrantLock();

    public void incr() {
        lock.lock();
//        mutex.lock();
        for (int i = 0; i < 1000; i++) {
            num++;
        }
        lock.unlock();
//        mutex.unlock();
    }

    public int getNum() {
        return num;
    }
}