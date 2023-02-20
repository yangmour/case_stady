package com.xiwen.homework.homework2;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-19:56
 * @Version: 1.0
 */
public class Homework8 {
    public static void main(String[] args) {
        //案例需求：已知一个字符串内容如下，要求拆分出每一个单词，并遍历显示
        String str = "1.hello2.world3.java4.string";
        String[] split = str.split("[^a-z]*");
        System.out.println(Arrays.toString(split));
    }
}
