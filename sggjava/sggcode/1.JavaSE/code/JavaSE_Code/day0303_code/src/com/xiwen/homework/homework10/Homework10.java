package com.xiwen.homework.homework10;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-20:01
 * @Version: 1.0
 */
public class Homework10 {
}

class T {
    public static int k = 0;
    public static T t1 = new T("t1");

    public static T t2 = new T("t2");
    public static int i = print("i");
    public static int n = 99;

    public int j = print("j");

    {
        print("构造块");
    }

    static {
        print("静态块");
    }

    public T(String str) {
        System.out.println((++k) + ":" + str + "  i=" + i + "  n=" + n);
        ++n;
        ++i;
    }
    //++k  k等于1
    //1:j i=0 n=0   输出的同时n=1,i=1
    //++k k等于2
    //2:构造块 i=1 n=1  输出的同时n=2,i=2
    //++k k等于3
    //3:t1 i=2 n=2   输出的同时n=3,i=3
    //++k k等于4
    //4:j i=3 n=3   输出的同时n=4,i=4
    //++k k等于5
    //5:构造块 i=4 n=4  输出的同时n=5,i=5
    //6:t2 i=5 n=5   输出的同时n=6,i=6
    //++k k等于7
    //7:构造块 i=6 n=6  输出的同时n=7,i=7 n=99
    //++k k等于8
    //8:静态块 i=7 n=99

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "  i=" + i + "  n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {

    }
}
