package com.xiwen.exercise.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-18:16
 * @Version: 1.0
 */
public class ArrayTools {
    public static int binarySearch(int[] arr, int value) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return -2;
            }
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int[] copyOf(int[] arr, int newLength) {
        int[] result = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            result[i] = arr[i];
        }
        return result;

    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
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
    }

    public static String toString(int[] arr) {
        String result = "{";

        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + (i < arr.length-1 ? "," : "");
        }
        return result + "}";
    }

}
