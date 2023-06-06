package com.atguigu.syt.hosp.controller.admin;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.hosp.service.ScheduleService;
import com.atguigu.syt.model.hosp.Schedule;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/06 -15:45
 * @Version: 1.0
 */
@Api(tags = "具体排班接口")
@RestController
@RequestMapping("/admin/hosp/schedule")
public class AdminScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @ApiImplicitParams({@ApiImplicitParam(name = "hospCode", value = "医院编号", required = true), @ApiImplicitParam(name = "deptCode", value = "科室编号", required = true), @ApiImplicitParam(name = "pageNum", value = "页码", required = true), @ApiImplicitParam(name = "pageSize", value = "条数", required = true)})
    @GetMapping("getScheduleRule/{hoscode}/{depCode}/{pageNum}/{pageSize}")
    public Result<Object> getScheduleRule(@PathVariable String hoscode,
                                          @PathVariable String depCode,
                                          @PathVariable Integer pageNum,
                                          @PathVariable Integer pageSize) {
        Map<String, Object> map = scheduleService.getScheduleRule(hoscode, depCode, pageNum, pageSize);
        return Result.ok(map);

    }

    @ApiOperation("查询排班详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hoscode", value = "医院编号", required = true),
            @ApiImplicitParam(name = "depcode", value = "科室编号", required = true),
            @ApiImplicitParam(name = "workDate", value = "工作时间", required = true)
    })
    @GetMapping("/getScheduleDetail/{hoscode}/{depcode}/{workDate}")
    public Result<Object> getScheduleDetail(@PathVariable String hoscode,
                                            @PathVariable String depcode,
                                            @PathVariable String workDate) {

        List<Schedule> schedules = scheduleService.getScheduleDetail(hoscode, depcode, workDate);
        return Result.ok(schedules);
    }

}
