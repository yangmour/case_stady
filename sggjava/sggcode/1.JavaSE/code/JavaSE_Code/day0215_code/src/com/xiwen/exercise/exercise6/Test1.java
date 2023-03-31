package com.xiwen.exercise.exercise6;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-15:20
 * @Version: 1.0
 */
public class Test1 {
    public Test1() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        Test1.Inner s3 = new Test1.Inner();
        System.out.println(s3.a);
    }

    public static void main(String[] args) {
        Test1.Inner r = new Test1.Inner();
        System.out.println(r.a); // 5
    }

    static class Inner {
        public int a = 5;
    }
}

class Test2 {
    public Test2(){
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        Test2.Inner s3 = new Test2.Inner();
        System.out.println(s3.a);
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        Test2.Inner r = t.new Inner();
        System.out.println(r.a); //5 5
    }

    class Inner{
        public int a = 5;
    }
}

class Test3 {
    public Test3(){
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        Test3.Inner s3 = new Test3.Inner();
        System.out.println(s3.a);
    }

    public static void main(String[] args) {
        //Test t = new Test();
        Test3.Inner r = new Test3.Inner();
        System.out.println(r.a); // 5
    }

    static class Inner{
        public static int a = 5;
    }
}