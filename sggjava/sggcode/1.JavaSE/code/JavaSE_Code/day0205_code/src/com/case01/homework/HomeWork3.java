package com.case01.homework;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/5-19:16
 * @Version: 1.0
 */
public class HomeWork3 {
    public static void main(String[] args) {
        /**
         * 从键盘输入订单总价格totalPrice（总价格必须>=0），
         * 1. 判断当`totalPrice<0`时，显示输入有误
         * 2. 当`totalPrice>=0`时，根据优惠政策计算打折后的总价格。
         *    - 判断当`totalPrice >=500` ,discount赋值为0.8
         *    - 判断当`totalPrice >=400` 且`<500`时,discount赋值为0.85
         *    - 判断当`totalPrice >=300` 且`<400`时,discount赋值为0.9
         *    - 判断当`totalPrice >=200` 且`<300`时,discount赋值为0.95
         *    - 判断当`totalPrice >=0` 且`<200`时,不打折，即discount赋值为1
         *    - 输出结果
         */

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入订单总价格:");
        double totalPrice = scanner.nextDouble();
        double discount = 0;
        if (totalPrice < 0) {
            System.out.println("价格输入有误，请重新输入！");
        } else if (totalPrice >= 500) {
            discount = 0.8;
        } else if (totalPrice >= 400) {
            discount = 0.85;
        } else if (totalPrice >= 300) {
            discount = 0.9;
        } else if (totalPrice >= 200) {
            discount = 0.95;
        } else {
            discount = 1;
        }

        System.out.println("打了" + discount + "折，最后售价为:" + totalPrice * discount);

    }

}
