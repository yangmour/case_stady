package com.xiwen.test.exercise;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-10:56
 * @Version: 1.0
 */
public class ArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 325, 123, 122, 10, 1, 50};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = 122;

        int left = 0;
        int right = arr.length - 1;

        int flag = -1;
        while (left <= right) {
            // 普通的
            int mid = (left + right) / 2;
            // 升级一点
            mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                flag = mid;
                break;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (flag == -1) {
            System.out.println("未找到");
        } else {
            System.out.println("已找到，下标为:" + flag);
        }
    }
}
