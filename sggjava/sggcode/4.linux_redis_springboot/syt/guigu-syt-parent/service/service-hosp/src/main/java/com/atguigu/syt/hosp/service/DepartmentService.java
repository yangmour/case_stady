package com.atguigu.syt.hosp.service;

import com.atguigu.syt.model.hosp.Department;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -16:57
 * @Version: 1.0
 */
public interface DepartmentService {
    void saveDepartment(Map<String, Object> departmentMap);

    Page<Department> findDepartment(Map<String, Object> departmentMap);

    void departmentRemove(Map<String, Object> departmentMap);
}
