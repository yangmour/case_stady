package com.xiwen.homework.homework3;

import java.util.Scanner;

interface Handleable {
    String handleString(String num);
}

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-20:22
 * @Version: 1.0
 */
public class Homework13 {
    //（1）定义Handleable接口，具备一个处理字符串数字的抽象方法方法String handleString(String num);
    //（2）从键盘输入一个double类型的小数，用匿名内部类实现上面的接口，分别把小数处理为
    //* 处理方式1：取整数部分。
    //* 处理方式2：保留小数点后2位，不考虑四舍五入
    //* 处理方式3：保留指定位小数，考虑四舍五入。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String d = scanner.next();
        String d = "12234.12321";

        System.out.println("方式1");
        System.out.println(new Handleable() {

            @Override
            public String handleString(String num) {
                return num.split("\\.")[0];
            }
        }.handleString(d));


        System.out.println("方式2");
        System.out.println(new Handleable() {

            @Override
            public String handleString(String num) {
                String[] split = num.split("\\.");
                if (split.length < 1) {
                    return split[0] + ".00";
                } else {
                    String s = split[1];
                    if (s.length() < 2) {
                        return split[0] + "." + s + "0";
                    } else {
                        return split[0] + "." + s.charAt(0) + s.charAt(1);
                    }
                }

            }
        }.handleString(d));

    }
}
