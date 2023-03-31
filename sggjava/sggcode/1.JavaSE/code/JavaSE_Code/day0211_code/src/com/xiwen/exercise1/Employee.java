package com.xiwen.exercise1;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/11-11:27
 * @Version: 1.0
 */
public class Employee {
    String name;
    MyDate birthday;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
