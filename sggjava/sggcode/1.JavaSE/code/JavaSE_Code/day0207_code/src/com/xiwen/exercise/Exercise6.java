package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-10:27
 * @Version: 1.0
 */
public class Exercise6 {
    public static void main(String[] args) {
        /**
         * 九九乘法表
         */

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }

    }
}
