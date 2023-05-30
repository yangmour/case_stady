package com.atguigu.syt.hosp.controller.admin;


import com.atguigu.common.util.result.Result;
import com.atguigu.common.util.tools.MD5;
import com.atguigu.syt.hosp.service.HospitalSetService;
import com.atguigu.syt.model.hosp.HospitalSet;
import com.atguigu.syt.vo.hosp.HospitalSetQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * <p>
 * 医院设置表 前端控制器
 * </p>
 *
 * @author xiwen
 * @since 2023-05-29
 */
@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@Slf4j
public class AdminHospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;

    // 增
    @ApiOperation("新增医院设置")
    @PostMapping("saveHospSet")
    public Result<Object> add(@ApiParam("医院设置对象") @RequestBody HospitalSet hospitalSet) {
        // 生成秘钥
        Random random = new Random();
        String signKey = MD5.encrypt(System.currentTimeMillis() + "" + random.nextInt(1000));
        hospitalSet.setSignKey(signKey);

        boolean flag = hospitalSetService.save(hospitalSet);
        if (flag) {
            return Result.ok();
        }
        return Result.fail();
    }

    // 删
    @ApiOperation("根据id删除医院")
    @DeleteMapping("delete/{id}")
    public Result<Object> delete(@ApiParam("医院的id") @PathVariable Long id) {
        boolean flag = hospitalSetService.removeById(id);
        if (flag) {
            return Result.ok();
        }
        return Result.fail();
    }

    @ApiOperation("根据id删除医院")
    @DeleteMapping("batchDelete")
    public Result<Object> batchDelete(@ApiParam("医院的id") @RequestBody List<Long> ids) {
        boolean flag = hospitalSetService.removeByIds(ids);
        if (flag) {
            return Result.ok();
        }
        return Result.fail();
    }

    // 改:回显
    @ApiOperation("根据医院id进行回显")
    @GetMapping("edit/{id}")
    public Result<Object> edit(@ApiParam("医院的id") @PathVariable Long id) {
        return Result.ok(hospitalSetService.getById(id));
    }

    // 改:修改
    @ApiOperation("根据医院id进行修改设置")
    @PutMapping("update")
    public Result<Object> update(@ApiParam(value = "医院设置对象") @RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag) {
            return Result.ok();
        }
        return Result.fail();
    }

    @ApiOperation("根据医院id进行修改状态设置")
    @PutMapping("updateStatus/{id}/{status}")
    public Result<Object> updateStatus(@ApiParam(value = "医院设置对象") @PathVariable Long id,
                                       @ApiParam("医院设置状态") @PathVariable Integer status) {
        HospitalSet hospitalSet = new HospitalSet();
        hospitalSet.setId(id);
        hospitalSet.setStatus(status);
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if (flag) {
            return Result.ok();
        }
        return Result.fail();
    }


    // 查
    @ApiOperation("根据医院id进行回显")
    @GetMapping("getHospSet/{id}")
    public Result<Object> getHospSet(@PathVariable Long id) {
        return Result.ok(hospitalSetService.getById(id));
    }

    // 查
    @PostMapping("page/{pageNum}/{pageSize}")
    public Result<Object> page(@ApiParam("页码") @PathVariable Long pageNum, @ApiParam("数量") @PathVariable Long pageSize, @ApiParam(value = "要搜索的医院名字和医院编号") @RequestBody HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> page = hospitalSetService.getPageByHospitalQuery(pageNum, pageSize, hospitalSetQueryVo);
        System.out.println(page.getTotal());
        System.out.println(page.getSize());
        return Result.ok(page);
    }

    @ApiOperation(value = "日志测试")
    @GetMapping("/log")
    public Result log() {

        log.trace("getHospSet trace");
        log.debug("getHospSet debug");
        log.info("getHospSet info");
        log.warn("getHospSet warn");
        log.error("getHospSet error");

        return Result.ok();
    }
}

