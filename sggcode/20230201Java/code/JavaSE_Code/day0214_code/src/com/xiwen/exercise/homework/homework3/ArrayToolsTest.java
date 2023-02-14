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

    }
}
