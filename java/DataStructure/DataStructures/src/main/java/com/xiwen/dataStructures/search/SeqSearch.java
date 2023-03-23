package com.xiwen.dataStructures.search;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/14-11:17
 * @Version: 1.0
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89}; //没有顺序

        int index = seqSearch(arr, -1);

        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到了，下标为 = " + index);
        }

    }

    // 线性查找
    private static int seqSearch(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                return i;
            }
        }

        return -1;

    }

}
