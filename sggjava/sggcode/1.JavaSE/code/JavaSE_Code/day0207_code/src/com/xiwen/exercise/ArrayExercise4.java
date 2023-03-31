package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-15:04
 * @Version: 1.0
 */
public class ArrayExercise4 {
    public static void main(String[] args) {
        /**
         * （1）已知平年12个月每个月的总天数是{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,31}，
         * （2）从键盘输入年，月，日，分别用year，month，day变量接收
         * （3）计算这一天是这一年的第几天。
         * （4）提示：考虑闰年
         * 闰年的判断标准是：
         * （1）年份year可以被4整除，但不能被100整除
         * （2）或年份year可以被400整除
         */

        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner scanner = new Scanner(System.in);
        int year;
        int month;
        int day;
        boolean b;
        boolean monthFlag;
        boolean dayFlag;
        do {
            System.out.print("请输入年份值:");
            year = scanner.nextInt();
            System.out.print("请输入月份值:");
            month = scanner.nextInt();
            System.out.print("请输入日期值:");
            day = scanner.nextInt();
            // 验证合法
            monthFlag = month <= 0 || month > 12;
            b = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            dayFlag = month == 2 && b && day > 29 || month == 2 && !b && day > 28 || day <= 0;
        } while (monthFlag || dayFlag);

        for (int i = 1; i < month; i++) {
            if (b && i == 2) {
                day += 29;
                continue;
            }
            day += months[i - 1];
        }

        System.out.println(year + "年" + month + "月" + day + "日是第" + day + "天");

    }
}
