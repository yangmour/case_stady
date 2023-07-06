package com.xiwen.juc.completablefuturetest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/06 -15:19
 * @Version: 1.0
 */
public class CompletableFutureMallDemo03 {

    private static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("tb"),
            new NetMall("tm"),
            new NetMall("sph"),
            new NetMall("1688")
    );

    // 串获取数据
    public static List<String> getPrice(List<NetMall> netMalls, String bookName) {
        return netMalls.stream().map(netMall ->
                String.format(bookName + " in %s price is %s", netMall.getName(), netMall.getPrice())
        ).collect(Collectors.toList());

    }

    // 并行异步取数据
    public static List<String> getPriceCompletableFuture(List<NetMall> netMalls, String bookName) {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        // 异步获取数据
        List<CompletableFuture<String>> completableFutures = netMalls.stream().map(netMall ->
                CompletableFuture.supplyAsync(
                        () -> String.format(bookName + " in %s price is %s", netMall.getName(), netMall.getPrice())
                        , threadPool)
        ).collect(Collectors.toList());
        // 通过流获取数据
        return completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

    }

    public static void main(String[] args) {

        // 串行的执行时间
        long start1 = System.currentTimeMillis();
        List<String> list1 = getPrice(list, "mysql");
        list1.forEach(System.out::println);
        long end1 = System.currentTimeMillis();
        System.out.println("串行执行时间:" + (end1 - start1) + "毫秒");


        // 异步的执行时间
        long start2 = System.currentTimeMillis();
        List<String> list2 = getPrice(list, "mysql");
        list2.forEach(System.out::println);
        long end2 = System.currentTimeMillis();
        System.out.println("异步执行时间:" + (end2 - start2) + "毫秒");
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
class NetMall {
    private String name;

    public Double getPrice() {
        return ThreadLocalRandom.current().nextDouble() * 2 + name.charAt(0);
    }

}
