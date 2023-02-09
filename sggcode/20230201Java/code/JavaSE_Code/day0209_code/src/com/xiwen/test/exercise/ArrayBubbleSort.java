package com.xiwen.test.exercise;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-11:41
 * @Version: 1.0
 */
public class ArrayBubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 325, 123, 122, 10, 1, 50};

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
