package com.atguigu.syt.hosp.controller.admin;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.hosp.service.HospitalService;
import com.atguigu.syt.model.hosp.Hospital;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/05 -16:21
 * @Version: 1.0
 */
@Api(tags = "医院管理")
@RestController
@RequestMapping("/admin/hosp/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @ApiOperation(value = "获取分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true),
            @ApiImplicitParam(name = "limit", value = "每页记录数", required = true),
            @ApiImplicitParam(name = "hosname", value = "查询字符串")})
    @GetMapping("/page/{pageNum}/{pageSize}")
    public Result<Object> pageList(@PathVariable Integer pageNum,
                                   @PathVariable Integer pageSize,
                                   @RequestParam String hosname) {
        Page<Hospital> page = hospitalService.selectPage(pageNum, pageSize, hosname);
        return Result.ok(page);
    }

    @ApiOperation(value = "更新上线状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hoscode", value = "医院编码", required = true),
            @ApiImplicitParam(name = "status", value = "状态（0：未上线 1：已上线）", required = true)})
    @GetMapping("/updateStatus/{hoscode}/{status}")
    public Result<Object> updateStatus(@PathVariable String hoscode,@PathVariable Integer status) {
        hospitalService.updateStatus(hoscode, status);
        return Result.ok();
    }

}
