package com.xiwen.search;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/15-20:40
 * @Version: 1.0
 */
public class InsertValSearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = insertValSearch(arr, 0, arr.length - 1, 1000);
        System.out.println(index);


    }


    /**
     * 插值查找算法
     * 1.首先需要数组有序
     * 2.当left大于right的时候没找到，当findVal小于arr[0]或者findVal大于arr[arr.length-1]是不可能找到
     * 3.mid值计算公式：mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
     * 4.左递归和右递归 返回值
     *
     * @param arr     原数组
     * @param left    数组左下标
     * @param right   数组右下标
     * @param findVal 要查找的值
     * @return 返回查找的值下标
     */
    public static int insertValSearch(int[] arr, int left, int right, int findVal) {

        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (findVal > midVal) {
            return insertValSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
