package com.xiwen.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-18:14
 * @Version: 1.0
 */
public class HomeWork1 {
    public static void main(String[] args) {

        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        Scanner scanner = new Scanner(System.in);
        int month;
        do {
            System.out.print("请输入月份值:");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);

        System.out.println(months[month-1]);

    }
}
