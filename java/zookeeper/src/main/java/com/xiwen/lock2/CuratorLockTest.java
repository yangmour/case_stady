package com.xiwen.lock2;

import org.apache.curator.CuratorConnectionLossException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorLockTest {

    public static void main(String[] args) {

        //创建分布式锁
        InterProcessMutex lock1 = new InterProcessMutex(getFrameworkClient(), "/lock");
        InterProcessMutex lock2 = new InterProcessMutex(getFrameworkClient(), "/lock");

        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取锁对象
                try {
                    lock1.acquire();
                    System.out.println("线程 1 获取锁");

                    lock1.acquire();
                    System.out.println("线程 1 获取锁");

                    Thread.sleep(5 * 1000);
                    lock1.release();
                    System.out.println("线程 1 释放锁");
                    lock1.release();
                    System.out.println("线程 1 释放锁");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取锁对象
                try {
                    lock2.acquire();
                    System.out.println("线程 2 获取锁");

                    lock2.acquire();
                    System.out.println("线程 2 获取锁");

                    Thread.sleep(5 * 1000);
                    lock2.release();
                    System.out.println("线程 2 释放锁");
                    lock2.release();
                    System.out.println("线程 2 释放锁");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    //分布式锁初始化
    private static CuratorFramework getFrameworkClient() {

        ExponentialBackoffRetry exponentialBackoffRetry = new ExponentialBackoffRetry(3000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("hadoop102:2181,hadoop103:2181,hadoop104")
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(2000)
                .retryPolicy(exponentialBackoffRetry)
                .build();

        //开启连接
        client.start();

        System.out.println("初始化完成 .... ");
        return client;


    }
}
