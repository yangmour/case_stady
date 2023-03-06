package com.xiwen.exercise.exercise8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/3/4-22:50
 * @Version: 1.0
 */
public class EmployeeTest {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("张三", 20, 9000));
        employees.add(new Employee("李四", 24, 8000.0));
        employees.add(new Employee("王五", 25, 11000.0));

        employees.forEach(System.out::println);

        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        employees.forEach(System.out::println);

        Collections.sort(employees, Comparator.comparingInt(Employee::getAge));
        employees.forEach(System.out::println);
    }
}
