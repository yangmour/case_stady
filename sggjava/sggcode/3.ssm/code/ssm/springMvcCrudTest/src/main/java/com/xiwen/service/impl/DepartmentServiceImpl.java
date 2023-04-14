package com.xiwen.service.impl;

import com.xiwen.bean.Department;
import com.xiwen.mapper.DepartmentDao;
import com.xiwen.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/14 -19:32
 * @Version: 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> findAll() {
        return departmentDao.getDepartments().stream().collect(Collectors.toList());
    }
}
