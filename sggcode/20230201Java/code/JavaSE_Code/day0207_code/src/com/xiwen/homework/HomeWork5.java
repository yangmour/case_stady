package com.xiwen.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-18:59
 * @Version: 1.0
 */
public class HomeWork5 {
    public static void main(String[] args) {

        /**
         * **案例需求**：假设张三从1990年1月1日开始执行三天打鱼两天晒网
         * ，5天一个周期，风雨无阻，那么李四想要找张三玩，需要从键盘输入年，月，日后
         * ，判断这一天张三是在打鱼还是晒网。
         */

        int year = 1990;
        int month = 1;
        int day = 1;

        int[] commonYearDays = {365, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYearDays = {366, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days;
        boolean flag = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        System.out.println(flag);

        if (flag) {
            days = leapYearDays[0];
        } else {
            days = commonYearDays[0];
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份值:");
        year = scanner.nextInt();
        boolean r;
        boolean p;
        do {
            System.out.print("请输入月份值:");
            month = scanner.nextInt();
            System.out.print("请输入日期:");
            day = scanner.nextInt();

            //验证
            flag = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            r = month == 2 && flag && day > 29;
            p = month == 2 && !flag && day > 28;
        } while (month < 0 || month > 12 || day < 1 || r || p);

        // 平年闰年都用arr
        int[] arr;
        if (flag) {
            arr = leapYearDays;
        } else {
            arr = commonYearDays;
        }

        for (int i = 1; i < month; i++) {
            days += arr[i];
        }

        System.out.println(days);
        int dayFlag = days % 5;
        if (dayFlag == 4 || dayFlag == 0) {
            System.out.println("晒网！");
        } else {
            System.out.println("打鱼！");

        }


    }
}
