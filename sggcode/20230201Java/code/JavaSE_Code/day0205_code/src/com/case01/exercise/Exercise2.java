package com.case01.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-16:17
 * @Version: 1.0
 */
public class Exercise2 {
    public static void main(String[] args) {
        //2、从键盘输入两个整数，求它们的和、差、乘积、商、余数
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个整数:");
        int num1 = scanner.nextInt();
        System.out.print("请输入一个整数:");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        int sub = num1 - num2;
        int mul = num1 * num2;
        int div = num1 / num2;
        int del = num1 % num2;

        System.out.println(num1 + "+" + num2 + "=" + sum);
        System.out.println(num1 + "-" + num2 + "=" + sub);
        System.out.println(num1 + "*" + num2 + "=" + mul);
        System.out.println(num1 + "/" + num2 + "=" + div);
        System.out.println(num1 + "%" + num2 + "=" + del);

    }
}
