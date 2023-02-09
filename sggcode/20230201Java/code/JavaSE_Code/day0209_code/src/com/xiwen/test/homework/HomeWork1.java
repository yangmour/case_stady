package com.xiwen.test.homework;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-18:42
 * @Version: 1.0
 */
public class HomeWork1 {
    public static void main(String[] args) {
        /**
         * 案例需求：随机产生10个[1,100]之间的偶数存储到数组中，并按照从小到大排序输出。
         * 开发提示：
         * - 随机产生[1,50]范围内的整数 * 2 就能得到[1,100]之间的偶数
         */
        int[] arr = new int[10];
        for (int i = 1; i <= 10; i++) {
            arr[i - 1] = (int) (Math.random() * 50) * 2;
        }

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
