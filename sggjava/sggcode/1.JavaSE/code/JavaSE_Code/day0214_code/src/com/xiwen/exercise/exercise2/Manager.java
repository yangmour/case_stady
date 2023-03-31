package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-11:52
 * @Version: 1.0
 */
public class Manager extends SalaryEmployee {

    private double bonusRate;

    public Manager(String name, double salary, MyDate birthday, double bonusRate) {
        super(name, salary, birthday);
        this.bonusRate = bonusRate;
    }

    public Manager(String name, double salary, int year, int month, int day, double bonusRate) {
        super(name, salary, year, month, day);
        this.bonusRate = bonusRate;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }

    @Override
    public double earning() {
        return getSalary() * (1 + bonusRate);
    }

    @Override
    public String toString() {
        return super.toString() +
                ",黄金比例:" + bonusRate;
    }
}
