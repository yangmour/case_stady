package com.xiwen.method;

import java.util.Arrays;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/10-11:53
 * @Version: 1.0
 */
public class MethodExercise4 {
    /**
     * （1）定义一个iterateElement方法，可以实现遍历数组元素，[元素1，元素2，....]
     * （2）定义一个smallToBigSort方法，可以实现给int[]数组实现从小到大排序
     * （3）定义一个reverse方法，可以实现数组元素反转
     * （4）测试
     * A：自行准备一个int[]数组，并输出显示
     * B：调用smallToBigSort方法实现升序排列，并输出显示结果
     * C：调用reverse方法反转，并输出显示结果
     */
    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5, 10, 2, 6};
        iterateElement(arr);
        smallToBigSort(arr);
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));


    }

    private static void reverse(int[] arr) {
        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    private static void smallToBigSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
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

    private static void iterateElement(int[] arr) {
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
