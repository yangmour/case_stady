package com.xiwen.homework.homework2;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-19:23
 * @Version: 1.0
 */
public class Homework4 {
    public static void main(String[] args) {
        //案例需求：定义数组，存入多个字符串。删除长度大于5的字符串，打印删除后的数组。
        String[] arr = {"helloworld", "java", "chai", "atguigu", "lin", "yan", "I love you"};
        int count = arr.length;
        for (int i = 0; i < count; ) {
            if (arr[i].length() > 5) {
                System.arraycopy(arr, i + 1, arr, i, arr.length - i - 1);
                count--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(arr, count)));

    }
}
