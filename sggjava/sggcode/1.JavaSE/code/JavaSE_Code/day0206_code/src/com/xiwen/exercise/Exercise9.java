package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-11:55
 * @Version: 1.0
 */
public class Exercise9 {
    public static void main(String[] args) {
        /**
         * 9、编写一个程序，为一个给定的年份找出其对应的中国生肖。
         * 中国的生肖基于12年一个周期，每年用一个动物
         * 代表：monkey（猴）、rooster（鸡）、dog（狗）、pig（猪）、rat（鼠）
         * 、ox（牛）、tiger（虎）、rabbit（兔）、dragon（龙）、snake（蛇）
         * 、horse（马）、sheep（羊）。
         * 提示：2016年 猴 2016%12==0 ， 2017年：鸡   2017 % 12 == 1
         */

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入年份:");
        int year = scanner.nextInt();
        char zodiac = 0;
        switch (year%12){
            case 0:
                zodiac = '猴';
                break;
            case 1:
                zodiac = '鸡';
                break;
            case 2:
                zodiac = '狗';
                break;
            case 3:
                zodiac = '猪';
                break;
            case 4:
                zodiac = '鼠';
                break;
            case 5:
                zodiac = '牛';
                break;
            case 6:
                zodiac = '虎';
                break;
            case 7:
                zodiac = '兔';
                break;
            case 8:
                zodiac = '龙';
                break;
            case 9:
                zodiac = '蛇';
                break;
            case 10:
                zodiac = '马';
                break;
            case 11:
                zodiac = '羊';
                break;
        }

        System.out.println(year + "年的属性是:" + zodiac);

    }
}
