package com.xiwen.homeword.homework2;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/13-18:53
 * @Version: 1.0
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String say(){
        return "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", salary=" + salary ;
    }
    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", salary=" + salary ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
