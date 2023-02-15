package com.xiwen.homework.homework6;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:43
 * @Version: 1.0
 */
public class TestOut {
    public static void main(String[] args) {
        Out out = new Out();
        out.print(3); //3
                      //12

    }
}
class Out {
    private int a = 12;
    public void print(final int x) {
        class In {
            public void inPrint() {
                System.out.println(x);
                System.out.println(a);
            }
        }
        new In().inPrint();
    }
}