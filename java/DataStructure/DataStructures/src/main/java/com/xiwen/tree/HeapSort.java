package com.xiwen.tree;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2022/12/23-15:59
 * @Version: 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    private static void heapSort(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
            System.out.println(Arrays.toString(arr));
        }

        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }

    }

    /**
     * 将一个数组（二叉树）调整成一个大顶堆
     * 功能:完成将以 i 对应的非叶子节点的树调整为大顶堆
     * 例如 4 6 8 5 9  i=1 adjustHeap => 4 9 8 5 6
     * arr 是要调整的数组
     * i 是非叶子节点的索引
     * length 要调整的元素
     */
    private static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {

            // 先判断左叶子如果小就加一判断右叶子
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            // 如果子节点大于父节点就赋值
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }


}
