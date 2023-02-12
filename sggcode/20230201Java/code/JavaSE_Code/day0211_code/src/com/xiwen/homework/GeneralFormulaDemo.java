package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/12-14:36
 * @Version: 1.0
 */
public class GeneralFormulaDemo {
    public static void main(String[] args) {
        GeneralFormulaDemo g = new GeneralFormulaDemo();
        System.out.println(g.f(10));
    }

    private long f(long n) {
        if (n < 0) {
            return 0;
        } else if (n==1){return 1;}
        return n + f(n - 1);
    }
}
