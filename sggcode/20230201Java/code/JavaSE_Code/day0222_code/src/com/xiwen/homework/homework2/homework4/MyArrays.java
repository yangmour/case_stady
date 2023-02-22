package com.xiwen.homework.homework2.homework4;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-19:28
 * @Version: 1.0
 */
public class MyArrays {
    public static <T> void reverse(T[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }
}
