package com.xiwen.test;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-10:58
 * @Version: 1.0
 */


public interface A {
    int d = 1;
}

interface B {
    int d = 2;
}

class E {
    int d = 4;
}

class C extends E implements A, B {
    int d = 3;

    public static void main(String[] args) {


    }

    public void month() {

        C c = new C();
        System.out.println(super.d);
        System.out.println(d);
        System.out.println(A.d);
        System.out.println(B.d);
    }
}


class External {
    private static int a = 1;
    private int b = 1;

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        External.a = a;
    }

    public static void main(String[] args) {

        External external = new External();
        external.monthE();
        Inner inner = new External.Inner();
        inner.monthI();

        External.Inner2 inner2 = external.new Inner2();


    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void monthE() {
        Inner inner = new Inner();
        System.out.println(Inner.a);
        System.out.println(inner.b);
    }

    static class Inner {
        private static int a = 2;
        private int b = 2;

        public void monthI() {
            System.out.println(a);
            System.out.println(External.a);
            System.out.println(b);
            System.out.println(new External().b);

        }
    }

    class Inner2 {
        public void monthI() {
            System.out.println(a);
            System.out.println(External.a);
            System.out.println(b);
            System.out.println(External.this.b);

        }
    }

}
