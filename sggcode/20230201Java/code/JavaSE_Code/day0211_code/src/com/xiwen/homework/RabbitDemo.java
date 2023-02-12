package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/12-14:25
 * @Version: 1.0
 */
public class RabbitDemo {
    public static void main(String[] args) {

        RabbitDemo rabbitDemo = new RabbitDemo();
        // 1 2 3 5 8
        System.out.println("24个月后有:" + rabbitDemo.f(2 * 12) + "对兔子");
    }

    private int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return f(n - 2) + f(n - 1);
    }
}
