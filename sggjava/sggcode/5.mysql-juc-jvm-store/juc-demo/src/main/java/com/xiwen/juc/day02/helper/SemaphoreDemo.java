package com.xiwen.juc.day02.helper;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/02 -15:43
 * @Version: 1.0
 */
public class SemaphoreDemo {
    public static void main(String[] args) {

        /**
         * public Semaphore(int permits) // 构造方法，permits指资源数目（信号量）
         * public void acquire() throws InterruptedException // 占用资源，当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1），要么一直等下去，直到有线程释放信号量，或超时。
         * public void release() // （释放）实际上会将信号量的值加1，然后唤醒等待的线程。
         */
        // 初始化信号量，3个车位
        Semaphore semaphore = new Semaphore(3);

        // 6个线程，模拟6辆车
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    // 抢占一个停车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到了一个停车位！！");
                    // 停一会儿车
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    System.out.println(Thread.currentThread().getName() + " 离开停车位！！");
                    // 开走，释放一个停车位
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();

        }
    }
}
