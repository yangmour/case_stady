package com.xiwen.dao;

import com.xiwen.bean.Employee;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/01 -11:40
 * @Version: 1.0
 */
public interface EmployeeDao {

    Employee getById(Integer id);

    List<Employee> getByMap(Map<String, Object> map);

    List<Employee> getByMap02(Map<String, Object> map);

    int update(Employee e);

    List<Employee> getByIds(List<Integer> ids);

}
