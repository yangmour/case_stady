package com.atguigu.syt.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.syt.hosp.repository.DepartmentRepository;
import com.atguigu.syt.hosp.service.DepartmentService;
import com.atguigu.syt.model.hosp.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -16:58
 * @Version: 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void saveDepartment(Map<String, Object> departmentMap) {
        String toJSONString = JSONObject.toJSONString(departmentMap);
        Department department = JSONObject.parseObject(toJSONString, Department.class);

        departmentRepository.save(department);
    }

}
