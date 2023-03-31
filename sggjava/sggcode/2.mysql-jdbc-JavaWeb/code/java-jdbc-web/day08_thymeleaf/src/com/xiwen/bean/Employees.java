package com.xiwen.bean;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/21 -15:14
 * @Version: 1.0
 */
public class Employees {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
    private String address;
    private Computer computer;

    public Employees() {
    }

    public Employees(Integer id, String name, Integer age, Double salary, String address, Computer computer) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
        this.computer = computer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
