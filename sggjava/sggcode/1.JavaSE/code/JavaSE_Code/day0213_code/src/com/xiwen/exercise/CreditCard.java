package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-10:47
 * @Version: 1.0
 */
public class CreditCard extends DepositCard {
    private double overdraft;
    private double maxOverdraft;

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }

    @Override
    public String toString() {
        return super.toString() + ",overdraft=" + overdraft + ", maxOverdraft=" + maxOverdraft;
    }

    @Override
    public void withdraw(double money) {
        if (money < 0) {
            System.out.println("取款不能为负数！");
        } else if (getBalance() + maxOverdraft - overdraft < money) {
            System.out.println("超过可透支余额！");
        } else if (money <= getBalance()) {
            super.withdraw(money);
        } else {

            // 1000  - 0.0 - 800- 300
            // (1000 -500) + 500 - 500 +  -0;

            //1000 - 0.0 - (800- 300)
            //500 + (1000 - 500) - (500 -0);
            // 800 - 300 =500
            // 0 + 500
            //500 + 500 - 0
            overdraft += money - getBalance();
            setBalance(0);

        }
    }

    @Override
    public void save(double money) {
        //- 存款金额不能为负数，否则提示存款金额不能为负数
        //- 本次存款金额只够偿还部分已透支金额
        //- 本次存款金额除了偿还透支金额，还有剩余
        if (money < 0) {
            System.out.println("取款不能为负数！");
        } else if (money < overdraft) {
            overdraft = overdraft - money;
        } else {
            setBalance(getBalance() + (money - overdraft));
            setOverdraft(0);
        }
    }
}
