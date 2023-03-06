package com.xiwen.homeword;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-15:48
 * @Version: 1.0
 */
public class SalaryEmployee extends Employee {
    private double salary;
    private MyDate myDate;

    public SalaryEmployee(String name, double salary, MyDate myDate) {
        super(name);
        this.salary = salary;
        this.myDate = myDate;

    }

    public SalaryEmployee() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    @Override
    public double earning() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ",生日:" + myDate.toString();
    }
}
