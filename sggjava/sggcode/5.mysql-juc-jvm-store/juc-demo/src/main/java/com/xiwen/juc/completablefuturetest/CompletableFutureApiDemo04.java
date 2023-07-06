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
public class CompletableFutureApiDemo04 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        }, threadPool);

        TimeUnit.SECONDS.sleep(0);
        //计算完成就返回正常值，否则返回备胎值（传入的参数），立即获取结果不阻塞
        System.out.println(completableFuture.getNow(-1));
        //是否打断get方法立即返回括号值
        System.out.println(completableFuture.complete(2) + "->" + completableFuture.join());

        threadPool.shutdown();
    }


}
