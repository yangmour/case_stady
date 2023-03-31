package com.xiwen.exercise.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-16:30
 * @Version: 1.0
 */
public class TryCatchTest {
    public static void main(String[] args) {
        /**
         * （1）已知java.lang包下有一个Thread类，这个类有一个静态方法：
         * public static void sleep(long millis) throws InterruptedException
         * 调用这个方法可以实现程序休眠millis毫秒（1000毫秒=1秒）。
         * （2）在测试类的main中，在for循环中调用上面的sleep方法，实现新年倒计时10,9,8，...，1，新年到！
         * - 每循环1次执行一次sleep方法，可以模拟1秒输出一个数字。
         * - 使用try...catch处理异常
         */

        for (int i = 10; i >0; i--) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("新年到！");

    }
}
