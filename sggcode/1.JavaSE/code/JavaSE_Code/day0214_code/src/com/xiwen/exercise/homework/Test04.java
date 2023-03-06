package com.xiwen.exercise.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-18:36
 * @Version: 1.0
 */
public class Test04 {

    public static void main(String[] args) {
        new A(new B());// B
                       // A
                       // AB
    }
}

class A {
    public A() {
        System.out.println("A");
    }

    public A(B b) {
        this();
        System.out.println("AB");
    }
}

class B {
    public B() {
        System.out.println("B");
    }
}
