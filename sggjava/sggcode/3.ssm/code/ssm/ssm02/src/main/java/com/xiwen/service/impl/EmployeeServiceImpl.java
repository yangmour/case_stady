package com.xiwen.service.impl;

import com.xiwen.bean.Employee;
import com.xiwen.dao.EmployeeDao;
import com.xiwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/17 -15:08
 * @Version: 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getById(Integer id) {
        return employeeDao.getById(id);
    }
}
