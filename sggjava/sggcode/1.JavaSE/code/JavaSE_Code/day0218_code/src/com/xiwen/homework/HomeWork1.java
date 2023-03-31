package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/18-14:30
 * @Version: 1.0
 */
public class HomeWork1 {
    public static void main(String[] args) {
        //请使用`Math` 相关的API，计算在 `-10.8`  到`5.9`  之间
        // ，绝对值大于`6`  或者小于`2.1` 的整数有多少个？

        double max = 5.9;
        double min = -10.8;
        int count = 0;

        System.out.println(Math.round(max));
        for (double i = Math.ceil(min); i < max; i++) {
            if (Math.abs(min) > 6 || Math.abs(min) < 2.1) {
                count++;
            }
        }

        System.out.println("个数为" + count);


    }
}
