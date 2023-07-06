package com.xiwen.juc.completablefuturetest;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/06 -15:11
 * @Version: 1.0
 */
public class CompletableFutureUseDemo02 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "come---in");
            int nextInt = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (nextInt > 2) {
                throw new RuntimeException("模拟异常");
            }
            return nextInt;
        }, threadPool).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算的结果:" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常信息:" + e.getMessage());
            return null;
        });

        while (!completableFuture.isDone()) {
            System.out.println(completableFuture.join());
        }

        threadPool.shutdown();
    }
}
