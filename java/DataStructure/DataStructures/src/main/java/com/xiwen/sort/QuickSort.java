package com.xiwen.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/12-17:29
 * @Version: 1.0
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {-9, 78, 0, 23, -567, 70};


        int[] arr2 = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            arr2[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

        quickSort(arr2, 0, arr2.length - 1);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr2));
        Date date2 = new Date();

        System.out.println(simpleDateFormat.format(date1));
        System.out.println(simpleDateFormat.format(date2));

        System.out.println("排序时间:" + (end - start));

    }


    /**
     * 快速排序
     * arr 数组
     * left 左下标
     * right 右下标
     */
    private static void quickSort(int[] arr, int left, int right) {

        // 可移动的下标赋值
        int l = left;
        int r = right;
        //确定一个中间值
        int pivot = arr[(left + right) / 2];

        int temp = 0;

        // 当l<r的时候就进行排序
        while (l < r) {
            // 找出左边值比中值大的数就停止
            while (arr[l] < pivot) {
                l++;
            }

            // 找出右边边值比中值小的数就停止
            while (arr[r] > pivot) {
                r--;
            }

            // 如果 l大于等于r说明已经排序完成了
            if (l >= r) {
                break;
            }

            // 进行交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果有相同的值情况下
            if (pivot == arr[l]) {
                r--;
            }
            if (pivot == arr[r]) {
                l++;
            }
        }

        // 如果r == l将两个值r左移l右移 防止死循环
        if (r == l) {
            r--;
            l++;
        }


        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }


    }


}
