package com.xiwen.dao;

import com.xiwen.bean.Employee;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/17 -14:26
 * @Version: 1.0
 */
public interface EmployeeDao {
    Employee getById(Integer id);
}
