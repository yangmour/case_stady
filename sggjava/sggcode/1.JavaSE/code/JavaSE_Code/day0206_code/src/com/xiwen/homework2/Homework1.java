package com.xiwen.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-18:53
 * @Version: 1.0
 */
public class Homework1 {
    public static void main(String[] args) {
        int zgf = 8848860;
        int count = 0;
        for (double i = 0.1; i < zgf; i *= 2) {
            count++;
        }
        System.out.println("对折了:" + count + "次");
    }
}
