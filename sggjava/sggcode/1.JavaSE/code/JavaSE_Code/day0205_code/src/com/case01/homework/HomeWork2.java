package com.case01.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-19:11
 * @Version: 1.0
 */
public class HomeWork2 {
    public static void main(String[] args) {
        //从键盘输入一个字符，判断它是字母（a-z或A-A）、数字（0-9)，还是其他字符
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个字符:");
        char c = scanner.next().charAt(0);

        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            System.out.println("当前输入的是字母！");
        } else if (c >= '0' && c <= '9') {
            System.out.println("当前输入的是数字！");
        } else {
            System.out.println("当前输入的是其他字符！");
        }


    }
}
