package com.xiwen.exercise.exercise1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-10:23
 * @Version: 1.0
 */
public class EmployeesTest {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(2, "张三", 15, 4000D);
        employees[1] = new Employee(1, "李四", 20, 6000D);
        employees[2] = new Employee(3, "王五", 18, 3000D);
        employees[3] = new Employee(5, "赵六", 21, 5000D);
        employees[4] = new Employee(4, "小明", 19, 4000D);


        System.out.println("默认输出");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("id升序排序");
        Arrays.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }


        System.out.println("年龄升序排序");
        Arrays.sort(employees, new AgeComparator());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("薪资升序排序");
        Arrays.sort(employees, new SalaryComparator());
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("姓名升序排序");
        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("2姓名升序排序");
        Arrays.sort(employees, Comparator.comparing(Employee::getName));
        for (Employee employee : employees) {
            System.out.println(employee);
        }


    }
}
