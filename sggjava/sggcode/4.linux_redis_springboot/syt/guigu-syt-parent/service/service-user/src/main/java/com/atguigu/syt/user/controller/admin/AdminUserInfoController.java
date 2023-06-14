package com.atguigu.syt.user.controller.admin;


import com.atguigu.common.util.result.Result;
import com.atguigu.syt.model.user.UserInfo;
import com.atguigu.syt.user.service.UserInfoService;
import com.atguigu.syt.vo.user.UserInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xiwen
 * @since 2023-06-07
 */

@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/admin/user/userInfo")
@RequiredArgsConstructor
public class AdminUserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping("page/{pageNum}/{pageSize}")
    public Result<Object> page(@PathVariable Integer pageNum, @PathVariable Integer pageSize, UserInfoQueryVo userInfoQueryVo) {

        Page<UserInfo> page = userInfoService.getList(pageNum, pageSize, userInfoQueryVo);
        return Result.ok(page);
    }

}

