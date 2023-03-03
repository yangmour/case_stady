package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-19:23
 * @Version: 1.0
 */
public class Homework3 {

}

class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I'm A Class");
    }
}

class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("I'm B Class");
    }
}

class TestHelloB {
    public static void main(String[] args) {
        new HelloB();
        //I'm A Class"
        //HelloA
        //I'm B Class
        //HelloB
    }
}
