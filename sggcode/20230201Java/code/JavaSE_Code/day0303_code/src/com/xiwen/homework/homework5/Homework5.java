package com.xiwen.homework.homework5;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-19:26
 * @Version: 1.0
 */
public class Homework5 {
}
class HelloA{
    public HelloA(){
        System.out.println("HelloA");
    }
    {
        System.out.println("I'm A Class");
    }
    static{
        System.out.println("static A");
    }
}

 class HelloB extends HelloA{
    public HelloB(){
        System.out.println("HelloB");
    }
    {
        System.out.println("I'm B Class");
    }
    static{
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new HelloB();
        //有点晕
        //static A
        //static B
        //I'm A Class
        //HelloA
        //I'm B Class
        //HelloB
    }

}