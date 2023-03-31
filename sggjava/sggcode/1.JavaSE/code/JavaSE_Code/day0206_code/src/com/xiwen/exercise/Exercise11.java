package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-14:31
 * @Version: 1.0
 */
public class Exercise11 {
    public static void main(String[] args) {
        /**
         * 从键盘输入年，月，日，
         * 请计算这一天是这一年的第几天？
         * 例如：输入的是2023年9月3日，这一天是2023年的第?天
         * 提示：
         * （1）每个月
         * 31,28或29,31,30,31,30,31,31,30,31,30,31
         * （2）闰年
         * A：年份值可以被4整除但不能被100整除
         * B：或年份值可以被400整除
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年:");
        int year = scanner.nextInt();

        System.out.println("请输入月:");
        int month = scanner.nextInt();

        System.out.println("请输入日:");
        int day = scanner.nextInt();

        if (month > 12) {
            System.out.println("输入错误");
            System.exit(0);
        }

        if (month == 2 && day >= (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28)) {
            System.out.println("输入错误");
            System.exit(0);
        }
        int result = 0;
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

        System.out.println("这是" + year + "年的第" + month + "月" + day + "日是这一天的" + result + "天");

    }
}
