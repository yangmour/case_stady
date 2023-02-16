package com.xiwen.homework.homework5;


import java.util.function.Predicate;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/16-20:16
 * @Version: 1.0
 */
public class EmployeeService {
    private Employee[] arr = new Employee[5];
    private int total;

    public void add(Employee emp) {
        if (total == 5) {
            System.out.println("数组已满！");
            return;
        }
        arr[total++] = emp;
    }

    public Employee[] get(Predicate p) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (p.test(arr[i])) {
                count++;
            }
        }
        Employee[] result = new Employee[count];
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (p.test(arr[i])) {
                result[count++] = arr[i];
            }
        }
        return result;
    }
}
