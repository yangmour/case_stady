package com.xiwen.homework.homework3;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/17-18:41
 * @Version: 1.0
 */
public class Account {
    private String id;
    private Double balance;

    public Account(String id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(double money) throws Exception {
        if (money < 0) {
            throw new Exception("越取你余额越多，想得美");
        } else if (money > balance) {
            throw new Exception("取款金额不足，不支持当前取款操作");

        }

    }

    public void save(double money) throws Exception {
        if (money < 0) {
            throw new Exception("越存余额越少，你愿意吗？");
        }
    }

}

class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("11111",5000D);
        try {
            account.withdraw(-1D);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();

        }

        try {
            account.withdraw(6000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            account.save(-6000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            account.save(6000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
}
