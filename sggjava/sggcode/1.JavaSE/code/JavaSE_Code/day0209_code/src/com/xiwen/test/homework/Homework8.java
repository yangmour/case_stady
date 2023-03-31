package com.xiwen.test.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-20:30
 * @Version: 1.0
 */
public class Homework8 {
    public static void main(String[] args) {
        /**
         * 案例需求：有一个长度为10的整型元素的数组arr，其中有一个元素出现次数超过n / 2，求这个元素。
         * int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
         */
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
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

        int mid = arr.length / 2;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[mid]) {
                count++;
            }
        }

        if (count > mid) {
            System.out.println("数组中个数过半的数为:" + arr[mid] + ",出现次数为:" + count);
        } else {
            System.out.println("数组中不存在个数过半的数字");
        }

    }
}
