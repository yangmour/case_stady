package com.xiwen.service.impl;

import com.xiwen.bean.Employee;
import com.xiwen.mapper.EmployeeDao;
import com.xiwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/14 -19:36
 * @Version: 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeDao.getAll());
    }

    @Override
    public void insert(Employee employee) {
        employeeDao.saveOrUpdate(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.saveOrUpdate(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee getById(Integer id) {
        return employeeDao.get(id);
    }
}
