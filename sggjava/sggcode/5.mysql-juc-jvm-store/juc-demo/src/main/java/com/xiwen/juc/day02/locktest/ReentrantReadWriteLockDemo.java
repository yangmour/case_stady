package com.xiwen.juc.day02.locktest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/01 -16:25
 * @Version: 1.0
 */

class MyCache {

    private volatile HashMap<String, String> cacheMap = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String k, String v) throws InterruptedException {
        //上写锁
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " -> 开始写入数据!");
        TimeUnit.SECONDS.sleep(3);
        cacheMap.put(k, v);
        System.out.println(Thread.currentThread().getName() + " -> 写入数据完成!");
        //解写锁
        lock.writeLock().unlock();
    }

    public void get(String k) throws InterruptedException {
        //上读锁
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " -> 开始读取数据!");
        TimeUnit.SECONDS.sleep(3);
        String v = cacheMap.get(k);
        System.out.println(Thread.currentThread().getName() + " -> 读取数据完成: " + v);
        //解读锁
        lock.readLock().unlock();
    }

    /**
     * 降锁级(不可升级锁)
     * 锁降级就是从写锁降级成为读锁。在当前线程拥有写锁的情况下，再次获取到读锁，随后释放写锁的过程就是锁降级。
     */
    public void test() {
        lock.writeLock().lock();
        System.out.println("获取到写锁。。。。");
        lock.readLock().lock();
        System.out.println("获取到读锁----------");
        lock.writeLock().unlock();
        System.out.println("释放写锁==============");
        lock.readLock().unlock();
        System.out.println("释放读锁++++++++++++++++");
    }

}

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {


        MyCache myCache = new MyCache();


        /**
         * 读写锁使用测试
         * 在读线程非常多，写线程很少的情况下，很容易导致写线程“饥饿”，
         * 虽然使用“公平”策略可以一定程度上缓解这个问题，但是“公平”策略是以牺牲系统吞吐量为代价的。
         */
//        start(myCache);

        /**
         * 读写锁降级锁使用测试
         */
        myCache.test();

    }

    private static void start(MyCache myCache) {
        // 五个线程写
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    myCache.put(String.valueOf(i), String.valueOf(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // 五个线程读
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    myCache.get(String.valueOf(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }


}
