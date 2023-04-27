package com.xiwen.system.controller;

import com.xiwen.common.result.Result;
import com.xiwen.model.system.SysRole;
import com.xiwen.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/27 -14:50
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/system")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("findAll")
    public Result<List<SysRole>> findAll() {
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }
}
