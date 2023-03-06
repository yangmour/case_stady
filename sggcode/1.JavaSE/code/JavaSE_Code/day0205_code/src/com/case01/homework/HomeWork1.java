package com.case01.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-19:08
 * @Version: 1.0
 */
public class HomeWork1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个整数:");

        int num = scanner.nextInt();

        if (num != 0 && num % 5 == 0) {
            System.out.println(num + "是5的倍数!");
        }else {
            System.out.println(num + "不是5的倍数!");
        }

        scanner.close();
    }

}
