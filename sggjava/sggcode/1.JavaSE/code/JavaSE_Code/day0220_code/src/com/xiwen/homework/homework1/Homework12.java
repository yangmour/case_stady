package com.xiwen.homework.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-18:45
 * @Version: 1.0
 */
public class Homework12 {

}
class Test {
    int a;
    int b;
    String str;

    public static void main(String[] args) {
        Test t = new Test();
        t.f(); //1 0 1,hello
    }

    public void f(){
        a = 0;
        b = 0;
        str = "hello";
        int[] c = {0};
        g(b,c,str);
        System.out.println(a + " " + b + " " + c[0] + "," + str);
    }

    public void g(int b, int[] c,String s){
        a = 1;
        b = 1;
        c[0] = 1;
        s = "world";
    }
}