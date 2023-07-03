package com.xiwen.juc.day03;

public class VolatileOrderDemo {


    //    static int a, b;
    volatile static int a, b;

    static int x, y;

    public static void main(String[] args) throws InterruptedException {

        /**
         * 验证volatile有序性
         */
        int i = 0;
        while (true) {
            i++;
            a = b = x = y = 0;
            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
            }, "");
            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            }, "");

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println("第" + i + "次打印：x=" + x + ", y=" + y);

            if (x == 0 && y == 0) {
                break;
            }
        }
    }
}