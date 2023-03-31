package com.xiwen.homeword;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-15:52
 * @Version: 1.0
 */
public class HourEmployee extends Employee {

    private double hour;
    private double hourSalary;

    public HourEmployee(String name, double hour, double hourSalary) {
        super(name);
        this.hour = hour;
        this.hourSalary = hourSalary;
    }

    public HourEmployee() {
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public double getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(double hourSalary) {
        this.hourSalary = hourSalary;
    }

    @Override
    public double earning() {
        return hour * hourSalary;
    }

    @Override
    public String toString() {
        return super.toString() + ",时薪:" + hourSalary + ",工作小时:" + hour;
    }
}
