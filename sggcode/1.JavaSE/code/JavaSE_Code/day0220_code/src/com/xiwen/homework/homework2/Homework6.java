package com.xiwen.homework.homework2;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-19:36
 * @Version: 1.0
 */
public class Homework6 {
    public static void main(String[] args) {
        //案例需求：有一个字符串String abc = “342567891”
        // ，请写程序将字符串abc进行升序，可以使用JDK API中的现有的功能方法。
        String abc = "342567891";
        char[] charArray = abc.toCharArray();
        Arrays.sort(charArray);
        System.out.println(charArray);

    }
}
