package com.xiwen.homework.homework3;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-23:32
 * @Version: 1.0
 */
public class Homework3 {
    public static void main(String[] args) {
        // 将原始数据存入集合
        ArrayList<String> global = new ArrayList<>();
        global.add("《教父》");
        global.add("《肖申克的救赎》");
        global.add("《辛德勒的名单》");
        global.add("《公民凯恩》");
        global.add("《卡萨布兰卡》");
        global.add("《教父续集》");
        global.add("《七武士》");
        global.add("《星球大战》");
        global.add("《美国美人》");
        global.add("《飞跃疯人院》");

        ArrayList<String> china = new ArrayList<>();
        china.add("《霸王别姬》");
        china.add("《大闹天宫》");
        china.add("《鬼子来了》");
        china.add("《大话西游》");
        china.add("《活着》");
        china.add("《饮食男女》");
        china.add("《无间道》");
        china.add("《天书奇谭》");
        china.add("《哪吒脑海》");
        china.add("《春光乍泄》");

        global.stream()
                .limit(3)
                .forEach(System.out::println);
        System.out.println();
        china.stream()
                .skip(china.size() - 5)
                .forEach(System.out::println);
        System.out.println();
        Stream.concat(global.stream().limit(5), china.stream().limit(5))
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();

        Stream.concat(global.stream(), china.stream())
                .map(v -> new Film(v))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
