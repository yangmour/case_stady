package com.xiwen.homework.homework4;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-19:26
 * @Version: 1.0
 */
public class Homework4 {
}

class TestFatherChild {
    public static void main(String[] args) {
        Father f = new Father();
        //father
        Child c = new Child();
        //father
        //child
    }
}

class Father {
    public Father() {
        System.out.println("father");
    }
}

class Child extends Father {
    public Child() {
        System.out.println("child");
    }
}