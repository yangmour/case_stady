package com.xiwen.homework.homework2.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:26
 * @Version: 1.0
 */
public class MyArrays {
    public static <T> void method(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
