package com.xiwen.method;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-16:27
 * @Version: 1.0
 */
public class MethodArraysToolsExercise11 {
    public static void main(String[] args) {
        /**
         * （1）声明一个数组工具类ArraysTools，包含几个重载方法
         * - 重载方法系列1：可以为int[]，double[]，char[]数组实现从小到大排序
         *   - void sort(int[] arr)
         *   - void sort(double[] arr)
         *   - void sort(char[] arr)
         * - 重载方法系列2：toString方法，可以遍历int[]，double[]，char[]数组，遍历结果形式：[元素1，元素2，。。。]
         *   - String toString(int[] arr)
         *   - String toString(double[] arr)
         *   - String toString(char[] arr)
         * （2）在测试类的main方法中调用
         */
        int[] arr = {1, 3, 4, 5, 10, 2, 6};
        double[] arr2 = {1, 3, 4, 5, 10, 2, 6};
        char[] arr3 = {'1', '3', '4', '5', '9', '2', '6'};

        sort(arr);
        sort(arr2);
        sort(arr3);

        System.out.println(toString(arr));
        System.out.println(toString(arr2));
        System.out.println(toString(arr3));

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

    private static void sort(double[] arr) {

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
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

    private static void sort(char[] arr) {

        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
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
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + (i < arr.length - 1 ? "," : "");
        }
        str += "]";
        return str;
    }

    public static String toString(double[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + (i < arr.length - 1 ? "," : "");
        }
        str += "]";
        return str;
    }

    public static String toString(char[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += "" + arr[i] + (i < arr.length - 1 ? "," : "");
        }
        str += "]";
        return str;
    }
}
