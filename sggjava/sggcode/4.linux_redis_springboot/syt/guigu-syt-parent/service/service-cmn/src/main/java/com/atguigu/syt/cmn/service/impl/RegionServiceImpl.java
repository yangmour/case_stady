package com.atguigu.syt.cmn.service.impl;


import com.atguigu.syt.cmn.mapper.RegionMapper;
import com.atguigu.syt.cmn.service.RegionService;
import com.atguigu.syt.model.cmn.Region;
import com.atguigu.syt.vo.cmn.RegionVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    /**
     * @param parentCode
     * @return
     * @Cacheable： 在方法执行前查看是否有缓存对应的数据，
     * 如果有直接返回数据，如果没有，则调用方法获取数据返回，并缓存起来。
     * <p>
     * value：缓存的名字
     * key：缓存的key
     * unless：条件符合则不缓存，是对出参进行判断，出参用#result表示
     */
    @Override
    @Cacheable(value = "regionList", key = "#parentCode", unless = "#result.size()==0")
    public List<RegionVo> getByParentCode(String parentCode) {

        //在数据库中获取数据
        QueryWrapper<Region> regionQueryWrapper = new QueryWrapper<>();
        regionQueryWrapper.eq("parent_code", parentCode);
        List<Region> regions = baseMapper.selectList(regionQueryWrapper);

        List<RegionVo> regionVoList = regions.stream()
                .map(item -> new RegionVo(item.getId(), item.getName(), item.getCode(), item.getLevel(), item.getLevel() < 3 ? true : false))
                .collect(Collectors.toList());

        return regionVoList;
    }

    @Override
    @CachePut(value = "regionSaveTest", key = "#region.id")
    public Region saveRegionWithCacheManager(Region region) {
        baseMapper.insert(region);
        return region;
    }

    @Override
    @CacheEvict(value = "regionSaveTest", key = "#id")
    public void deleteRegionWithCacheManager(Long id) {
        baseMapper.deleteById(id);
    }

//    第一种使用RedisTemplate对象缓存
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Override
//    public List<RegionVo> getByParentCode(String parentCode) {
//
//        //1.从redis中获取对象
//        List<RegionVo> regionVoList = (List<RegionVo>) redisTemplate.boundValueOps("region").get();
//        //如果缓存中存在就返回
//        if (regionVoList != null){
//            return regionVoList;
//        }
//        //2.在数据库中获取数据
//        QueryWrapper<Region> regionQueryWrapper = new QueryWrapper<>();
//        regionQueryWrapper.eq("parent_code", parentCode);
//        List<Region> regions = baseMapper.selectList(regionQueryWrapper);
//
//        regionVoList = regions.stream()
//                .map(item -> new RegionVo(item.getId(), item.getName(), item.getCode(), item.getLevel(), item.getLevel() < 3 ? true : false))
//                .collect(Collectors.toList());
//
//        //3.将查询的数据放在缓存中
//        redisTemplate.boundValueOps("region").set(regionVoList,5, TimeUnit.MINUTES);
//
//        return regionVoList;
//    }
}
