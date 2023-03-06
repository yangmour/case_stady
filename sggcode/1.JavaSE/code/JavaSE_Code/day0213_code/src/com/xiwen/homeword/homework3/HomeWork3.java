package com.xiwen.homeword.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-19:08
 * @Version: 1.0
 */
public class HomeWork3 {
}

class Father {
    int age = 0;
    private String name = "atguigu";
}

class Child extends Father {
    public String grade;

    public static void main(String[] args) {
        Child c = new Child();
//        System.out.println(c.name); // 不能通过 private的的成员只能在自己的类中使用
        System.out.println(c.age);
    }
}