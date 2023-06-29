package com.xiwen.jvm;

public class Student {

    static Student student;
    //  我是构造函数
    public Student(){
        System.out.println("我是构造函数");
    }
    //  finalize() -- Object

    @Override
    protected void finalize() throws Throwable {
        System.out.println("我是finalize....");
        //  有可能会活！
        //  student = new Student();
        super.finalize();
    }

    //  主入口：
    public static void main(String[] args) {
        student = new Student();
        student = null;
        //  調用gc 方法 如果立刻调用 肯定会执行finalize 方法！ 如果没有立刻执行,不会调用.
        System.gc();
        System.out.println("---- main ---- 結束");
    }
    //  我是构造函数   ---- main ---- 結束    我是finalize....
}