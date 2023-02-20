package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-18:48
 * @Version: 1.0
 */
public class Homework14 {
    //test ok and gbc


}

class Example {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Example ex = new Example();//ex.str = good   ex.ch=  abc

        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//good + and + gbc
        System.out.print(ex.ch);
    }

    public void change(String str, char[] ch) {//形参和实参指向同一个数组
        str = "test ok";//字符串对象不可变，形参的修改，和实参无关
        ch[0] = 'g';//形参对元素的修改，直接修改的是实参元素的值
    }
}