package com.xiwen.controller;

import com.xiwen.bean.Employee;
import com.xiwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/17 -15:09
 * @Version: 1.0
 */
@Controller
@RequestMapping("hello")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public Employee getById(Integer id) {
        return employeeService.getById(id);
    }

    @RequestMapping("showEmployees")
    public String showEmployees(Model model){
        List<Employee> emps = employeeService.findAll();
        model.addAttribute("emps",emps);
        return "showEmployees";
    }

}
