package com.xiwen.exercise.exercise7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-22:39
 * @Version: 1.0
 */
public class StreamTest {
    @Test
    public void test1() {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        one.stream().filter(s -> s.length() < 3)
                .limit(3)
                .collect(Collectors.toList()).forEach(System.out::println);


        two.stream()
                .filter(s -> s.charAt(0) != '张')
                .skip(2)
                .collect(Collectors.toList()).forEach(System.out::println);

        Stream.concat(one.stream(), two.stream())
                .collect(Collectors.toList()).forEach(System.out::println);


    }
}
