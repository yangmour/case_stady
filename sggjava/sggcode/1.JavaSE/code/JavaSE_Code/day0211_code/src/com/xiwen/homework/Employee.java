package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/12-14:40
 * @Version: 1.0
 */
public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;

    public void setInfo(int i, String n, double s, int a) {
        id = i;
        name = n;
        salary = s;
        age = a;
    }

    public String getInfo() {
        return "{id=" + id + ",name=" + name + ",salary=" + salary + ",age=" + age + "}";
    }
}
