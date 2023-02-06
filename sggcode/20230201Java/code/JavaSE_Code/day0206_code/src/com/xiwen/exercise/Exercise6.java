package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-9:12
 * @Version: 1.0
 */
public class Exercise6 {
    public static void main(String[] args) {
        //6、编写程序：由键盘输入三个整数分别存入变量num1、num2、num3，实现从小到大输出三个整数。
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个整数");
        int num1 = scanner.nextInt();
        System.out.print("请输入第二个整数");
        int num2 = scanner.nextInt();
        System.out.print("请输入第三个整数");
        int num3 = scanner.nextInt();

        if (num1 <= num2 && num2 <= num3) {
            System.out.println(num1 + "<=" + num2 + "<=" + num3);
        } else if (num1 <= num3 && num3 <= num2) {
            System.out.println(num1 + "<=" + num3 + "<=" + num2);
        } else if (num2 <= num3 && num3 <= num1) {
            System.out.println(num2 + "<=" + num3 + "<=" + num1);
        } else if (num2 <= num1 && num1 <= num3) {
            System.out.println(num2 + "<=" + num1 + "<=" + num3);
        } else if (num3 <= num1 && num1 <= num2) {
            System.out.println(num3 + "<=" + num1 + "<=" + num2);
        } else {
            System.out.println(num3 + "<=" + num2 + "<=" + num1);
        }

    }
}
