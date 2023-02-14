package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-11:44
 * @Version: 1.0
 */
public class SalaryEmployee extends Employee {
    private double salary;
    private MyDate birthday;

    public SalaryEmployee(String name, double salary, MyDate birthday) {
        super(name);
        this.salary = salary;
        this.birthday = birthday;
    }

    public SalaryEmployee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.birthday = new MyDate(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public double earning() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ",实发工资:" + salary +
                ", 生日:" + birthday;
    }
}
