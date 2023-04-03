package com.xiwen.dao;

import com.xiwen.bean.Employee;
import org.apache.ibatis.annotations.Param;

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

    List<Employee> findAll();

    List<Employee> getByName(String name);

    List<Employee> getByNameAndSalary02(Map map);
    List<Employee> getByNameAndSalary(@Param("n") String name, Double salary);

    int insert(Employee employee);


}
