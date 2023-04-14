package com.xiwen.service;

import com.xiwen.bean.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/14 -19:32
 * @Version: 1.0
 */
public interface DepartmentService {

    List<Department> findAll();
}
