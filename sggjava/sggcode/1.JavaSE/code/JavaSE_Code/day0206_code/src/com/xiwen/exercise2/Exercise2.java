package com.xiwen.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/6-15:33
 * @Version: 1.0
 */
public class Exercise2 {
    public static void main(String[] args) {
        /**
         * 2、所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
         * 例如： 153 = 1\*1\*1 + 5\*5\*5 + 3\*3\*3，找出所有的水仙花数，并统计他们有几个。
         */
        int sum = 0;
        for (int i = 100; i < 1000; i++) {
            int bai = i / 100;
            int shi = i / 10 % 10;
            int ge = i % 10;
            int num = bai * bai * bai + shi * shi * shi + ge * ge * ge;
            if (num == i) {
                sum++;
                System.out.println(i);
            }
        }
        System.out.println("总共有:" + sum + "个水仙花数");


    }

}
