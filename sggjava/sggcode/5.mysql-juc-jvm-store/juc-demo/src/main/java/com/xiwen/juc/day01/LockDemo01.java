package com.xiwen.juc.day01;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/30 -16:43
 * @Version: 1.0
 */

class Ticket {
    private Integer number = 30;

    public Integer getNumber() {
        return number;
    }

    public synchronized void sale() {
        if (number <= 0) {
            System.out.println("票已售罄！！！");
            return;
        }
        try {
            System.out.println(Thread.currentThread().getName() + "开始买票，当前票数：" + number);
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName() + "买票结束，剩余票数：" + --number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LockDemo01 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        }, "C").start();

    }

}
