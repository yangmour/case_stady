package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-14:55
 * @Version: 1.0
 */
public class ArrayExercise3 {
    public static void main(String[] args) {
        /**
         * （1）用一个数组存储26个英文字母的小写形式a-z
         * （2）遍历显示小写字母以及它对应的大写字母，例如：a->A，b->B，c->C等
         * （3）提示：小写字母'a'对应编码值是97，字母'b'对应编码值是98，依次类推
         *           大写字母'A'对应编码值是65，字母'B'对应编码值是66，依次类推
         */

        char[] letters = new char[26];

        for (int i = 0; i < 26; i++) {
            letters[i] = (char) ('a' + i);
        }
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i] + "->" + (char) (letters[i] - 32) + ",");
        }

    }
}
