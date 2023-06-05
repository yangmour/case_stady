package com.atguigu.syt.hosp.controller.api;

import com.atguigu.common.util.result.Result;
import com.atguigu.syt.hosp.service.DepartmentService;
import com.atguigu.syt.hosp.service.HospitalService;
import com.atguigu.syt.hosp.service.HospitalSetService;
import com.atguigu.syt.hosp.service.ScheduleService;
import com.atguigu.syt.hosp.utils.HttpRequestHelper;
import com.atguigu.syt.model.hosp.Department;
import com.atguigu.syt.model.hosp.Hospital;
import com.atguigu.syt.model.hosp.Schedule;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/04 -16:23
 * @Version: 1.0
 */
@Api(tags = "医院管理API接口")
@RestController
@RequestMapping("api/hosp")
public class ApiHospitalController {

    @Autowired
    private HospitalSetService hospitalSetService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private ScheduleService scheduleService;

    @ApiOperation(value = "上传医院基本信息")
    @PostMapping("saveHospital")
    public Result<Object> saveHospital(HttpServletRequest httpServletRequest) {

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> hospitalMap = HttpRequestHelper.switchMap(parameterMap);

        String hoscode = (String) hospitalMap.get("hoscode");
        String signKey = hospitalSetService.getHospitalSignKey(hoscode);

        //验证签名
        HttpRequestHelper.checkSign(hospitalMap, signKey);

        hospitalService.saveHospital(hospitalMap);
        return Result.ok();
    }

    @ApiOperation(value = "获取医院信息")
    @PostMapping("hospital/show")
    public Result<Object> show(HttpServletRequest httpServletRequest) {

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> hospitalMap = HttpRequestHelper.switchMap(parameterMap);

        String hoscode = (String) hospitalMap.get("hoscode");
        String signKey = hospitalSetService.getHospitalSignKey(hoscode);
        //验证签名
        HttpRequestHelper.checkSign(hospitalMap, signKey);

        Hospital hospital = hospitalService.getByHoscode(hoscode);
        return Result.ok(hospital);
    }

    @ApiOperation(value = "上传科室信息")
    @PostMapping("saveDepartment")
    public Result<Object> saveDepartment(HttpServletRequest httpServletRequest) {

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> departmentMap = HttpRequestHelper.switchMap(parameterMap);

        String hoscode = (String) departmentMap.get("hoscode");
        String signKey = hospitalSetService.getHospitalSignKey(hoscode);
        //验证签名
        HttpRequestHelper.checkSign(departmentMap, signKey);

        departmentService.saveDepartment(departmentMap);
        return Result.ok();
    }

    //department/list
    @ApiOperation(value = "查询科室信息")
    @PostMapping("department/list")
    public Result<Object> departmentList(HttpServletRequest httpServletRequest) {

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> departmentMap = HttpRequestHelper.switchMap(parameterMap);

        String hoscode = (String) departmentMap.get("hoscode");
        String signKey = hospitalSetService.getHospitalSignKey(hoscode);
        //验证签名
        HttpRequestHelper.checkSign(departmentMap, signKey);

        Page<Department> departmentPage = departmentService.findDepartment(departmentMap);
        return Result.ok(departmentPage);
    }

    //saveSchedule
    @ApiOperation(value = "上传排班信息")
    @PostMapping("saveSchedule")
    public Result<Object> saveSchedule(HttpServletRequest httpServletRequest) {

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> scheduleMap = HttpRequestHelper.switchMap(parameterMap);

        String hoscode = (String) scheduleMap.get("hoscode");
        String signKey = hospitalSetService.getHospitalSignKey(hoscode);
        //验证签名
        HttpRequestHelper.checkSign(scheduleMap, signKey);

        scheduleService.saveSchedule(scheduleMap);
        return Result.ok();
    }


    @ApiOperation(value = "删除科室信息")
    @PostMapping("department/remove")
    public Result<Object> departmentRemove(HttpServletRequest httpServletRequest) {

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> departmentMap = HttpRequestHelper.switchMap(parameterMap);

        String hoscode = (String) departmentMap.get("hoscode");
        String signKey = hospitalSetService.getHospitalSignKey(hoscode);
        //验证签名
        HttpRequestHelper.checkSign(departmentMap, signKey);

        departmentService.departmentRemove(departmentMap);
        return Result.ok();
    }

    @ApiOperation(value = "获取排班分页列表")
    @PostMapping("/schedule/list")
    public Result<Object> scheduleList(HttpServletRequest httpServletRequest) {

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> scheduleMap = HttpRequestHelper.switchMap(parameterMap);

        String hoscode = (String) scheduleMap.get("hoscode");
        String signKey = hospitalSetService.getHospitalSignKey(hoscode);
        //验证签名
        HttpRequestHelper.checkSign(scheduleMap, signKey);

        Page<Schedule> schedulePage = scheduleService.findSchedule(scheduleMap);
        return Result.ok(schedulePage);
    }


    @ApiOperation(value = "删除科室信息")
    @PostMapping("schedule/remove")
    public Result<Object> scheduleRemove(HttpServletRequest httpServletRequest) {

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Map<String, Object> scheduleMap = HttpRequestHelper.switchMap(parameterMap);

        String hoscode = (String) scheduleMap.get("hoscode");
        String signKey = hospitalSetService.getHospitalSignKey(hoscode);
        //验证签名
        HttpRequestHelper.checkSign(scheduleMap, signKey);

        scheduleService.scheduleRemove(scheduleMap);
        return Result.ok();
    }
}
