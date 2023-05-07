package com.xiwen.system.controller;

import com.xiwen.common.result.Result;
import com.xiwen.model.system.SysMenu;
import com.xiwen.model.vo.AssignMenuVo;
import com.xiwen.system.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/07 -15:43
 * @Version: 1.0
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation("查看全部菜单")
    @GetMapping("findMenuNodes")
    public Result findMenuNodes() {
        List<SysMenu> sysMenuList = sysMenuService.findMenuNodes();
        return Result.ok(sysMenuList);
    }

    @ApiOperation("添加菜单")
    @PostMapping("save")
    public Result save(@RequestBody SysMenu sysMenu) {
        sysMenuService.saveMenu(sysMenu);
        return Result.ok();
    }

    @GetMapping("getById/{id}")
    public Result getById(@PathVariable Long id) {
        SysMenu sysMenu = sysMenuService.getByIdMenu(id);
        return Result.ok(sysMenu);
    }

    @ApiOperation("修改菜单")
    @PutMapping("update")
    public Result update(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateMenu(sysMenu);
        return Result.ok();
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Long id) {
        sysMenuService.deleteById(id);
        return Result.ok();
    }


    @GetMapping("getRoleMenuList/{id}")
    public Result getRoleMenuList(@PathVariable Long id) {
        List<SysMenu> sysMenuList = sysMenuService.getRoleMenuList(id);
        return Result.ok(sysMenuList);
    }


    @PostMapping("assignMenu")
    public Result assignMenu(@RequestBody AssignMenuVo assignMenuVo) {
        sysMenuService.assignMenu(assignMenuVo);
        return Result.ok();
    }

}
