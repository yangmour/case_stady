package com.xiwen.homeword;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-15:43
 * @Version: 1.0
 */
public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
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
        return "名字:" + name + ",实发工资:" + earning();
    }
}
