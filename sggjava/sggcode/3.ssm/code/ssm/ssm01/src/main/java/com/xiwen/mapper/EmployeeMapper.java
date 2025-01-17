package com.xiwen.mapper;

import com.xiwen.bean.Employee;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/01 -11:40
 * @Version: 1.0
 */
public interface EmployeeMapper {

    Employee getById(Integer id);

    List<Employee> findAll();

    int insert(Employee employee);

    int update(Employee employee);

    int delete(Integer id);

}
