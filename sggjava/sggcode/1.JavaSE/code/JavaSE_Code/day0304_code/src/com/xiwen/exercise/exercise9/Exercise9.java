package com.xiwen.exercise.exercise9;

import java.util.function.Function;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-22:54
 * @Version: 1.0
 */
public class Exercise9 {
    //createArray()的作用是，创建一个长度为2的n次方的数组
    public static <R> R[] createArray(Function<Integer, R[]> fun, int length) {
        int n = length - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        length = n < 0 ? 1 : n + 1;
        return fun.apply(length);
    }

    public static void main(String[] args) {
        String[] array = createArray(String[]::new, 10);
        System.out.println(array.length);

    }
}
