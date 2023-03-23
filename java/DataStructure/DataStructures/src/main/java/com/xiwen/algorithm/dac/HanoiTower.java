package com.xiwen.algorithm.dac;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/23 -11:24
 * @Version: 1.0
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3, "A", "B", "C");

    }

    /**
     * 分治算法 解决汉罗塔游戏问题
     *
     * @param i 盘数
     * @param a 柱子1
     * @param b 柱子2
     * @param c 柱子3
     */
    private static void hanoiTower(int i, String a, String b, String c) {
        if (i == 1) {
            System.out.println("第" + i + "个盘子从" + a + "->" + c);
        } else {
            //将a柱第一个盘子放到b盘上
            hanoiTower(i - 1, a, c, b);
            //将a柱放到c上
            System.out.println("第" + i + "个盘子从" + a + "-》" + c + "柱上");
            //将c柱上的移动到a柱
            hanoiTower(i - 1, b, a, c);
        }
    }
}
