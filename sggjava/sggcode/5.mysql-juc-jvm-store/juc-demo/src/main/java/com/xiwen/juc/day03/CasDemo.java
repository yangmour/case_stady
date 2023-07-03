package com.xiwen.juc.day03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/03 -19:29
 * @Version: 1.0
 */
public class CasDemo {
    public static void main(String[] args) {

        /**
         * 原子类测试
         * 在JUC下有个atomic包，有很多原子操作的包装类：
         */
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("第一次更新: " + atomicInteger.compareAndSet(0, 100));
        System.out.println("第一次更新后的值:" + atomicInteger.get());
        System.out.println("第二次更新: " + atomicInteger.compareAndSet(0, 200));
        System.out.println("第二次更新后的值:" + atomicInteger.get());
        System.out.println("第三次更新: " + atomicInteger.compareAndSet(100, 300));
        System.out.println("第三次更新后的值:" + atomicInteger.get());

        /**
         * 结果分析
         * 第一次更新：i的值（1）和预期值（1）相同，所以执行了更新操作，把i的值更新为200
         * 第二次更新：i的值（200）和预期值（1）不同，所以不再执行更新操作
         * 第三次更新：i的值（200）和预期值（1）相同，所以执行了更新操作，把i的值更新为300
         */
    }
}
