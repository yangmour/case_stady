package com.xiwen.juc.day03;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/07/03 -19:18
 * @Version: 1.0
 */
public class VolatileDemo {

    //    private static Integer flag = 1;
    private volatile static Integer flag = 1;

    public static void main(String[] args) throws InterruptedException {
        /**
         * 验证volatile关键字可见性
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程工作内存flag的值：" + flag);
                while (flag == 1) {
                }
                System.out.println("子线程操作结束..." + flag);
            }
        }).start();
        Thread.sleep(500);
        flag = 2;
        System.out.println("我是主线程工作内存flag的值：" + flag);
    }
}
