package com.xiwen.service;

import com.xiwen.bean.Employee;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/14 -19:35
 * @Version: 1.0
 */
public interface EmployeeService {
    List<Employee> findAll();

    void insert(Employee employee);

    void update(Employee employee);

    void delete(Integer id);

    Employee getById(Integer id);
}
