package com.atguigu.syt.hosp.controller.front;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.hosp.service.DepartmentService;
import com.atguigu.syt.vo.hosp.DepartmentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/07 -19:59
 * @Version: 1.0
 */
@Api(tags = "科室管理")
@RestController
@RequestMapping("/front/hosp/department")
public class FrontDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "查询医院所有科室列表")
    @ApiImplicitParam(name = "hoscode", value = "医院编码", required = true)
    @RequestMapping("getDeptList/{hoscode}")
    public Result<Object> getDeptList(@PathVariable String hoscode) {
        List<DepartmentVo> deptList = departmentService.getDeptList(hoscode);
        return Result.ok(deptList);
    }

}
