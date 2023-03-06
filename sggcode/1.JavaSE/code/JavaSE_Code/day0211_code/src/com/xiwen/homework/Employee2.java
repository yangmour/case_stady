package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/12-14:57
 * @Version: 1.0
 */
public class Employee2 {
    private int id;
    private String name;
    private String sex;
    private int age;
    private double salary;
    private String phone;
    private String email;

    public Employee2(String name, String sex, int age, double salary, String phone, String email) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {

        return id + "\t" + name +
                "\t" + sex +
                "\t" + age +
                "\t" + salary +
                "\t" + phone +
                "\t" + email;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
