package com.xiwen.homework.homework5;

import java.util.function.Predicate;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-20:28
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {

        //		new Employee(4, "李四", 24, 24000);
        //		new Employee(3, "张三", 23, 13000);
        //		new Employee(5, "王五", 25, 15000);
        //		new Employee(1, "赵六", 27, 17000);
        //		new Employee(2, "钱七", 16, 6000);
        EmployeeService employeeService = new EmployeeService();
        employeeService.add(new Employee(4, "李四", 24, 24000));
        employeeService.add(new Employee(3, "张三", 23, 13000));
        employeeService.add(new Employee(5, "王五", 25, 15000));
        employeeService.add(new Employee(1, "赵六", 27, 17000));
        employeeService.add(new Employee(2, "钱七", 16, 6000));

        Employee[] employees = employeeService.get(new Predicate() {
            @Override
            public boolean test(Object o) {
                return true;
            }
        });
        System.out.println("------所有-----");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Employee[] employeeAges = employeeService.get(new Predicate() {
            @Override
            public boolean test(Object o) {
                if (((Employee) o).getAge() > 25) {
                    return true;
                }
                return false;
            }
        });
        System.out.println("-----大于25------");
        for (Employee employee : employeeAges) {
            System.out.println(employee);
        }

        Employee[] employeeSalarys = employeeService.get(new Predicate() {
            @Override
            public boolean test(Object o) {
                if (((Employee) o).getSalary() > 15000) {
                    return true;
                }
                return false;
            }
        });
        System.out.println("-----大于15000------");
        for (Employee employee : employeeSalarys) {
            System.out.println(employee);
        }

        Employee[] employeeAgeAndSalarys = employeeService.get(new Predicate() {
            @Override
            public boolean test(Object o) {
                if (((Employee) o).getAge() > 25 && ((Employee) o).getSalary() > 15000) {
                    return true;
                }
                return false;
            }
        });
        System.out.println("-----大于25岁和大于15000------");
        for (Employee employee : employeeAgeAndSalarys) {
            System.out.println(employee);
        }


    }
}
