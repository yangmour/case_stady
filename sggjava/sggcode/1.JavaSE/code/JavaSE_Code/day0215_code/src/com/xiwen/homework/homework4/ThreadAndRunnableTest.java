package com.xiwen.homework.homework4;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/15-18:38
 * @Version: 1.0
 */
public class ThreadAndRunnableTest {
    public static void main(String[] args) {

        new Thread("希文") {

            @Override
            public void run() {
                System.out.println("我爱尚硅谷！");
                ;
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("尚硅谷爱我！");
            }
        }).start();

    }
}
