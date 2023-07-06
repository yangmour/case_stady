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
public class CompletableFutureApi1Demo04 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture<Object> exceptionally = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        }, threadPool).thenApply(v -> {
            System.out.println("上一个执行结果:" + v);
            return v + 2;
        }).thenApply(v -> { // 有错误直接报
            System.out.println("上一个执行结果:" + v);
            return v + 3;
        }).handle((v, e) -> { // 有错误也会向下执行
            System.out.println("上一个执行结果:" + v);
            int i = 10 / 0;
            return null;
        }).whenComplete((v, e) -> {
            System.out.println(v);
            if (e == null) {
                System.out.println("上一个执行结果" + v);
            }
        }).exceptionally(e -> {

            System.out.println(e.getMessage());
            return null;
        });
        exceptionally.join();

        threadPool.shutdown();
    }


}
