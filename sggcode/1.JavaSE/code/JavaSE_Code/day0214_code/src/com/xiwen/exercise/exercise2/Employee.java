package com.xiwen.exercise.exercise2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/14-11:39
 * @Version: 1.0
 */
public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double earning() {
        return 0;
    }

    @Override
    public String toString() {
        return "姓名:" + name + ",实发工资:" + earning() ;
    }
}
