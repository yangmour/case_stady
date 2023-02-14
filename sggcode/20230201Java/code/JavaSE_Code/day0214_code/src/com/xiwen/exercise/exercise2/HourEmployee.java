package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-11:47
 * @Version: 1.0
 */
public class HourEmployee extends Employee {

    private double hour;
    private double moneyPerHour;

    public HourEmployee(String name, double hour, double moneyPerHour) {
        super(name);
        this.hour = hour;
        this.moneyPerHour = moneyPerHour;
    }

    public HourEmployee(String name, double moneyPerHour) {
        super(name);
        this.moneyPerHour = moneyPerHour;
    }

    @Override
    public double earning() {
        return hour * moneyPerHour;
    }

    @Override
    public String toString() {
        return super.toString() +
                ",工作时间:" + hour +
                ", 时薪:" + moneyPerHour;
    }
}
