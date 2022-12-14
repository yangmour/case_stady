package com.xiwen.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/14-11:22
 * @Version: 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1000, 1000, 1234};
        //Arrays.sort(arr);
        // 数组必须是有序的
        int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);

        System.out.println(resIndex);

        // 数组必须是有序的
        List<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(integers);

    }

    /**
     * 二分查找法 没有考虑多个相同值情况
     * 思路：
     * 判断left<right的时候
     * 找到中间值，如果要找的值大于中间值就向右递归继续查找
     * 如果要找的值小于中间值就想做递归查找
     * 如果找到了就返回
     *
     * @param arr     原数组
     * @param left    做下标
     * @param right   右下标
     * @param findVal 要找的值
     * @return 返回下标
     */
    private static int binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int value = arr[mid];

        if (findVal > value) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < value) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }


    }

    /**
     * 二分查找法 考虑多个相同值情况
     * 思路：
     * 判断left<right的时候
     * 找到中间值，如果要找的值大于中间值就向右递归继续查找
     * 如果要找的值小于中间值就想做递归查找
     * 如果找到了就在处理一下
     * 向左寻找
     * 向右寻找
     *
     * @param arr     原数组
     * @param left    做下标
     * @param right   右下标
     * @param findVal 要找的值
     * @return 返回下标
     */
    private static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int value = arr[mid];

        if (findVal > value) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < value) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {

            List<Integer> indexList = new ArrayList<>();
            indexList.add(mid);

            int temp = mid - 1;

            while (temp > 0 && findVal == arr[temp]) {
                indexList.add(temp--);
            }

            temp = mid + 1;
            while (temp < arr.length && findVal == arr[temp]) {
                indexList.add(temp++);
            }


            return indexList;
        }


    }

}
