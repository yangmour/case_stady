package com.atguigu.syt.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.enums.DictTypeEnum;
import com.atguigu.syt.hosp.repository.HospitalRepository;
import com.atguigu.syt.hosp.service.HospitalService;
import com.atguigu.syt.model.hosp.Hospital;
import com.atguigu.syt.cmn.client.DictFeignClient;
import com.atguigu.syt.cmn.client.RegionFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
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

    @Qualifier("dictDegradeFeignClient")
    @Autowired
    private DictFeignClient dictFeignClient;

    @Autowired
    private RegionFeignClient regionFeignClient;

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

    @Override
    public Page<Hospital> selectPage(Integer pageNum, Integer pageSize, String hosname) {
        Hospital query = new Hospital();
        if (!StringUtils.isEmpty(hosname)) {
            query.setHosname(hosname);
        }
        Example<Hospital> example = Example.of(query, ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        PageRequest pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Hospital> hospitalPage = hospitalRepository.findAll(example, pageable);

        hospitalPage.getContent().forEach(this::packageHospital);
        return hospitalPage;
    }

    private void packageHospital(Hospital hospital) {
        String hostype = hospital.getHostype(); //等级
        String provinceCode = hospital.getProvinceCode(); //省
        String cityCode = hospital.getCityCode();   //市
        String districtCode = hospital.getDistrictCode();   //区

        String hostName = dictFeignClient.getHostName(DictTypeEnum.HOSTYPE.getDictTypeId(), hostype);

        String provinceName = regionFeignClient.getRegionName(provinceCode);
        String cityName = regionFeignClient.getRegionName(cityCode);
        String districtName = regionFeignClient.getRegionName(districtCode);

        hospital.getParam().put("hospName", hostName);
        hospital.getParam().put("address", provinceName + cityName + districtName + hospital.getAddress());
    }

    @Override
    public void updateStatus(String hoscode, Integer status) {

        if (status != 1 && status != 0) {
            throw new GuiguException(ResultCodeEnum.PARAM_ERROR);
        }
        Hospital hospital = hospitalRepository.findByHoscode(hoscode);
        hospital.setStatus(status);
        hospitalRepository.save(hospital);
    }

    @Override
    public Hospital getDetail(String hoscode) {

        Hospital hospital = hospitalRepository.findByHoscode(hoscode);
        packageHospital(hospital);
        return hospital;
    }

    @Override
    public List<Hospital> getHospital(String hostype, String districtCode, String hosname) {
        Hospital queryHospital = new Hospital();
        queryHospital.setHostype(hostype);
        queryHospital.setDistrictCode(districtCode);
        queryHospital.setHosname(hosname);

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("hosname", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("hostype", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("districtCode", ExampleMatcher.GenericPropertyMatchers.exact());

        Example<Hospital> example = Example.of(queryHospital, matching);
        List<Hospital> hospitals = hospitalRepository.findAll(example, Sort.by(Sort.Order.asc("hoscode")));

        for (Hospital hospital : hospitals) {
            packageHospital(hospital);
        }

        return hospitals;
    }
}
