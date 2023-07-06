package com.xiwen.juc.completablefuturetest;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/06 -14:57
 * @Version: 1.0
 */
public class CompletableFutureBuildDemo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        //当做普通的Future接口执行异步任务   无返回结果
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "无返回结果");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, threadPool);

        // get有编译时异常
        System.out.println(completableFuture.get());
        // join运行时异常
        System.out.println(completableFuture.join());

        //当做普通的Future接口执行异步任务   有返回结果
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回结果");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello supplyAsync";
        }, threadPool);
        while (!completableFuture2.isDone()) {
            // join运行时异常
            System.out.println(completableFuture2.join());
        }

        threadPool.shutdown();
    }

}
