package com.xiwen.homework;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/12-14:43
 * @Version: 1.0
 */
public class EmployeeManager {
    private Employee[] employees = new Employee[5];
    private int total;

    private boolean isFull() {
        if (total >= 5) {
            return true;
        }
        return false;
    }

    public boolean addEmployee(Employee emp) {
        if (isFull()) {
            System.out.println("数组已满！");
            return false;
        }

        employees[total++] = emp;
        return true;
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
