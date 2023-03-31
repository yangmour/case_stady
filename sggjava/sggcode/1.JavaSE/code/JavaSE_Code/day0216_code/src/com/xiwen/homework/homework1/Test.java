package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-19:48
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128;
        int i3 = 128;
        int i4 = 128;
        System.out.println(i1 == i2); //flase
        System.out.println(i3 == i4); //true
        System.out.println(i1 == i3); //true
    }
}
