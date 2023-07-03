package com.xiwen.juc.day03;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/03 -18:44
 * @Version: 1.0
 */
public class ThreadPool {

    public static void main(String[] args) {

        /**
         * 用工具类容易内存溢出oom
         */
        //单一线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 指定核心数，最大线程数是Integer.max 、队列无界限
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        // 指定核心数，最大线程数是一样的
//        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 最大线程数是Integer.max
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "执行任务逻辑"));
//        }
//
//        executorService.shutdown();

        /**
         * 自定义线程池
         *
         */

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                3, //线程初始核心数
                5, // 最大线程数
                3, // 最大空闲时间、最大线程数大于初始核心数超过这个时间就是销毁
                TimeUnit.SECONDS, // 销毁时间单位
                new ArrayBlockingQueue<>(3),// 阻塞队列
                Executors.defaultThreadFactory(), // 可以默认不写
                /**
                 *   //new ThreadPoolExecutor.AbortPolicy()
                 *   //new ThreadPoolExecutor.CallerRunsPolicy()
                 *   //new ThreadPoolExecutor.DiscardOldestPolicy()
                 *   //new ThreadPoolExecutor.DiscardPolicy()
                 */
//                new ThreadPoolExecutor.AbortPolicy() // 默认拒绝连接策略、可以选择、可以自定义
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("自定义拒绝策略");
                    }
                }
        );

        /**
         * 8个线程对、8个以上出现异常
         * 因为线程初始3个线程  阻塞队列3个  阻塞队列不够 创建线程到最大线程数 5个，总共启用5个线程、阻塞队列3个工8个。
         * 所以大于就会报错
         */
        for (int i = 0; i < 9; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "执行任务逻辑"));
        }

    }
}
