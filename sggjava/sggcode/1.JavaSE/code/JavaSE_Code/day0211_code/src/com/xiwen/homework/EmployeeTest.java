package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/12-14:49
 * @Version: 1.0
 */
public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Employee employee1 = new Employee();
        employee1.setInfo(1, "张三", 50000.1, 18);
        Employee employee2 = new Employee();
        employee2.setInfo(2, "李四", 45230.1, 19);
        Employee employee3 = new Employee();
        employee3.setInfo(3, "王五", 15230.1, 19);
        Employee employee4 = new Employee();
        employee4.setInfo(4, "小红", 95230.1, 19);
        Employee employee5 = new Employee();
        employee5.setInfo(5, "小明", 25230.1, 19);
        Employee employee6 = new Employee();
        employee6.setInfo(6, "小王", 35230.1, 19);

        System.out.println(employeeManager.addEmployee(employee1) ? "成功" : "失败");
        System.out.println(employeeManager.addEmployee(employee2) ? "成功" : "失败");
        System.out.println(employeeManager.addEmployee(employee3) ? "成功" : "失败");
        System.out.println(employeeManager.addEmployee(employee4) ? "成功" : "失败");
        System.out.println(employeeManager.addEmployee(employee5) ? "成功" : "失败");
        System.out.println(employeeManager.addEmployee(employee6) ? "成功" : "失败");

        Employee[] employees = employeeManager.getEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.getInfo());
        }
    }
}
