package com.xiwen.homework;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/18-16:08
 * @Version: 1.0
 */
public class HomeWork3 {

    public static void main(String[] args) {

        int[] arr = {9, 10, 6,6, 6, 1, 9, 3,3,3, 5, 6, 4};
        int count = arr.length;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    /**
                     * 9, 10, 6, 6, 1, 9, 3, 5, 6, 4
                     * 9, 10, 6, 6
                     */
                    System.arraycopy(arr, i + 1, arr, i, count - i - 1);
                    arr[--count] = 0;
                }
            }
        }

        int[] newArr = Arrays.copyOf(arr, count);
        System.out.println(Arrays.toString(newArr));

    }
}
