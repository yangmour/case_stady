package com.xiwen.exercise.homework.homework3;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-18:29
 * @Version: 1.0
 */
public class ArrayToolsTest {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 1; i <= 10; i++) {
            arr[i - 1] = (int) (Math.random() * 100);
        }
        ArrayTools.sort(arr);
        System.out.println(ArrayTools.toString(arr));

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数");
        int v = scanner.nextInt();

        int i = ArrayTools.binarySearch(arr, v);
        System.out.println((i == -1 ? "不存在" : i));

        System.out.println(ArrayTools.toString(ArrayTools.copyOf(arr, 5)));
        System.out.println(ArrayTools.toString(ArrayTools.copyOf(arr, 10)));
        System.out.println(ArrayTools.toString(ArrayTools.copyOf(arr, 15)));


        int index = ArrayTools.binarySearch(arr, v);
        if (i < 0) {
            System.out.println("不存在");
            System.out.println(ArrayTools.toString(ArrayTools.binarySearchInsert2(arr, v)));
        } else {
            System.out.println("下标为:" + index);
        }
    }
}
