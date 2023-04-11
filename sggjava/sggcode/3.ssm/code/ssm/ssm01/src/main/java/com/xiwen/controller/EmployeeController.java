package com.xiwen.controller;

import com.xiwen.bean.Employee;
import com.xiwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/11 -18:09
 * @Version: 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    
    public Employee getById(Integer id) {
        return employeeService.getById(id);
    }

    
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    
    public int insert(Employee employee) {
        return employeeService.insert(employee);

    }

    
    public int update(Employee employee) {
        return employeeService.update(employee);

    }

    
    public int delete(Integer id) {
        return employeeService.delete(id);
    }

}
