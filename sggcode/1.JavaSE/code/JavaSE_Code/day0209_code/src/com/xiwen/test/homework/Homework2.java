package com.xiwen.test.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-18:52
 * @Version: 1.0
 */
public class Homework2 {
    public static void main(String[] args) {

        /**
         * 案例需求：从键盘输入一个单词，判断它是否是回文单词。
         * 开发提示：
         * - 从键盘输入一个单词，存放到一个String类型的变量word中
         * - 通过word.toCharArray()可以根据字符串word得到一个char[]类型的数组。
         *   其中toCharArray()是String类型提供的系统函数，就像Math.random()等函数一样
         *  ，后面会学到，这里先提前用一下。
         *它的作用就是创建一个char[]数组，并把字符串中的每一个字符依次存储到这个char[]数组中。
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个单词判断是否是回文单词:");
        String word = scanner.next();
        char[] charArray = word.toCharArray();
        int right;
        int left;
        for (left = 0, right = charArray.length - 1; left < charArray.length; left++, right--) {
            if (charArray[left] != charArray[right]) {
                break;
            }
        }

        if (left > right) {
            System.out.println("是回文单词");
        } else {
            System.out.println("不是回文单词");
        }

    }
}
