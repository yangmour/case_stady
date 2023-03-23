package com.xiwen.dataStructures.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/13-14:32
 * @Version: 1.0
 */
public class MergetSort {

    public static void main(String[] args) {

        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];

        mergetSort(arr, 0, arr.length - 1, temp);

        System.out.println(Arrays.toString(arr));

    }

    // 归并排序 (分 + 和)
    private static void mergetSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //进行左递归
            mergetSort(arr, left, mid, temp);

            //进行右递归
            mergetSort(arr, mid + 1, right, temp);

            //进行合并

            merge(arr, left, mid, right, temp);
        }

    }

    // 归并排序(和)

    /**
     * 合并方法
     *
     * @param arr   原始数组
     * @param left  左下标
     * @param mid   中间下标
     * @param right 右下标
     * @param temp  合并的临时数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {


        // 比较左下标中的数据和中间下表的数据大小依次按照顺序将数据放入temp中
        int l = left;
        int m = mid + 1;
        int t = 0;

        // 当left 或者mid小于临界点就说明一半已经赋值完成了
        while (l <= mid && m <= right) {

            // 比较大小 将小的放入temp中
            if (arr[l] <= arr[m]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[m++];
            }
        }

        // 将剩下没有被赋值的数据添加到temp中
        while (l <= mid) {
            temp[t++] = arr[l++];
        }

        // 将剩下没有被赋值的数据添加到temp中
        while (m <= right) {
            temp[t++] = arr[m++];
        }


        //将temp元素拷贝到arr中,并不是每次都将元素拷贝

        t = 0;
        int tempLeft = left;

        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

}
