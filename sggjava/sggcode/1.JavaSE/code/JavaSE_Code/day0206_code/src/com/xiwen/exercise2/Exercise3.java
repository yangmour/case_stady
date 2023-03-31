package com.xiwen.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-15:52
 * @Version: 1.0
 */
public class Exercise3 {
    public static void main(String[] args) {
        /**
         * 3、从1循环到150并在每行打印一个值，另外在每个3的倍数行上打印出“foo”
         * ,在每个5的倍数行上打印“biz”,在每个7的倍数行上打印输出“baz”。例如：
         */

        for (int i = 1; i <= 160; i++) {
            System.out.print(i);
            if (i%3==0){
                System.out.print("\tfoo");
            }
            if (i%5==0){
                System.out.print("\tbiz");
            }
            if (i%7==0){
                System.out.print("\tbaz");
            }
            System.out.println();
        }

    }
}
