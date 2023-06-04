package com.atguigu.syt.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.syt.hosp.repository.HospitalRepository;
import com.atguigu.syt.hosp.service.HospitalService;
import com.atguigu.syt.model.hosp.Hospital;
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
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public void saveHospital(Map<String, Object> hospitalMap) {

        String toJSONString = JSONObject.toJSONString(hospitalMap);
        Hospital hospital = JSONObject.parseObject(toJSONString, Hospital.class);

        Hospital byHoscode = hospitalRepository.findByHoscode(hospital.getHoscode());
        if (byHoscode == null) {
            // 1可以 0禁用
            hospital.setStatus(0);
            hospitalRepository.save(hospital);
        } else {
            hospital.setId(byHoscode.getId());
            hospital.setStatus(byHoscode.getStatus());
            hospitalRepository.save(hospital);
        }


    }

    @Override
    public Hospital getByHoscode(String hoscode) {
        return hospitalRepository.findByHoscode(hoscode);

    }

}
