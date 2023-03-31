package com.xiwen.homework;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-19:15
 * @Version: 1.0
 */


public class HomeWorkArrayTools3 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 4, 5};
        int sum = sum(arr);
        System.out.println("sum = " + sum);

        int max = max(arr);
        System.out.println("max = " + max);

        sort(arr);
        int index = indexOf(arr, 3);
        System.out.println("index = " + index);

        int lastIndex = lastIndexOf(arr, 3);
        System.out.println("lastIndex = " + lastIndex);

        sort(arr);
        int valueCount = valueCount(arr, 3);
        System.out.println("valueCount = " + valueCount);

        String arrStr = toString(arr);
        System.out.println("arrStr = " + arrStr);

        reverse(arr, 0, arr.length - 1);
        arrStr = toString(arr);
        System.out.println("arrStr = " + arrStr);

        int[] newArr = copyOf(arr, arr.length);
        String newStr = toString(newArr);
        System.out.println("newStr = " + newStr);

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        boolean flag = equals(arr1, arr2);
        if (flag) {
            System.out.println("两个数组相等!");
        } else {
            System.out.println("数组不相等！");
        }


        fill(arr, 1, 3, 11);
        System.out.println(Arrays.toString(arr));
    }

    private static void fill(int[] arr, int start, int end, int value) {
        for (int i = start; i < end; i++) {
            arr[i] = value;
        }
    }

    private static boolean equals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;

    }

    private static int[] copyOf(int[] arr, int length) {
        int[] result = new int[length];

        for (int i = 0; i < (Math.min(arr.length, length)); i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private static int valueCount(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        int flag = -1;
        while (left <= right || value < arr[0] || value > arr[arr.length - 1]) {
            // 升级一点
            int mid = left + (right - left) / 2;
            if (arr[mid] == value) {
                flag = mid;
                break;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (flag == -1) {
            return 0;
        } else {
            left = flag - 1;
            right = flag + 1;
            int count = 1;
            while (arr[left] == value) {
                count++;
                left--;
            }

            while (arr[right] == value) {
                right++;
                count++;
            }
            return count;
        }
    }

    private static int lastIndexOf(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        int flag = -1;
        while (left <= right || value < arr[0] || value > arr[arr.length - 1]) {
            // 升级一点
            int mid = left + (right - left) / 2;
            if (arr[mid] == value) {
                flag = mid;
                break;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (flag == -1) {
            return 0;
        } else {
            right = flag + 1;
            while (arr[right] == value) {
                right++;
            }

            return right - 1;
        }

    }

    private static void reverse(int[] arr, int left, int right) {
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


    private static String toString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + (i < arr.length - 1 ? "," : "");
        }
        str += "]";
        return str;
    }

    private static void sort(int[] arr) {
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


    private static int indexOf(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        int flag = -1;
        while (left <= right || value < arr[0] || value > arr[arr.length - 1]) {
            // 升级一点
            int mid = left + (right - left) / 2;
            if (arr[mid] == value) {
                flag = mid;
                break;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (flag == -1) {
            return 0;
        } else {
            left = flag - 1;
            while (arr[left] == value) {
                left--;
            }

            return left + 1;
        }
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int max(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }

        return arr[max];
    }

}
