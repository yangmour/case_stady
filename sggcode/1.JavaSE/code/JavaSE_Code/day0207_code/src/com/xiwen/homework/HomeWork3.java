package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-18:36
 * @Version: 1.0
 */
public class HomeWork3 {
    public static void main(String[] args) {
        /**
         * （1）要求使用char数组存储26个英文字母，并分别用正序和逆序方式显示输出。
         * （2）要求每10个字母一行。
         */

        char[] character = new char[26];

        for (int i = 0; i < 26; i++) {
            character[i] = (char) ('a' + i);
        }

        System.out.println("正序");
        for (int i = 1; i <= character.length; i++) {
            System.out.print(character[i - 1] );
            if (i < character.length && !(i % 10 == 0)) {
                System.out.print(",");
            }
            if (i % 10 == 0) {
                System.out.print("\n");
            }
        }

        System.out.println("\n逆序");
        for (int i = character.length, count = 1; i > 0; i--, count++) {
            System.out.print(character[i - 1]);
            if (i > 1 && !(count % 10 == 0)) {
                System.out.print(",");
            }
            if (count % 10 == 0) {
                System.out.print("\n");
            }
        }

    }
}
