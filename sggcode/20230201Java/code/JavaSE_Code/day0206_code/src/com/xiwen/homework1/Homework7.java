package com.xiwen.homework1;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-18:28
 * @Version: 1.0
 */
public class Homework7 {
    public static void main(String[] args) {
        /**
         * （1）从键盘输入年、月、日，
         * （2）假设从这一年的1月1日开始执行三天打鱼两天晒网，那么你输入的这一天是在打鱼还是晒网。
         * （3）开发提示：
         * - 先计算这一天是这一年的第几天，即总天数
         * - 再用总天数 % 5（三天打鱼两天晒网的周期），根据结果来判断是打鱼还是晒网
         * （4）每个月总天数：
         * - 平年的2月份有28天，闰年的2月份有29天。
         * - 1月、3月、5月、7月、8月、10月、12月有31天，
         * - 4月、6月、9月、11月有30天。
         * （5）闰年的判断标准是：
         * - 年份year可以被4整除，但不能被100整除
         * - 或者年份year可以被400整除
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入年份:");
        int year = scanner.nextInt();
        System.out.print("请输入月份:");
        int month = scanner.nextInt();
        System.out.print("请输入日期:");
        int day = scanner.nextInt();
        int result = 0;

        if (month > 12) {
            System.out.println("输入错误");
            System.exit(0);
        }

        if (month == 2 && day >= (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28)) {
            System.out.println("输入错误");
            System.exit(0);
        }

        switch (month - 1) {
            case 12:
                result += 31;
            case 11:
                result += 30;
            case 10:
                result += 31;
            case 9:
                result += 30;
            case 8:
                result += 31;
            case 7:
                result += 31;
            case 6:
                result += 30;
            case 5:
                result += 31;
            case 4:
                result += 30;
            case 3:
                result += 31;
            case 2:
                result += year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
            case 1:
                result += 31;
            default:
                result += day;
        }

        switch (result % 5) {
            case 3:
            case 2:
            case 1:
                System.out.println("打鱼!");
                break;
            case 4:
            case 0:
                System.out.println("筛网!");
                break;

        }

    }
}
