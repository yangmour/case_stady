package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-10:29
 * @Version: 1.0
 */
public class Exercise7 {
    public static void main(String[] args) {

        //菱形 全是***的
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /**
         * ******* i=1         i>0 j=1  j = 7
         *  *****  i=2             j=2  j = 5
         *   ***   i=3             j=3  j = 3
         *    *    i=4             j=4  j = 1
         */
        // 下半部分
        for (int i = 1; i < 5; i++) {


            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 9 - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("------这是一条华丽的分割线--------");

        //菱形 *加空格的
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i * 2 - 1; j++) {
                if (j == 1 || j == i * 2 - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        /**
         * *     * i=1         i>0 j=1  j = 7
         *  *   *  i=2             j=2  j = 5
         *   * *   i=3             j=3  j = 3
         *    *    i=4             j=4  j = 1
         */
        // 下半部分
        for (int i = 1; i < 5; i++) {


            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 9 - 2 * i; j++) {
                if (j == 1 || j == 9 - 2 * i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }
}
