package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/27-14:41
 * @Version: 1.0
 */
public class SinglePlankBridge {

    private int m;
    //    private int s;

    public SinglePlankBridge(int m) {
        this.m = m;
    }


    public void pass() {
        System.out.println(Thread.currentThread().getName() + "以上桥");
        int s = 0;
        while (s < m) {
            try {
                Thread.sleep(1000);
                s++;
                System.out.println(Thread.currentThread().getName() + "已过" + s + "米");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + "以过桥");
    }
}
