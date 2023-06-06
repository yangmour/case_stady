package com.atguigu.syt.hosp.controller.admin;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.hosp.service.DepartmentService;
import com.atguigu.syt.vo.hosp.DepartmentVo;
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
 * @Create: 2023/06/06 -15:14
 * @Version: 1.0
 */
@Api(tags = "医院排版信息")
@RestController
@RequestMapping("/admin/hosp/department")
public class AdminDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("查询所有科室信息")
    @ApiImplicitParam(name = "hoscode", value = "医院编码", required = true)
    @GetMapping("/getDeptList/{hoscode}")
    public Result<Object> getDeptList(@PathVariable String hoscode) {
        List<DepartmentVo> departmentVoList = departmentService.getDeptList(hoscode);
        return Result.ok(departmentVoList);
    }
}
