package com.xiwen.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-18:11
 * @Version: 1.0
 */
public class Homework5 {
    public static void main(String[] args) {
        /**
         * （1）定义变量week赋值为上一年最后一天的星期值，例如：2021年12月31日的星期值5，
         * （2）定义变量year、month、day，分别赋值今年（例如：2022年）某一天的年、月、日值。
         * （3）计算这一天是星期几。
         * （4）开发提示
         * - 需要计算这一天是今年（例如：2022年）的第几天，即今年已经过了几天了（总天数）
         * - 再用（总天数 + 5 ）% 7 的结果来判断是星期几
         * （5）每个月总天数：
         * - 平年的2月份有28天，闰年的2月份有29天。
         * - 1月、3月、5月、7月、8月、10月、12月有31天，
         * - 4月、6月、9月、11月有30天。
         * （6）闰年的判断标准是：
         * - 年份year可以被4整除，但不能被100整除
         * - 或者年份year可以被400整除
         */

        int week = 5;
        int year = 2022;
        int month = 1;
        int day = 20;
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

        week = (result + week) % 7;
        switch (week) {
            case 0:
                System.out.println("周日");
                break;
            case 1:
                System.out.println("周一");
                break;
            case 2:
                System.out.println("周二");
                break;
            case 3:
                System.out.println("周三");
                break;
            case 4:
                System.out.println("周四");
                break;
            case 5:
                System.out.println("周五");
                break;
            case 6:
                System.out.println("周六");
                break;
        }

        /**
         * 简答题
         * switch是否能作用在byte上，是否能作用在long上，是否能作用在String上？
         * switch中可以作用在byte、short、int、char，引用类型:String、Enum枚举类型
         */


    }
}
