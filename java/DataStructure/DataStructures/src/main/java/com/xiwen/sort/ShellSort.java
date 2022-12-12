package com.xiwen.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/12-15:09
 * @Version: 1.0
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        int[] arr2 = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//        shellSort(arr2);
        shellSort2(arr2);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr2));
        Date date2 = new Date();

        System.out.println(simpleDateFormat.format(date1));
        System.out.println(simpleDateFormat.format(date2));

        System.out.println("排序时间:" + (end - start));

    }

    /**
     * 希尔排序是对插入排序的升级版交换法 (交换法并没有提升,移位法提升很大)
     *
     * @param arr 数组
     */
    private static void shellSort(int[] arr) {

        int count = 0;
        int temp = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {

                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("第"+ (++count) +"轮:" + Arrays.toString(arr));
        }

        /*
        // 第一轮
        int temp = 0;
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {

                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println("第1轮:" + Arrays.toString(arr));


        // 第2轮
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {

                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println("第2轮:" + Arrays.toString(arr));

        // 第3轮
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("第3轮:" + Arrays.toString(arr));

         */


    }

    /**
     * 希尔排序是对插入排序的升级版移位法 (交换法并没有提升,移位法提升很大)
     *
     * @param arr 数组
     */
    private static void shellSort2(int[] arr) {

        int count = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                int j = i;
                int temp = arr[j];

                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {

                        arr[j] = arr[j-gap];
                        j = j - gap;
                    }

                    // 移位完成后需要赋值回去
                    arr[j] = temp;
                }

            }

        }
    }


}
