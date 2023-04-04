package com.xiwen.dao;

import com.xiwen.bean.Department;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/01 -15:25
 * @Version: 1.0
 */
public interface DepartmentDao {
    Department getById(Integer id);
}
