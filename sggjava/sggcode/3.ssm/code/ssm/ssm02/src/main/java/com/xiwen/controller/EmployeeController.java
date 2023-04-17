package com.xiwen.controller;

import com.xiwen.bean.Employee;
import com.xiwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/17 -15:09
 * @Version: 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public Employee getById(Integer id) {
        return employeeService.getById(id);
    }
}
