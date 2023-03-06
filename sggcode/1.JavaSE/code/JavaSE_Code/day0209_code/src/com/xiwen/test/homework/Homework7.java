package com.xiwen.test.homework;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-20:25
 * @Version: 1.0
 */
public class Homework7 {
    public static void main(String[] args) {
        /**
         * 案例需求：现有一个长度为10的整数数组{26,67,49,38,52,66,7,71,56,87}。
         * 现在需要对元素重新排列，使得所有的奇数保存到数组左边，所有的偶数保存到数组右边
         */
        int[] arr = {26, 67, 49, 38, 52, 66, 7, 71, 56, 87};
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            while (arr[left] % 2 != 0) {
                left++;
            }
            while (arr[right] % 2 == 0) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
