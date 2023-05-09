package com.xiwen.system.controller;

import com.xiwen.common.result.Result;
import com.xiwen.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/28 -22:33
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

//    @PostMapping("/login")
//    public Result<Object> login(@RequestBody LoginVo loginVo) {
//        HashMap<String, Object> map = sysUserService.login(loginVo);
//        return Result.ok(map);
//    }

    @GetMapping("/info")
    public Result<Object> info(String token) {
        HashMap<String, Object> map = sysUserService.getUserMenuByToken(token);
        return Result.ok(map);
    }

    @PostMapping("/logout")
    public Result<Object> logout() {
        System.out.println();
        return Result.ok();
    }

}
