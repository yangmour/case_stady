package com.xiwen.homework.homework9;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-20:02
 * @Version: 1.0
 */
public class Homework9 {
}

class TestFuZi {
    public static void main(String[] args) {
        Zi zi = new Zi();
    }
}
class Fu{
    // i->0    i++ i等于1 父类的
    //（3）父类静态代码块->1 父类的
    //（6）k->0 i++ 1  子类的
    //（8）子类静态代码块->1 父类的
    //（2）j->1    i++ 2 父类的
    //（4）父类非静态代码块，又称为构造代码块->2 父类的
    //（5）父类构造器->2 父类的
    //（7）h->1 i++ 2子类的
    //（9）子类非静态代码块，又称为构造代码块->2
    //（10）子类构造器->2



    private static int i = getNum("（1）i");
    private int j = getNum("（2）j");
    static{
        print("（3）父类静态代码块");
    }
    {
        print("（4）父类非静态代码块，又称为构造代码块");
    }
    Fu(){
        print("（5）父类构造器");
    }
    public static void print(String str){
        System.out.println(str + "->" + i);
    }
    public static int getNum(String str){
        print(str);
        return ++i;
    }
}
class Zi extends Fu{
    private static int k = getNum("（6）k");
    private int h = getNum("（7）h");
    static{
        print("（8）子类静态代码块");
    }
    {
        print("（9）子类非静态代码块，又称为构造代码块");
    }
    Zi(){
        print("（10）子类构造器");
    }
    public static void print(String str){
        System.out.println(str + "->" + k);
    }
    public static int getNum(String str){
        print(str);
        return ++k;
    }
}

