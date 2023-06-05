package com.atguigu.syt.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.syt.hosp.repository.DepartmentRepository;
import com.atguigu.syt.hosp.service.DepartmentService;
import com.atguigu.syt.model.hosp.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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

    @Override
    public Page<Department> findDepartment(Map<String, Object> departmentMap) {

        Integer page = Integer.parseInt((String) departmentMap.get("page"));
        Integer limit = Integer.parseInt((String) departmentMap.get("limit"));
        String hoscode = (String) departmentMap.get("hoscode");

        Department department = new Department();
        department.setHoscode(hoscode);
        Example<Department> example = Example.of(department);

        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Order.asc("depcode")));

        return departmentRepository.findAll(example, pageable);
    }

    @Override
    public void departmentRemove(Map<String, Object> departmentMap) {

        String hoscode = (String) departmentMap.get("hoscode");
        String depcode = (String) departmentMap.get("depcode");

        Department department = departmentRepository.findByHoscodeAndDepcode(hoscode, depcode);

        if (department != null) {
            departmentRepository.delete(department);
        }
    }


}
