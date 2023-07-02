package com.xiwen.juc.day02.locktest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/02 -14:15
 * @Version: 1.0
 */

class ShareDataTwo {
    private final Lock lock = new ReentrantLock();
    private Integer flag = 1; // 1:打印五次，2:打印10次，3:打印15
    // 配钥匙
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "AA" + (i + 1));
            }

            flag = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (flag != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "BB" + (i + 1));
            }

            flag = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void print15() {

        lock.lock();
        try {
            while (flag != 3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "CC" + (i + 1));
            }

            flag = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadOrderAccess {
    public static void main(String[] args) {

        /**
         * 案例：
         * 多线程之间按顺序调用，实现A->B->C。三个线程启动，要求如下：
         * AA打印5次，BB打印10次，CC打印15次
         * 接着
         * AA打印5次，BB打印10次，CC打印15次
         * 。。。打印
         * 10轮
         */

        ShareDataTwo shareDataTwo = new ShareDataTwo();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareDataTwo.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareDataTwo.print10();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareDataTwo.print15();
            }
        }, "CC").start();

    }
}
