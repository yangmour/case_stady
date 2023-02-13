package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-11:07
 * @Version: 1.0
 */
public class CreditCardTest {
    public static void main(String[] args) {
        CreditCard d = new CreditCard();
        d.setId("11111");
        d.setBalance(500);
        d.setMaxOverdraft(1000);
        System.out.println("初始情况：" + d);

        d.withdraw(200);
        System.out.println("取款200后：" + d);

        d.withdraw(800);
        System.out.println("取款800后：" + d);

        d.withdraw(500);
        System.out.println("取款500后：" + d);

        d.save(100);
        System.out.println("存款100后：" + d);

        d.save(-100);
        System.out.println("存款-100后：" + d);

        d.withdraw(-100);
        System.out.println("取款-100后：" + d);

        d.withdraw(500);
        System.out.println("取款500后：" + d);

        d.save(2000);
        System.out.println("存款2000后：" + d);
    }
}
