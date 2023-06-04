package com.atguigu.syt.hosp.service;

import com.atguigu.syt.model.hosp.Hospital;

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
}
