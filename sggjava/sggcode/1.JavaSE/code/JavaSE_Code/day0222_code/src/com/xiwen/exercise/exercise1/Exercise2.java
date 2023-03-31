package com.xiwen.exercise.exercise1;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/22-10:09
 * @Version: 1.0
 */
public class Exercise2 {
    public static void main(String[] args) {
        //（1）声明员工类型Employee，包含属性姓名（String），薪资（double），年龄（int），属性私有化
        // ，提供有参构造、get/set方法、重写toString方法。

        //（2）员工类Employee实现java.lang.Comparable<T>接口，指定T为Employee类型，重写抽象方法int compareTo(T t)
        // ，按照薪资比较大小，薪资相同的按照姓名的自然顺序（调用String类的compareTo方法）比较大小。

        //（3）在测试类中创建Employee数组，然后调用Arrays.sort(Object[] arr)方法进行排序，遍历显示员工信息。
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("张三", 6000D, 20);
        employees[1] = new Employee("李四", 2000D, 20);
        employees[2] = new Employee("王五", 4000D, 30);
        employees[3] = new Employee("赵六", 8000D, 22);
        employees[4] = new Employee("钱七", 3000D, 24);

        System.out.println("排序前:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        Arrays.sort(employees);
        System.out.println("排序后:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        //（4）声明EmployeeAgeComparator比较器，实现java.util.Comparator<T>接口，重写int compare(T t1, T t2)方法，指定T为Employee类型，按照员工年龄比较大小，年龄相同的按照姓名字典顺序（使用java.text.Collator compare方法）比较大小
        //
        //（5）再次调用Arrays.sort(Object[] arr,Comparator<T> c)方法对员工数组进行排序，遍历显示员工信息

        System.out.println("排序前:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        Arrays.sort(employees, new EmployeeAgeComparator());
        System.out.println("排序后:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    private int age;

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        int compare = Double.compare(salary, o.getSalary());
        if (compare == 0) {
            return name.compareTo(o.getName());
        }
        return compare;
    }
}


class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int age = o1.getAge() - o2.getAge();
        if (age == 0) {
            return Collator.getInstance(Locale.CHINA).compare(o1.getName(), o2.getName());
        } else {
            return age;
        }
    }
}