package com.xiwen.exercise2;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-16:57
 * @Version: 1.0
 */
public class Exercise5 {
    public static void main(String[] args) {
        /**
         * 5、声明变量balance并初始化为0，用以表示银行账户的月，下面通过ATM机程序实现存款，取款等功能。
         * ---------ATM-------
         * 	1、存款
         * 	2、取款
         * 	3、显示余额
         * 	4、退出
         * 请选择：
         */

        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        int num;
        do {
            System.out.println("---------ATM-------");
            System.out.println("1、存款");
            System.out.println("2、取款");
            System.out.println("3、显示余额");
            System.out.println("4、退出");
            System.out.println("请选择：");
            num = scanner.nextInt();
            double money;
            switch (num) {
                case 1:
                    System.out.print("请输入你要存的钱数:");
                    money = scanner.nextDouble();
                    balance += money;
                    break;
                case 2:
                    System.out.print("请输入你要取的钱数:");
                    money = scanner.nextDouble();
                    balance -= money;
                    break;
                case 3:
                    System.out.println("您的余额为:" + balance);
                    break;
            }

        } while (num != 4);

    }
}
