package com.xiwen.homework1;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-18:23
 * @Version: 1.0
 */
public class Homework6 {
    public static void main(String[] args) {
        //（1）从键盘输入年、月、日，
        //（2）要求年份必须是正整数，月份范围是[1,12]，日期也必须在本月总天数范围内，
        //（3）如果输入正确，输出“xxxx年-xx月-xx日”结果，否则提示输入错误。
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入年份:");
        int year = scanner.nextInt();
        System.out.print("请输入月份:");
        int month = scanner.nextInt();
        System.out.print("请输入日期:");
        int day = scanner.nextInt();

        if (year <= 0) {
            System.out.println("输入错误！");
            System.exit(0);
        }
        if (month > 12) {
            System.out.println("输入错误");
            System.exit(0);
        }

        if (month == 2 && day >= (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28)) {
            System.out.println("输入错误");
            System.exit(0);
        }
        System.out.println(year + "年-" + month + "月-" + day + "日");

    }
}
