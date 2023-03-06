package com.xiwen.homework1;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-18:07
 * @Version: 1.0
 */
public class Homework4 {
    public static void main(String[] args) {

        // 从键盘输入月份值（1-12），输出对应月份的英语单词，如果月份值超过1-12，提示输入错误！
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入月份数字值：");
        int month = scanner.nextInt();
        String monthStr = "";
        switch (month) {
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "February";
                break;
            case 3:
                monthStr = "March";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "May";
                break;
            case 6:
                monthStr = "June";
                break;
            case 7:
                monthStr = "July";
                break;
            case 8:
                monthStr = "August";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "October";
                break;
            case 11:
                monthStr = "November";
                break;
            default:
                System.out.println("输入错误！");
                System.exit(0);
        }

        System.out.println(month + "对应的英文单词为:" + monthStr);

    }
}
