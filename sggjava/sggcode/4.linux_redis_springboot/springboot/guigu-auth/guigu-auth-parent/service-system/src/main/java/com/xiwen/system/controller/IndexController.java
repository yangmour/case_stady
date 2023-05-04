package com.xiwen.system.controller;

import com.xiwen.common.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/login")
    public Result<Object> login(@RequestBody Map<String, Object> map) {
        map.put("token", "admin");
        return Result.ok(map);
    }

    @GetMapping("/info")
    public Result<Object> info(String token) {
        HashMap<String, Object> map = null;
        if ("admin".equals(token)) {
            map = new HashMap<>();
            ArrayList<String> list = new ArrayList<>();
            list.add("admin");
            map.put("roles", list);
            map.put("introduction", "返回信息");
            map.put("name", "admin");
            map.put("avatar", "https://inews.gtimg.com/newsapp_bt/0/13294928426/1000");
        } else {
            return Result.fail();
        }
        return Result.ok(map);
    }

    @PostMapping("/logout")
    public Result<Object> logout() {
        System.out.println();
        return Result.ok();
    }

}
