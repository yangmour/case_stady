package com.xiwen.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/30 -18:39
 * @Version: 1.0
 */
class A2 {
    public final Lock lock = new ReentrantLock();

    public final void outer() {
        try {
            boolean tryLock = lock.tryLock(3, TimeUnit.SECONDS);
            if (tryLock) {
                System.out.println("限时等待");
                lock.unlock();
            } else {
                System.out.println("获取锁失败！");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

public class LockDemo05 {
    public static void main(String[] args) {

        // 限时等待
        /**
         * 也就是通过我们的tryLock方法来实现，可以选择传入时间参数，表示等待指定的时间，
         * 无参则表示立即返回锁申请的结果：true表示获取锁成功，false表示获取锁失败。我们可以将这种方法用来解决死锁问题。
         */
        A2 a2 = new A2();
        new Thread(a2::outer).start();


    }
}
