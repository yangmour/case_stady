package com.xiwen.dao;

import com.xiwen.bean.Department;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/01 -15:25
 * @Version: 1.0
 */
public interface DepartmentDao {
    Department getById(Integer id);

    List<Department> findAll();

    String getByIdName(Integer id);

    int insert(Department department);

    int delete(Integer id);

    int update(Department department);
}
