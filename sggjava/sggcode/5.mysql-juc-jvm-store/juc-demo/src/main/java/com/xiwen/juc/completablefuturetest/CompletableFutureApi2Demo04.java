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
public class CompletableFutureApi2Demo04 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> exceptionally = CompletableFuture.supplyAsync(() -> {
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
        }).thenAccept(v -> { // 接受任务的处理结果，并消费处理，无返回结果 thenAccept
            System.out.println(v);
        }).exceptionally(e -> {

            System.out.println(e.getMessage());
            return null;
        });
        exceptionally.join();

        System.out.println("----------------------");
        /**
         *   ○ 对比补充
         *     ■ thenRun(Runnable runnable) :任务A执行完执行B，并且不需要A的结果
         *     ■ thenAccept(Consumer action): 任务A执行完执行B，B需要A的结果，但是任务B没有返回值
         *     ■ thenApply(Function fn): 任务A执行完执行B，B需要A的结果，同时任务B有返回值
         */
        System.out.println(CompletableFuture.supplyAsync(() -> "result").thenRun(() -> {}).join());//null
        System.out.println(CompletableFuture.supplyAsync(() -> "result").thenAccept(r -> System.out.println(r)).join());//result null
        System.out.println(CompletableFuture.supplyAsync(() -> "result").thenApply(f -> f + 2).join());//result2

        threadPool.shutdown();
    }


}
