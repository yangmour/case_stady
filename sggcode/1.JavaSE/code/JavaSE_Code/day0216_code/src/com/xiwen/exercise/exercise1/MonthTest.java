package com.xiwen.exercise.exercise1;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-16:12
 * @Version: 1.0
 */
public class MonthTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("年");
        int year = scanner.nextInt();
        System.out.print("月");
        int monthIn = scanner.nextInt();


        Month month = Month.getByValue(monthIn);

        boolean flag = false;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            flag = true;
        }
        System.out.println(month + "," + month.length(flag));


    }
}
