package com.xiwen.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiwen.common.result.Result;
import com.xiwen.common.util.MD5;
import com.xiwen.model.system.SysUser;
import com.xiwen.model.vo.SysUserQueryVo;
import com.xiwen.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -14:50
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/system/sysUser")
@Api(tags = "用户管理接口")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("添加用户")
    @PostMapping("saveUser")
    public Result<Object> saveUser(@ApiParam(value = "需要添加的对象") @RequestBody SysUser sysUser) {
        sysUser.setPassword(MD5.encrypt(sysUser.getPassword()));
        sysUser.setStatus(1);
        sysUser.setHeadUrl("https://img2.baidu.com/it/u=3618236253,1028428296&fm=253");

        sysUserService.save(sysUser);
        return Result.ok(sysUser);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("removeUser/{id}")
    public Result<Object> removeUser(@ApiParam(value = "需要删除的id") @PathVariable Integer id) {
        sysUserService.removeById(id);
        return Result.ok();
    }

    @ApiOperation("批量删除角色")
    @PostMapping("batchRemoveUser")
    public Result<Object> batchRemoveUser(
            @ApiParam("要删除id们") @RequestBody List<Integer> ids) {
        sysUserService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("根据id寻找用户")
    @GetMapping("edit/{id}")
    public Result<Object> edit(
            @ApiParam("要修改的对象") @PathVariable Integer id) {

        return Result.ok(sysUserService.getById(id));
    }

    @ApiOperation("修改角色")
    @PutMapping("modifUser")
    public Result<Object> modifUser(
            @ApiParam("要修改的对象") @RequestBody SysUser sysUser) {

        sysUser.setUpdateTime(null);
        sysUserService.updateById(sysUser);
        return Result.ok();
    }

    @ApiOperation("根据带分页的模糊查询名字的")
    @PostMapping("findByNamePage/{pageNum}/{sizeNum}")
    public Result<Page<SysUser>> findByNamePage(
            @ApiParam("页码") @PathVariable Integer pageNum,
            @ApiParam("条数") @PathVariable Integer sizeNum,
            @ApiParam(value = "查询条件的", required = true) @RequestBody SysUserQueryVo sysUserQueryVo) {

        Page<SysUser> page = new Page<>(pageNum, sizeNum);
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();

        String keyword = sysUserQueryVo.getKeyword();
        // 如果不为空根据昵称，用户，还有手机号查询
        if (!StringUtils.isEmpty(keyword)) {
            queryWrapper.and(qw -> qw.like(SysUser::getName, keyword)
                    .or().like(SysUser::getUsername, keyword)
                    .or().eq(SysUser::getPhone, keyword));

        }

        // 根据时间模糊查询
        String createTimeBegin = sysUserQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysUserQueryVo.getCreateTimeEnd();
        queryWrapper.ge(
                !StringUtils.isEmpty(createTimeBegin),
                SysUser::getCreateTime,
                createTimeBegin);
        queryWrapper.le(
                !StringUtils.isEmpty(createTimeEnd),
                SysUser::getCreateTime,
                createTimeEnd);

        sysUserService.page(page, queryWrapper);
        System.out.println(page.getRecords());
        return Result.ok(page);
    }

}
