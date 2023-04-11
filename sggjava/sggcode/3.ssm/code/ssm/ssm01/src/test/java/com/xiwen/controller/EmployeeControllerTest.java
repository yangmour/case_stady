package com.xiwen.controller;

import com.xiwen.bean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/11 -18:15
 * @Version: 1.0
 */
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
class EmployeeControllerTest {

    @Autowired
    private EmployeeController employeeController;

    @Test
    void getById() {
        Employee employee = employeeController.getById(1);
        System.out.println(employee);
    }

    @Test
    void findAll() {
        List<Employee> employees = employeeController.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    void insert() {
        int row = employeeController.insert(new Employee(null, "吴亦凡", "fanfan@qq.com", 1, 6000d, 2));
        System.out.println("row = " + row);

    }

    @Test
    void update() {
        int row = employeeController.update(new Employee(12, "吴亦凡", "fanfan@qq.com", 1, 6000d, 2));
        System.out.println("row = " + row);
    }

    @Test
    void delete() {
        int row = employeeController.delete(11);
        System.out.println("row = " + row);
    }
}