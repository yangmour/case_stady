package com.xiwen.exercise;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-10:37
 * @Version: 1.0
 */
public class Teacher extends Person {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ",工资:" + salary;
    }
}
