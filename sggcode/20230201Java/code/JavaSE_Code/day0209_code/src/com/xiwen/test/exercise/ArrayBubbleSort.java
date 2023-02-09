package com.xiwen.test.exercise;

import java.util.Arrays;

/**
 * Description:
 * 冒泡排序
 *
 * @author: yf
 * @Create: 2023/2/9-11:41
 * @Version: 1.0
 */
public class ArrayBubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 325, 123, 122, 10, 1, 50};
        int[] arr2 = new int[]{20, 325, 123, 122, 10, 1, 50};
        // 普通版
        long start = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));
        System.out.println("时间为:" + (end - start));

        System.out.println("-------------------");
        // 改进版
        start = System.currentTimeMillis();
        for (int i = 1; i < arr2.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length - i; j++) {
                if (arr2[j] > arr2[j + 1]) {
                    int temp = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr2));
        System.out.println("时间为:" + (end - start));

    }
}
