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
    public String showEmployees(Model model) {
        List<Employee> emps = employeeService.findAll();
        model.addAttribute("emps", emps);
        return "showEmployees";
    }

    @RequestMapping("toAddEmpPage")
    public String toAddEmpPage() {
        return "addEmp";
    }

    @RequestMapping("addEmp")
    public String addEmp(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:showEmployees";
    }

    @RequestMapping("toEditEmpPage")
    public String toEditEmpPage(Integer id, Model model) {
        Employee emp = employeeService.getById(id);
        model.addAttribute("emp", emp);
        return "editEmp";
    }

    @RequestMapping("editEmp")
    public String editEmp(Employee employee) {
        employeeService.editEmployee(employee);
        return "redirect:showEmployees";
    }

    @RequestMapping("deleteEmp")
    public String deleteEmp(Integer id) {
        employeeService.deleteById(id);
        return "redirect:showEmployees";
    }

}
