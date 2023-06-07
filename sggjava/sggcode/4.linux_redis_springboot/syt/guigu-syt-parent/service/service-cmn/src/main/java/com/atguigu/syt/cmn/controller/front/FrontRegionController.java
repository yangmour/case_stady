package com.atguigu.syt.cmn.controller.front;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.cmn.service.RegionService;
import com.atguigu.syt.vo.cmn.RegionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/07 -18:18
 * @Version: 1.0
 */
@Api(tags = "地区列表接口")
@RestController
@RequestMapping("/front/cmn/region")
public class FrontRegionController {

    @Autowired
    private RegionService regionService;

    @ApiOperation("根据市级编码地区列表接口")
    @ApiImplicitParam(name = "parentCode", value = "父级编码", required = true)
    @GetMapping("getRegionList/{parentCode}")
    public Result<Object> getRegionList(@PathVariable String parentCode) {
        List<RegionVo> regionVos = regionService.getByParentCode(parentCode);
        return Result.ok(regionVos);
    }


}
