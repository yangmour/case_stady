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
public class CompletableFutureApi4Demo04 {
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
         * 两个CompletableStage任务都完成后，最终能把两个任务的结果一起交给thenCombine来处理
         * 先完成的先等着，等待其他分支任务
         * 可以合并写在一起，不必拆分
         */
        CompletableFuture<String> result = future1.thenCombine(future2, (f1, f2) -> f1 + "->" + f2);
        System.out.println(result.join());

        threadPool.shutdown();
    }


}
