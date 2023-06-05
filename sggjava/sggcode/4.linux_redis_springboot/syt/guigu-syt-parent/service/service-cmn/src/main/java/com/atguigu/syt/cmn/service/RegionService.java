package com.atguigu.syt.cmn.service;


import com.atguigu.syt.model.cmn.Region;
import com.atguigu.syt.vo.cmn.RegionExcelVo;
import com.atguigu.syt.vo.cmn.RegionVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xiwen
 * @since 2023-05-31
 */
public interface RegionService extends IService<Region> {

    List<RegionVo> getByParentCode(String parentCode);

    /**
     * 测试 @CachePut
     *
     * @param region
     * @return
     */
    Region saveRegionWithCacheManager(Region region);

    /**
     * 测试 @CacheEvict
     *
     * @param id
     */
    void deleteRegionWithCacheManager(Long id);

    List<RegionExcelVo> findRegionExcelVoList();

    void importData(MultipartFile file);

    String getRegionName(String code);

}
