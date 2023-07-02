package com.xiwen.juc.day02.helper;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/02 -15:02
 * @Version: 1.0
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        //new CountDownLatch(int count) //实例化一个倒计数器，count指定初始计数
        //countDown() // 每调用一次，计数减一
        //await() //等待，当计数减到0时，阻塞线程（可以是一个，也可以是多个）并行执行

        // 初始化计数器，初始计数为6
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    // 每个同学墨迹几秒钟
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + " 同学出门了");
                    // 调用countDown()计算减1
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        // 调用计算器的await方法，等待6位同学都出来
        countDownLatch.await();

        System.out.println("值班同学锁门了");
    }
}
