package com.atguigu.syt.cmn.controller.inner;

import com.atguigu.syt.cmn.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/05 -16:55
 * @Version: 1.0
 */

@Api(tags = "地区")
@RestController
@RequestMapping("/inner/cmn/region")
public class InnerRegionController {

    @Autowired
    private RegionService regionService;

    @ApiOperation(value = "根据地区编码获取地区名称")
    @ApiImplicitParam(name = "code", value = "值", required = true)
    @GetMapping(value = "/getName/{code}")
    public String getRegionName(@PathVariable String code) {
        return regionService.getRegionName(code);
    }
}
