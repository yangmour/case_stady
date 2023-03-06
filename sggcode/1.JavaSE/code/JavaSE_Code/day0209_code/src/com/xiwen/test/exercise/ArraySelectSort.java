package com.xiwen.test.exercise;

import java.util.Arrays;

/**
 * Description:
 * 选择排序
 *
 * @author: yf
 * @Create: 2023/2/9-14:30
 * @Version: 1.0
 */
public class ArraySelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 325, 123, 122, 10, 1, 50};

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }

            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }


        }
        System.out.println(Arrays.toString(arr));

    }
}
