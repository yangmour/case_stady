package com.xiwen.exercise.exercise1.test;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-16:45
 * @Version: 1.0
 */
public class A {
    public static void main(String[] args) {
        // Week w1 = new Week();//Week的构造器私有化了，无法在这里new对象。
        //获取星期一对象
        Week monday = Week.MONDAY;
        System.out.println(monday);
        System.out.println(monday.name());
        System.out.println(monday.ordinal());

        switch (monday){
            case MONDAY:
                System.out.println("最痛苦的一天");
                break;
            case TUESDAY:
                System.out.println("更绝望的一天");
                break;
            //....
        }

        System.out.println("-------------------");
        Week[] values = Week.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println("------------------------");
        Scanner input = new Scanner(System.in);
        System.out.print("请输入枚举常量对象名：");
        String name = input.next();
        Week week = Week.valueOf(name);
        System.out.println("week = " + week);
    }
}
