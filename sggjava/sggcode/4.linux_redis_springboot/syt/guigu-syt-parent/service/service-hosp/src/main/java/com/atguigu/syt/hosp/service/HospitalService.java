package com.atguigu.syt.hosp.service;

import com.atguigu.syt.model.hosp.Hospital;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -16:57
 * @Version: 1.0
 */
public interface HospitalService {
    void saveHospital(Map<String, Object> hospitalMap);

    Hospital getByHoscode(String hoscode);

    Page<Hospital> selectPage(Integer pageNum, Integer pageSize, String hosname);

    void updateStatus(String hoscode, Integer status);
}
