package com.xiwen.service.impl;

import com.xiwen.bean.Employee;
import com.xiwen.mapper.EmployeeMapper;
import com.xiwen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/11 -18:09
 * @Version: 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getById(Integer id) {
        return employeeMapper.getById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insert(employee);

    }

    @Transactional
    @Override
    public int update(Employee employee) {
        int row = employeeMapper.update(employee);
//        int a = 10 / 0;
        return row;

    }

    @Transactional
    @Override
    public int delete(Integer id) {
        int row = employeeMapper.delete(id);
//        int a = 10 / 0;
        return row;
    }
}
