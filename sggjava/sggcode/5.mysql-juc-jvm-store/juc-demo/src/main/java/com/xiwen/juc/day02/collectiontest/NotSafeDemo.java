package com.xiwen.juc.day02.collectiontest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/02 -14:45
 * @Version: 1.0
 */
public class NotSafeDemo {
    public static void main(String[] args) {
        //list的测试
//        list();

        //set的测试
//        set();
        //map的测试
//        map();

    }

    private static void map() {
        // 多线程下不安全
//        Map<String, String> map = new HashMap<>();
        // 多线程下安全、工具类中使用同步锁。 迭代器没有使用同步锁、读读可多线程
//        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        // 多线程下安全、内部用cas 和 局部同步代码块实现 ☆最优
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void set() {
        // 多线程下不安全
//        Set<String> set = new HashSet<>();
        // 多线程下安全、工具类中使用同步锁。 迭代器没有使用同步锁、读读可多线程
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        // 多线程下安全、内部用CopyOnWriteArrayList类
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void list() {

        // 多线程下不安全
//        List<String> list = new ArrayList<>();
        // 多线程下安全、工具类中使用同步锁。 与Vector的区别是工具类中的迭代器没有使用同步锁、读读可多线程
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        // 多线程下安全、内部用的是写时复制、读写分离思想。 ☆这个最优
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

    }
}
