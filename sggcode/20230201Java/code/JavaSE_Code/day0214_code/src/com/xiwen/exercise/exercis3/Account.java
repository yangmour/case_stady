package com.xiwen.exercise.exercis3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-16:19
 * @Version: 1.0
 */
public class Account {

    // 利率
    private static double interestRate;
    private String id;
    private double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account() {
    }

    public double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

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

    @Override
    public String toString() {
        return "账号:" + id + ", 余额:" + balance + ",年利息:" + annualInterest();
    }

    public double annualInterest() {
        return balance * interestRate;
    }
}

class AccountTest {
    public static void main(String[] args) {

        Account.setInterestRate(0.035);
        Account account1 = new Account("11111", 1000);
        Account account2 = new Account("22222", 2000);

        System.out.println(account1);
        System.out.println(account2);

    }
}
