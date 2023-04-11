package com.xiwen.service;

import com.xiwen.bean.Employee;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/11 -18:08
 * @Version: 1.0
 */
public interface EmployeeService {

    Employee getById(Integer id);

    List<Employee> findAll();

    int insert(Employee employee);

    int update(Employee employee);

    int delete(Integer id);

}
