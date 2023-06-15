package com.atguigu.syt.hosp.service.impl;

import com.atguigu.syt.hosp.mapper.HospitalSetMapper;
import com.atguigu.syt.hosp.service.HospitalSetService;
import com.atguigu.syt.model.hosp.HospitalSet;
import com.atguigu.syt.vo.hosp.HospitalSetQueryVo;
import com.atguigu.syt.vo.order.SignInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 医院设置表 服务实现类
 * </p>
 *
 * @author xiwen
 * @since 2023-05-29
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    @Override
    public Page<HospitalSet> getPageByHospitalQuery(Long pageNum, Long pageSize, HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> page = new Page<>(pageNum, pageSize);

        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(hospitalSetQueryVo.getHosname()), "hosname", hospitalSetQueryVo.getHosname());
        queryWrapper.eq(!StringUtils.isEmpty(hospitalSetQueryVo.getHoscode()), "hoscode", hospitalSetQueryVo.getHoscode());
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public String getHospitalSignKey(String hoscode) {
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hoscode", hoscode);

        HospitalSet hospitalSet = baseMapper.selectOne(queryWrapper);
        return hospitalSet.getSignKey();
    }

    @Override
    public SignInfoVo getSignInfoVoByHocode(String hoscode) {
        LambdaQueryWrapper<HospitalSet> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(HospitalSet::getHoscode, hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(queryWrapper);
        SignInfoVo signInfoVo = new SignInfoVo();
        BeanUtils.copyProperties(hospitalSet, signInfoVo);
        return signInfoVo;
    }
}
