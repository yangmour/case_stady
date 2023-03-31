package com.xiwen.test.homework;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-19:55
 * @Version: 1.0
 */
public class Homework5 {
    public static void main(String[] args) {
        /**
         * 案例需求：已知某个数组中只有1个数字的次数出现奇数次，请找出这个数字。
         * int[] arr = {2,6,2,5,7,1,2,5,6,1,5,6,1,6,5,7,1};
         */
        int[] arr = {2, 6, 2, 5, 7, 1, 2, 5, 6, 1, 5, 6, 1, 6, 5, 7, 1};

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

        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else if (arr[i] != arr[i + 1] && count % 2 == 0) {
                count = 1;
            } else if (count % 2 != 0) {
                System.out.println(arr[i]);
                break;
            }
        }

    }
}
