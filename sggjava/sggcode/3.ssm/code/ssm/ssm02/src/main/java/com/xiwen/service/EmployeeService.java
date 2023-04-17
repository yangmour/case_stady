package com.xiwen.service;

import com.xiwen.bean.Employee;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/17 -15:07
 * @Version: 1.0
 */
public interface EmployeeService {

    Employee getById(Integer id);
    List<Employee> findAll();

}
