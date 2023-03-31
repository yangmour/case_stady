package com.xiwen.homeword;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-16:08
 * @Version: 1.0
 */
public class Manager extends SalaryEmployee {
    private double ratio;

    public Manager(String name, double salary, MyDate myDate, double ratio) {
        super(name, salary, myDate);
        this.ratio = ratio;
    }

    public Manager() {
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public double earning() {
        return getSalary() * (1 + ratio);
    }

    @Override
    public String toString() {
        return super.toString() + "ratio=" + ratio;
    }
}
