package com.atguigu.syt.cmn.service.impl;


import com.atguigu.syt.cmn.mapper.RegionMapper;
import com.atguigu.syt.cmn.service.RegionService;
import com.atguigu.syt.model.cmn.Region;
import com.atguigu.syt.vo.cmn.RegionVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiwen
 * @since 2023-05-31
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    @Override
    public List<RegionVo> getByParentCode(String parentCode) {
        QueryWrapper<Region> regionQueryWrapper = new QueryWrapper<>();
        regionQueryWrapper.eq("parent_code", parentCode);
        List<Region> regions = baseMapper.selectList(regionQueryWrapper);

        List<RegionVo> regionVoList = regions.stream()
                .map(item -> new RegionVo(item.getId(), item.getName(), item.getCode(), item.getLevel(), item.getLevel() < 3 ? true : false))
                .collect(Collectors.toList());
        return regionVoList;
    }
}
