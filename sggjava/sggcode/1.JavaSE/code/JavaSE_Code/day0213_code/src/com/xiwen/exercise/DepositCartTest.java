package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-11:05
 * @Version: 1.0
 */
public class DepositCartTest {
    public static void main(String[] args) {
        DepositCard d = new DepositCard();
        d.setId("11111");
        d.setBalance(500);
        System.out.println("初始情况：" + d);

        d.withdraw(200);
        System.out.println("取款200后：" + d);

        d.save(100);
        System.out.println("存款100后：" + d);

        d.save(-100);
        System.out.println("存款-100后：" + d);

        d.withdraw(-100);
        System.out.println("取款-100后：" + d);

        d.withdraw(500);
        System.out.println("取款500后：" + d);
    }
}
