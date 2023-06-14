package com.atguigu.syt.user.service.impl;


import com.atguigu.syt.cmn.client.DictFeignClient;
import com.atguigu.syt.cmn.client.RegionFeignClient;
import com.atguigu.syt.enums.DictTypeEnum;
import com.atguigu.syt.model.user.Patient;
import com.atguigu.syt.user.mapper.PatientMapper;
import com.atguigu.syt.user.service.PatientService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 就诊人表 服务实现类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-07
 */
@Service
@RequiredArgsConstructor
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

    private final DictFeignClient dictFeignClient;
    private final RegionFeignClient regionFeignClient;

    @Override
    public boolean deleteByPidAndUid(Long userId, Long pid) {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getUserId, userId);
        queryWrapper.eq(Patient::getId, pid);
        int rows = baseMapper.delete(queryWrapper);

        return rows > 0;
    }

    @Override
    public Patient getByUidAndPid(Long userId, Long pid) {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getUserId, userId);
        queryWrapper.eq(Patient::getId, pid);
        Patient patient = baseMapper.selectOne(queryWrapper);

        packPatient(patient);
        return patient;
    }

    private void packPatient(Patient patient) {
        //省市区信息
        String provinceCode = patient.getProvinceCode();
        String cityCode = patient.getCityCode();
        String districtCode = patient.getDistrictCode();

        String provinceName = regionFeignClient.getRegionName(provinceCode);
        String cityName = regionFeignClient.getRegionName(cityCode);
        String districtName = regionFeignClient.getRegionName(districtCode);

        patient.getParam().put("provinceString", provinceName);
        patient.getParam().put("cityString", cityName);
        patient.getParam().put("districtString", districtName);

        //证件类型名称
        String certificatesTypeString = dictFeignClient.getHostName(DictTypeEnum.CERTIFICATES_TYPE.getDictTypeId(), patient.getCertificatesType());
        patient.getParam().put("certificatesTypeString", certificatesTypeString);
        String contactsCertificatesNo = dictFeignClient.getHostName(DictTypeEnum.CERTIFICATES_TYPE.getDictTypeId(), patient.getContactsCertificatesType());
        patient.getParam().put("contactsCertificatesTypeString", contactsCertificatesNo);
    }

    @Override
    public List<Patient> findAll(Long userId) {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getUserId, userId);
        List<Patient> patients = baseMapper.selectList(queryWrapper);

        patients.forEach(patient -> {
            String certificatesTypeString = dictFeignClient.getHostName(DictTypeEnum.CERTIFICATES_TYPE.getDictTypeId(), patient.getCertificatesType());
            patient.getParam().put("certificatesTypeString", certificatesTypeString);
            patient.getParam().put("expenseMethod", patient.getIsInsure() == 0 ? "自费" : "医保");
        });
        return patients;
    }
}
