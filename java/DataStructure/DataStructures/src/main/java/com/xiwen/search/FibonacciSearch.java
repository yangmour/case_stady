package com.xiwen.search;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/15-20:59
 * @Version: 1.0
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1000, 1000, 1234};
        //Arrays.sort(arr);
        // 数组必须是有序的
        int resIndex = fibSearch(arr, 1234);

        System.out.println(resIndex);

    }


    /**
     * 生成斐波那契数列。
     *
     * @return 返回斐波那契数列
     */
    public static int[] fib() {

        int[] f = new int[20];

        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < 20; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


    /**
     * 斐波那契查找算法
     *
     * @param arr 原数组
     * @param key 要找的值
     * @return 返回对应的下标  没有返回-1
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        // 斐波那契数列
        int[] f = fib();
        // 斐波那契数列下标
        int fIndex = 0;
        // 黄金分割中心值
        int mid = 0;

        // 找到对应的黄金分割的数值
        while (high > f[fIndex] -1 ) {
            fIndex++;
        }

        // 复制一个临时数组
        int[] tempArr = Arrays.copyOf(arr, f[fIndex]);

        // 将多余的为位置复制成arr数组的最后一个数值
        for (int i = high + 1; i < tempArr.length; i++) {
            tempArr[i] = arr[high];
        }

        // 处理key值
        while (low <= high) {
            mid = low + f[fIndex - 1] - 1;
            if (key < tempArr[mid]) {
                high = mid - 1;
                fIndex -= 1;
            } else if (key > tempArr[mid]) {
                low = mid + 1;
                fIndex -= 2;
            } else {

                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }

            }
        }
        return -1;

    }

}
