package com.xiwen.juc.day01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/30 -18:32
 * @Version: 1.0
 */

class A {
    public synchronized final void outer() {
        inner();
    }

    private synchronized void inner() {
        System.out.println("一些操作");
    }
}

class B {
    private final Lock lock = new ReentrantLock();

    public final void outer() {
        lock.lock();
        inner();
        lock.unlock();
    }

    private void inner() {
        lock.lock();
        System.out.println("一些操作2");
        lock.unlock();
    }
}
class C {
    private final Lock lock = new ReentrantLock();

    public final void outer() {
        lock.lock();
        inner();
        lock.unlock();
    }

    private synchronized void inner() {
        System.out.println("一些操作3");
    }
}
public class LockDemo04 {
    //可重入锁 synchronized和ReetrantLock都是可冲入锁

    /**
     * Java中的synchronized关键字和ReentrantLock类都提供了可重入的锁机制。
     * 无论是使用synchronized关键字还是ReentrantLock类，当一个线程获得了锁之后，可以再次请求该锁而不会发生死锁。
     * 需要注意的是，可重入性是针对同一个线程的，不同线程之间的锁请求仍然会相互阻塞，除非使用可重入锁的机制。
     */
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        new Thread(a::outer).start();
        new Thread(b::outer).start();
        new Thread(c::outer).start();


    }
}
