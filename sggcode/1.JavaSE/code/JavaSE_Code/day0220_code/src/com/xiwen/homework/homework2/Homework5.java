package com.xiwen.homework.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-19:33
 * @Version: 1.0
 */
public class Homework5 {
    public static void main(String[] args) {
        //案例需求：如果一个字符串，从前向后读和从后向前读
        // ，都是一个字符串，称为回文串，比如mom，dad，noon。

        String s = "noon";
        StringBuilder stringBuilderReverse = new StringBuilder(s).reverse();

        if (s.equals(stringBuilderReverse.toString())) {
            System.out.println(s + "是回文字符");
        }

    }
}
