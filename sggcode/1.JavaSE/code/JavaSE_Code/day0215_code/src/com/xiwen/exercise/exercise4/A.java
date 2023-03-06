package com.xiwen.exercise.exercise4;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-11:52
 * @Version: 1.0
 */

interface A {
    int x = 0;
    //注意坑  接口中是没有普通的成员变量的，
    //只有public static final的公共静态常量，而且修饰符往往都是省略的
    //这里设置坑的细节，一个是修饰符省略，迷惑性，另一个常量名没有大写，误导性
}

class B {
    int x = 1; //普通的成员变量
}

class C extends B implements A {
    public static void main(String[] args) {
        new C().pX();
    }

    public void pX() {
//        System.out.println(x);//这个x的引用是模糊不清的，B.x和A.x都匹配
        //需要明确是哪个x
        System.out.println(super.x);//B类的 // 要明确哪个父类的值
        System.out.println(A.x);
    }
}
