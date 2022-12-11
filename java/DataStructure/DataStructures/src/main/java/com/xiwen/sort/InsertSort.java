package com.xiwen.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/11-11:27
 * @Version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));


        int[] arr2 = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int) (Math.random() * 800000);
        }
        long start = System.currentTimeMillis();

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        insertSort(arr2);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr2));
        Date date2 = new Date();

        System.out.println(simpleDateFormat.format(date1));
        System.out.println(simpleDateFormat.format(date2));

        System.out.println("排序时间:" + (end - start));

    }

    // 插入排序
    private static void insertSort(int[] arr) {

        // 待插入的数
        int insertVal = 0;
        // 前面有序数组的最长下标
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            /**
             * 给insertVal找到插入的位置
             * 1.insertIndex >= 0 保证再给insertVal找插入位置，不越界
             * 2.insertVal < arr[insertIndex] 待插入的数，还没找到插入位置
             * 3.就需要将arr[insertIndex] 后移
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //判断一下是否需要赋值
            if (insertIndex + 1!=i){
                //当退出的时候找到了合适的位置
                arr[insertIndex + 1] = insertVal;
            }

        }

    }
}
