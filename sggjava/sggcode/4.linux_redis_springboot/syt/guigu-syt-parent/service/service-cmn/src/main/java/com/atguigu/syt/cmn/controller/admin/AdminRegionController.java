package com.atguigu.syt.cmn.controller.admin;


import com.atguigu.common.util.result.Result;
import com.atguigu.syt.cmn.service.RegionService;
import com.atguigu.syt.vo.cmn.RegionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiwen
 * @since 2023-05-31
 */
@RestController
@RequestMapping("/cmn/region")
public class AdminRegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("findRegionListByParentCode/{parentCode}")
    public Result<Object> findRegionListByParentCode(@PathVariable String parentCode) {

        List<RegionVo> regionVoList = regionService.getByParentCode(parentCode);
        return Result.ok(regionVoList);
    }

}

