package com.xiwen.dataStructures.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/11-11:02
 * @Version: 1.0
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();

        selectSort(arr2);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr2));

        System.out.println("排序时间:" + (end - start));

    }

    // 选择排序
    private static void selectSort(int[] arr) {

        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 说明假定的最小值，并不是最小值
                if (min > arr[j]) {
                    min = arr[j]; // 重置
                    minIndex = j; // 重新设置minIndex
                }
            }
            // 如果不等于i就就交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第" + (i+1) + "轮后~~~");
//            System.out.println(Arrays.toString(arr));
        }


    }

}
