package com.xiwen.homework.homework5;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:41
 * @Version: 1.0
 */
public class TestOutIn {
    public static void main(String[] args) {
        Out.In in = new Out().new In();
        in.print(); //14
        //13
        //12
    }
}
class Out {
    private int a = 12;
    class In {
        private int a = 13;
        public void print() {
            int a = 14;
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(Out.this.a);
        }
    }
}