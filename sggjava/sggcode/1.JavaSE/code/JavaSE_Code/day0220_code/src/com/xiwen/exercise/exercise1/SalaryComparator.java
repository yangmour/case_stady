package com.xiwen.exercise.exercise1;

import java.util.Comparator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-10:19
 * @Version: 1.0
 */
public class SalaryComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Employee e1 = (Employee) o1;
        Employee e2 = (Employee) o2;
        if (e1.getSalary() > e2.getSalary()) {
            return 1;
        } else if (e1.getSalary() < e2.getSalary()) {
            return -1;
        } else {
            return 0;
        }
//        return Double.compare(e1.getSalary(),e2.getSalary());
    }
}
