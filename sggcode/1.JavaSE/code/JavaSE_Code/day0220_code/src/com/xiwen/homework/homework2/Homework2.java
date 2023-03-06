package com.xiwen.homework.homework2;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-18:55
 * @Version: 1.0
 */
public class Homework2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入qq号:");
        String qq = scanner.next();

        boolean matches = qq.trim().matches("^[1-9]\\d{4,5}+");
        System.out.println("这个账号是否正确:" + matches);

    }

}
