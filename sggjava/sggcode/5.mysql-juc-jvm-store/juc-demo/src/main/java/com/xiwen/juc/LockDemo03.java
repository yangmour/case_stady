package com.xiwen.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/30 -18:22
 * @Version: 1.0
 */

class Ticket2 {
    private Integer number = 30;
    //首先看一下JUC的重磅武器—— 锁（Lock）
    //相比同步锁，JUC包中的Lock锁的功能更加强大，它提供了各种各样的锁（公平锁，非公平锁，共享锁，独占锁……），所以使用起来很灵活。
//    private final Lock lock = new ReentrantLock();

    //测试公平锁
    private final Lock lock = new ReentrantLock(true);

    public Integer getNumber() {
        return number;
    }

    public void sale() {
        // 手动加锁
        lock.lock();
        try {
            if (number <= 0) {
                System.out.println("票已售罄！！！");
                return;
            }
            try {
                System.out.println(Thread.currentThread().getName() + "开始买票，当前票数：" + number);
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "买票结束，剩余票数：" + --number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            // 手动解锁
            lock.unlock();
        }
    }
}

class LockDemo03 {

    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        }, "C").start();
    }

}
