package com.xiwen.dao;

import com.xiwen.bean.Employee;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/01 -11:40
 * @Version: 1.0
 */
public interface EmployeeDao {

    Employee getById(Integer id);

    List<Employee> findAll();

    String getByIdName(Integer id);

    int insert(Employee employee);

    int delete(Integer employee);

    int update(Employee employee);

}
