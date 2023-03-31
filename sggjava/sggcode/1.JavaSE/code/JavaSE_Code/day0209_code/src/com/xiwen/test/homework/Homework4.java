package com.xiwen.test.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/9-19:32
 * @Version: 1.0
 */
public class Homework4 {
    public static void main(String[] args) {

        /**
         * 案例需求：公司年会有一个寻找锦鲤的游戏，每一个员工随意写一个字
         * ，如果在“锦鲤”词库中有这个字，那么就奖励500元锦鲤红包，否则就没有，每人只能玩一次。
         * 现有锦鲤字库如下，它们按照Unicode编码值从小到大排序：
         * char[] koiFishWords = {'一','今','地','定','尚','年','开','我','果','火','爱','硅','结','花','谷','遍'};
         * 开发提示：
         */

        char[] koiFishWords = {'一', '今', '地', '定', '尚', '年', '开', '我', '果', '火', '爱', '硅', '结', '花', '谷', '遍'};

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字:");
        char c = scanner.next().charAt(0);

        int left = 0;
        int right = koiFishWords.length - 1;
        boolean flag = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (c == koiFishWords[mid]) {
                flag = true;
                break;
            } else if (koiFishWords[mid] > c ) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }
        if (flag) {
            System.out.println("奖励500元");
        } else {
            System.out.println("没有奖励");
        }
    }
}
