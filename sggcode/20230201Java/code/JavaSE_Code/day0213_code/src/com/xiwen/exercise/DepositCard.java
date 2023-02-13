package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-10:43
 * @Version: 1.0
 */
public class DepositCard {
    private String id;
    private double balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double money) {
        if (money < 0) {
            System.out.println("取款不能为负数！");
            return;
        }
        if (balance <= money) {
            System.out.println("余额不足！");
            return;
        }
        balance -= money;
    }

    public void save(double money) {
        if (money < 0) {
            System.out.println("存款不能为负数！");
            return;
        }
        balance += money;
    }

    @Override
    public String toString() {
        return "账号=" + id +
                ", 余额=" + balance ;
    }
}
