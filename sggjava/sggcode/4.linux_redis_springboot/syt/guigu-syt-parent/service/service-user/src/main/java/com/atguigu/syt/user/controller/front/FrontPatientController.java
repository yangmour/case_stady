package com.atguigu.syt.user.controller.front;

import com.atguigu.common.service.utils.AuthContextHolder;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.model.user.Patient;
import com.atguigu.syt.user.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/14 -15:40
 * @Version: 1.0
 */
@Api(tags = "就诊人管理")
@RestController
@RequestMapping("/front/user/patient/auth")
@RequiredArgsConstructor
public class FrontPatientController {

    private final AuthContextHolder authContextHolder;
    private final PatientService patientService;

    //增
    @ApiOperation("增加就诊人信息")
    @ApiImplicitParam(name = "patient", value = "就诊人信息", required = true)
    @PostMapping("save")
    public Result<Object> save(@RequestBody Patient patient, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        patient.setUserId(userId);

        patientService.save(patient);
        return Result.ok().message("保存成功！");

    }

    //删
    @ApiOperation("删除就诊人信息")
    @ApiImplicitParam(name = "pid", value = "就诊人信息id", required = true)
    @DeleteMapping("remove/{pid}")
    public Result<Object> save(@PathVariable Long pid, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);

        boolean flag = patientService.deleteByPidAndUid(userId, pid);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //改:回显
    @ApiOperation("回显就诊人信息")
    @ApiImplicitParam(name = "pid", value = "就诊人信息id", required = true)
    @GetMapping("edit/{pid}")
    public Result<Object> edit(@PathVariable Long pid, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);

        Patient patient = patientService.getByUidAndPid(userId, pid);
        return Result.ok(patient);
    }

    //改:改
    @ApiOperation("修改就诊人信息")
    @ApiImplicitParam(name = "patient", value = "就诊人信息", required = true)
    @PutMapping("update")
    public Result<Object> update(@RequestBody Patient patient, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        patient.setUserId(userId);
        patientService.updateById(patient);
        return Result.ok().message("保存成功！");

    }

    //查
//改:回显
    @ApiOperation("回显就诊人信息列表")
    @GetMapping("findAll")
    public Result<Object> findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);

        List<Patient> patients = patientService.findAll(userId);
        return Result.ok(patients);
    }
}
