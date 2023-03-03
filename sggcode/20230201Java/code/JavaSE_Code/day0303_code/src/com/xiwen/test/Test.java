package com.xiwen.test;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/3-15:26
 * @Version: 1.0
 */
public class Test {
    static int x, y, z;

    public static void main(String[] args) {
        System.out.println("x=" + x);
        z--;
        method();
        System.out.println("result:" + (z + y + ++z));
    }

    static {
        x--;
    }

    static {
        int x = 5;
        x--;
    }

    static {
        x--;
    }

    public static void method() {
        y = z++ + ++z;
    }
}
