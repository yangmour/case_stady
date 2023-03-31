package com.xiwen.exercise.exercise1;

import java.util.Comparator;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/2/20-10:18
 * @Version: 1.0
 */
public class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge() - o2.getAge();
    }
}
