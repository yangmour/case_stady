package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/7-19:33
 * @Version: 1.0
 */
public class HomeWork6 {
    public static void main(String[] args) {

        /**
         * 案例需求：大乐透（前区“35选5”＋后区“12选2”），即前区在1-35之间的号码中随机选取5个
         * ，后区在1-12之间的号码中随机选取2个，组成一期的中奖号码，请用程序模拟产生一组大乐透中奖号码。
         * 开发提示：
         * - 声明一个int类型的数组front，长度为35，默认值都是0；
         * - 声明一个int类型的数组after，长度为12，默认值都是0；
         *
         * - 随机产生[0,35）之间的整数。如果随机产生的是0，那么就把front[0]修改为1
         * ，如果随机产生的是5，那么就把front[5]修改为1
         * ，如果随机产生的是10，就把front[10]修改为1。
         * 但是如果本次随机产生的是5，而front[5]已经是1了
         * ，那么需要重新随机产生一个整数。用这种方式把front数组的5个元素修改为1。
         *
         * - 随机产生[0,12）之间的整数。使用同样的方式，把after数组的2个元素修改为1。
         * - 遍历front和after数组，输出大乐透中奖号码，判断front和after数组元素是否为1，如果为1，就显示它的下标+1值。
         */

        int[] front = new int[35];
        int[] after = new int[12];

        for (int i = 1; i <= 5; ) {
            int fRandom = (int) (Math.random() * 35);//[0,34]
            if (front[fRandom] == 0) {
                front[fRandom] = 1;
                i++;
            }
        }

        for (int i = 1; i <= 2; ) {
            int aRandom = (int) (Math.random() * 12);//[0,11]
            if (after[aRandom] == 0) {
                after[aRandom] = 1;
                i++;
            }
        }

        System.out.println("本期大乐透中奖号码：");
        System.out.print("前区5个号码为：");
        for (int i = 0; i < front.length; i++) {
            if (front[i] != 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();

        System.out.println("本期大乐透中奖号码：");
        System.out.print("前区2个号码为：");
        for (int i = 0; i < after.length; i++) {
            if (after[i] != 0) {
                System.out.print(i + 1 + " ");
            }
        }

    }
}
