package com.xiwen.homework.homework1.homework1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/26-11:37
 * @Version: 1.0
 */
public class HappyNewYear {
    public static void main(String[] args) {

        //模拟新年倒计时，每隔1秒输出一个数字，依次输出10,9,8......1，最后输出：新年快乐！
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("新年快乐！");

    }
}
