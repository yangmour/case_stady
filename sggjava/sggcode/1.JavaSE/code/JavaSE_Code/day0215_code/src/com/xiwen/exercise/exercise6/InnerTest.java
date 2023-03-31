package com.xiwen.exercise.exercise6;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-15:25
 * @Version: 1.0
 */
public class InnerTest {
    public static void main(String[] args) {
        Outer.Inner in = new Sub();
        in.method();//输出 hello inner
    }
}

class Outer {
    abstract class Inner {
        abstract void method();
    }
}

class Sub extends Outer.Inner {

//    static Outer outer = new Outer();

    public Sub() {
//        outer.super();
        new Outer().super();
    }

    @Override
    void method() {
        System.out.println("hello inner");
    }
}
