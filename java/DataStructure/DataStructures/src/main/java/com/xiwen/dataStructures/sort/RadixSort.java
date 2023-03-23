package com.xiwen.dataStructures.sort;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/13-15:14
 * @Version: 1.0
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    // 基数排序法
    private static void radixSort(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int maxIndex = (max + "").length();

        int[][] bucket = new int[10][arr.length];

        int[] bucketElementCount = new int[10];

        for (int k = 0, n = 1; k < maxIndex; k++, n *= 10) {

            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
                // 放到对应的桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
                bucketElementCount[digitOfElement]++;
            }

            // 按照顺序取出
            int index = 0;

            // 遍历每个桶中的数据
            for (int i = 0; i < bucketElementCount.length; i++) {
                // 如果桶中有数据将放入到原数组中
                if (bucketElementCount[i] != 0) {
                    // 循环该桶放入数组中
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        // 取出元素放入数组
                        arr[index++] = bucket[i][j];
                    }
                }
                // 处理之后 将每个bucketElementCount置零
                bucketElementCount[i] = 0;

            }
        }

        /*

        // 第1轮
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] / 1 % 10;
            // 放到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            bucketElementCount[digitOfElement]++;
        }

        // 按照顺序取出
        int index = 0;

        // 遍历每个桶中的数据
        for (int i = 0; i < bucketElementCount.length; i++) {
            // 如果桶中有数据将放入到原数组中
            if (bucketElementCount[i] != 0) {
                // 循环该桶放入数组中
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    // 取出元素放入数组
                    arr[index++] = bucket[i][j];
                }
            }
            // 处理之后 将每个bucketElementCount置零
            bucketElementCount[i] = 0;

        }

        // 第2轮
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] / 10 % 10;
            // 放到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            bucketElementCount[digitOfElement]++;
        }

        // 按照顺序取出
        index = 0;

        // 遍历每个桶中的数据
        for (int i = 0; i < bucketElementCount.length; i++) {
            // 如果桶中有数据将放入到原数组中
            if (bucketElementCount[i] != 0) {
                // 循环该桶放入数组中
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    // 取出元素放入数组
                    arr[index++] = bucket[i][j];
                }
            }
            // 处理之后 将每个bucketElementCount置零
            bucketElementCount[i] = 0;

        }

        // 第3轮
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] / 100 % 10;
            // 放到对应的桶中
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[i];
            bucketElementCount[digitOfElement]++;
        }

        // 按照顺序取出
        index = 0;

        // 遍历每个桶中的数据
        for (int i = 0; i < bucketElementCount.length; i++) {
            // 如果桶中有数据将放入到原数组中
            if (bucketElementCount[i] != 0) {
                // 循环该桶放入数组中
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    // 取出元素放入数组
                    arr[index++] = bucket[i][j];
                }
            }
            // 处理之后 将每个bucketElementCount置零
            bucketElementCount[i] = 0;

        }
        */

    }

}
