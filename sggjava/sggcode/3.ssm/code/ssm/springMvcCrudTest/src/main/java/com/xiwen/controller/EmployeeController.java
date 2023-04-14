package com.xiwen.controller;

import com.xiwen.bean.Department;
import com.xiwen.bean.Employee;
import com.xiwen.service.DepartmentService;
import com.xiwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/14 -18:41
 * @Version: 1.0
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Employee> emps = employeeService.findAll();
        model.addAttribute("emps", emps);
        return "index";
    }

    @RequestMapping("toInsertEmpPage")
    public String toAddEmpPage(Model model) {
        List<Department> depts = departmentService.findAll();
        model.addAttribute("depts", depts);
        return "insertEmp";
    }

    @RequestMapping(value = "insertEmp",method = RequestMethod.POST)
    public String insertEmp(Employee employee) {
        employeeService.insert(employee);
        return "redirect:/emp/";
    }

    @RequestMapping(value = "toUpdateEmpPage")
    public String toUpdateEmpPage(Model model,Integer id) {
        Employee emp = employeeService.getById(id);
        List<Department> depts = departmentService.findAll();
        model.addAttribute("emp", emp);
        model.addAttribute("depts", depts);
        return "updateEmp";
    }

    @RequestMapping(value = "updateEmp",method = RequestMethod.PUT)
    public String updateEmp(Employee employee) {
        employeeService.update(employee);
        return "redirect:/emp/";
    }

    @RequestMapping(value = "deleteEmp",method = RequestMethod.DELETE)
    public String deleteEmp(Integer id) {
        employeeService.delete(id);
        return "redirect:/emp/";
    }

}
