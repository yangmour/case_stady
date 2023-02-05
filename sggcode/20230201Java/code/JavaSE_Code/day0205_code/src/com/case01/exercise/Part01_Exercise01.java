package com.case01.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-16:04
 * @Version: 1.0
 */
public class Part01_Exercise01 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 0;
        boolean flag = false;
        if (flag == true) {
            c = a++ + b;
        }

        if (flag == false) {
            c = ++a - b;
        }
        System.out.println("a = " + a); // 2
        System.out.println("b = " + b); // 2
        System.out.println("c = " + c); // 0

    }
}
