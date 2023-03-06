package com.xiwen.homework.homework2;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-18:53
 * @Version: 1.0
 */
public class Homework1 {
    public static void main(String[] args) {
        //案例需求：反转键盘录入的字符串。

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串:");
        String str = scanner.next();

        StringBuilder reverse = new StringBuilder(str).reverse();
        System.out.println(str + "\n" + reverse);


    }
}
