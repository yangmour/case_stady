package com.xiwen.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/10-14:53
 * @Version: 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {3, 9, -1, 30, 20};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));


        // 没优化冒泡排序
        // 临时变量
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        // 优化后的冒泡排序
//        int temp = 0;
//        boolean flag = false;
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//               if (arr[j] > arr[j + 1]) {
//                    flag = true;
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//
//
//            // 在一趟排序一次没换过
//            if (!flag) {
//                break;
//            } else {
//                flag = false;
//            }
//        }
//        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int) (Math.random() * 80000);
        }
        long start = System.currentTimeMillis();

        bubbleSort(arr2);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr2));

        System.out.println("排序时间:" + (end - start));
    }

    private static void bubbleSort(int[] arr) {
        // 临时变量
        // 优化后的冒泡排序
        int temp = 0;
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }


            // 在一趟排序一次没换过
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

    }


}
