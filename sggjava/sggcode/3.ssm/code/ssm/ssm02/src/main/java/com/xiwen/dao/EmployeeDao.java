package com.xiwen.dao;

import com.xiwen.bean.Employee;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/17 -14:26
 * @Version: 1.0
 */
public interface EmployeeDao {
    Employee getById(Integer id);

    List<Employee> findAll();

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteById(Integer id);


}
