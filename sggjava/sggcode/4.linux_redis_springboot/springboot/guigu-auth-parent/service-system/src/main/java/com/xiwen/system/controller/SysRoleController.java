package com.xiwen.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiwen.common.result.Result;
import com.xiwen.model.system.SysRole;
import com.xiwen.system.service.SysRoleService;
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
@RequestMapping("/admin/system/sysRole")
@Api(tags = "角色管理接口")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    @ApiOperation("获取所有角色数据")
    @GetMapping("findAll")
    public Result<List<SysRole>> findAll() {
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

    @ApiOperation("添加角色")
    @PostMapping("saveRole")
    public Result<Object> saveRole(@ApiParam(value = "需要添加的对象") @RequestBody SysRole sysRole) {
        sysRoleService.save(sysRole);
        return Result.ok();
    }

    @ApiOperation("删除角色")
    @DeleteMapping("removeRole/{id}")
    public Result<Object> removeRole(@ApiParam(value = "需要删除的id") @PathVariable Integer id) {
        sysRoleService.removeById(id);
        return Result.ok();
    }

    @ApiOperation("批量删除角色")
    @PostMapping("removeRole")
    public Result<Object> removeRole(
            @ApiParam("要删除id们") @RequestBody List<Integer> ids) {
        sysRoleService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("修改角色")
    @PutMapping("modifRole")
    public Result<Object> modifRole(
            @ApiParam("要修改的对象") @RequestBody SysRole sysRole) {
        sysRoleService.updateById(sysRole);
        return Result.ok();
    }

    @ApiOperation("根据带分页的查询数据")
    @GetMapping("findById/{pageNum}/{sizeNum}")
    public Result<Page<SysRole>> findAllPage(@ApiParam("页码") @PathVariable Integer pageNum,@ApiParam("条数")  @PathVariable Integer sizeNum) {
        Page<SysRole> page = new Page<>(pageNum, sizeNum);
        sysRoleService.page(page);
        return Result.ok(page);
    }

    @ApiOperation("根据名字查询角色")
    @GetMapping("findByName/{roleName}")
    public Result<List<SysRole>> findById(@ApiParam("根据名字模糊查询")  @PathVariable String roleName) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>()
                .like(!StringUtils.isEmpty(roleName), "role_name", roleName);
        return Result.ok(sysRoleService.list(queryWrapper));
    }

}
