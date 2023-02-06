package com.xiwen.exercise;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-12:01
 * @Version: 1.0
 */
public class Exercise10 {
    public static void main(String[] args) {

        /**
         * 10、赌数游戏：随机产生3个1-6的整数
         * ，如果三个数相等，那么称为“豹子”
         * ，如果三个数之和大于9，称为“大”
         * ，如果三个数之和小于等于9，称为“小”
         * ，用户从键盘输入押的是“豹子”、“大”、“小”，并判断是否猜对了
         * 提示：随机数  Math.random()产生 [0,1)范围内的小数
         */

        Scanner scanner = new Scanner(System.in);
        int random1 = (int) (Math.random() * 6 + 1);
        int random2 = (int) (Math.random() * 6 + 1);
        int random3 = (int) (Math.random() * 6 + 1);
        System.out.println(random1 + "" + random2 + random3);
        System.out.print("请从键盘输入押的是(豹子、大、小):");
        String str = scanner.next();
        boolean flag = false;
        switch (str) {
            case "豹子":
                flag = random1 == random2 && random1 == random3;
                break;
            case "大":
                flag = random1 + random2 + random3 > 9;
                break;
            case "小":
                flag = random1 + random2 + random3 <= 9;
                break;
            default:
                System.out.println("输入错误！");
                System.exit(0);
        }

        System.out.println(flag ? "押中了恭喜你！" : "押错了！");

//        if (flag) {
//            System.out.println("押中了恭喜你！");
//        } else {
//            System.out.println("押错了！");
//        }


    }
}
