package com.xiwen.algorithm.binarysearchnorecursion;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/23 -10:39
 * @Version: 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 10, 11, 67, 100};
        int i = binarySearch(arr, 10);
        System.out.println("i = " + i);

    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
