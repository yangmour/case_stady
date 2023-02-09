package com.xiwen.test.homework;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-20:38
 * @Version: 1.0
 */
public class Homework9 {
    public static void main(String[] args) {
        /**
         * 案例需求：随机产生10个[0,100）之间整数存储到数组中，找出数组中的两个元素x和y，使得(x - y)绝对值最小。
         * 开发提示：
         * - 将数组进行排序
         * - 求相邻元素的差，差值最小值就是最短距离
         */
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 100);
            arr[i] = random;
        }
        /**
         * 偷个懒快排
         */
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int sub = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            sub = arr[i] - arr[i - 1];
            int r = arr[i + 1] - arr[i];
            if (r < sub) {
                sub = r;
            }
        }

        System.out.println("插值最小的是:" + sub);


    }
}
