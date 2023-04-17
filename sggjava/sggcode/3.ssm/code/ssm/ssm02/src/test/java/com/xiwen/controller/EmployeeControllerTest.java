package com.xiwen.controller;

import com.xiwen.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/17 -15:09
 * @Version: 1.0
 */
@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {

    @Autowired
    private EmployeeController employeeController;

    @Test
    public void getById() {
        Employee employee = employeeController.getById(1);
        System.out.println(employee);
    }
}