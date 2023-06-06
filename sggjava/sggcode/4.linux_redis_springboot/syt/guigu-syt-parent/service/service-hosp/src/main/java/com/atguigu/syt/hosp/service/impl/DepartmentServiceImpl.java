package com.atguigu.syt.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.syt.hosp.repository.DepartmentRepository;
import com.atguigu.syt.hosp.service.DepartmentService;
import com.atguigu.syt.model.hosp.Department;
import com.atguigu.syt.vo.hosp.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public List<DepartmentVo> getDeptList(String hoscode) {
        //查询排班科室
        Department query = new Department();
        query.setHoscode(hoscode);
        Example<Department> example = Example.of(query);
        List<Department> departments = departmentRepository.findAll(example);

        //根据大科室分组
        Map<String, List<Department>> bigCodeGroupBy = departments.stream().collect(Collectors.groupingBy(Department::getBigcode));
        //结果集
        List<DepartmentVo> departmentVoList = new ArrayList<>();

        Set<Map.Entry<String, List<Department>>> entries = bigCodeGroupBy.entrySet();
        for (Map.Entry<String, List<Department>> entry : entries) {
            String bigCode = entry.getKey();
            List<Department> departmentList = entry.getValue();
            // 封装大科室
            DepartmentVo departmentVo = new DepartmentVo();
            departmentVo.setDepcode(bigCode);
            departmentVo.setDepname(departmentList.get(0).getBigname());

            // 封装小科室
            List<DepartmentVo> children = new ArrayList<>();
            for (Department department : departmentList) {
                DepartmentVo childrenDepartmentVo = new DepartmentVo();
                childrenDepartmentVo.setDepcode(department.getDepcode());
                childrenDepartmentVo.setDepname(department.getDepname());
                //封装到list集合
                children.add(childrenDepartmentVo);
            }

            // 将封装的小科室放入大科室的下一级中
            departmentVo.setChildren(children);

            //封装到result集合
            departmentVoList.add(departmentVo);
        }

        return departmentVoList;
    }


}
