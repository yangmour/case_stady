package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-18:11
 * @Version: 1.0
 */
public class Homework1 {
    //答案:200bcd100100abc
}

class TEXT {
    public int num;
    public String str;

    public TEXT(int num, String str) {
        this.num = num;
        this.str = str;
    }
}

class Class4 {
    //tIn是传对象的地址，修改形参的属性，会影响实参
    //intIn是传数据，基本数据类型的形参修改和实参无关
    //Integer和String对象不可变
    public static void f1(TEXT tIn, int intIn, Integer integerIn, String strIn) {
        tIn.num = 200;
        tIn.str = "bcd";//形参和实参指向的是同一个TEXT的对象，修改了属性，就相当于修改实参对象的属性
        intIn = 200;//基本数据类型的形参是实参的“副本”，无论怎么修改和实参都没关系
        integerIn = 200;//Integer对象和String对象一样都是不可变，一旦修改都是新对象，和实参无关
        strIn = "bcd";
    }

    public static void main(String[] args) {
        TEXT tIn = new TEXT(100, "abc");//tIn.num = 100, tIn.str="abc"
        int intIn = 100;
        Integer integerIn = 100;
        String strIn = "abc";

        f1(tIn, intIn, integerIn, strIn);

        System.out.println(tIn.num + tIn.str + intIn + integerIn + strIn);
        //200 + bcd + 100 + 100 + abc
    }
}