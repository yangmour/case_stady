package com.case01.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-16:24
 * @Version: 1.0
 */
public class Exercise3 {
    public static void main(String[] args) {

        /**
         * 3、用一个year变量保存今年的年份值，并显示今年的总天数
         * 提示：平年有365天，闰年有366天。
         * 闰年的判断标准是：
         * （1）年份year可以被4整除，但不能被100整除
         * （2）或年份year可以被400整除
         */

        int year = 2021;
        int day;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            day = 366;
        } else {
            day = 365;
        }

        System.out.println(year + "总共有:" + day + "天。");

    }
}
