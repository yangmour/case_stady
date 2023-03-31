package com.case01.test;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-14:29
 * @Version: 1.0
 */
public class DifferenceTypeTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入名字:");
        String name = scanner.next();
        System.out.print("请输入年龄:");
        int age = scanner.nextInt();
        System.out.print("请输入性别:");
        char gender = scanner.next().charAt(0);
        System.out.print("请输入体重:");
        double weight = scanner.nextDouble();

        System.out.println("姓名:" + name + ",年龄:" + age + ",性别:" + gender + ",体重:" + weight);

        scanner.close();

    }
}
