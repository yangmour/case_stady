package com.atguigu.syt.hosp.controller.front;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.hosp.service.HospitalService;
import com.atguigu.syt.model.hosp.Hospital;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/07 -11:03
 * @Version: 1.0
 */
@Api(tags = "用户页面医院")
@RestController
@RequestMapping("/front/hosp/hospital")
public class FrontHospitalController {

    @Autowired
    private HospitalService hospitalService;

    @ApiOperation("获取医院")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hoscode", value = "医院编码", required = true),
            @ApiImplicitParam(name = "depcode", value = "科室编码", required = true),
            @ApiImplicitParam(name = "hosName", value = "医院名称")
    })
    @GetMapping("getHospitalList")
    public Result<Object> getHospitalList(String hostype, String districtCode, String hosname) {
        List<Hospital> hospitals = hospitalService.getHospital(hostype, districtCode, hosname);
        return Result.ok(hospitals);
    }


}
