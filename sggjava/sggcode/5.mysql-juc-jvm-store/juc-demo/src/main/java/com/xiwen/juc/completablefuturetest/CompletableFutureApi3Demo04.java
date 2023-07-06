package com.xiwen.juc.completablefuturetest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/06 -15:40
 * @Version: 1.0
 */
public class CompletableFutureApi3Demo04 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " A come in");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "A come in";
        }, threadPool);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " B come in");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "B come in";
        }, threadPool);

        /**
         * ● 对计算速度进行选用
         *   ○ 谁快用谁
         *   ○ applyToEither
         */
        CompletableFuture<String> result = future1.applyToEither(future2, f -> f + "快");
        System.out.println(result.join());

        threadPool.shutdown();
    }


}
