package com.atguigu.syt.user.controller.front;

import com.atguigu.common.service.utils.AuthContextHolder;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.model.user.UserInfo;
import com.atguigu.syt.user.service.UserInfoService;
import com.atguigu.syt.vo.user.UserAuthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/12 -23:42
 * @Version: 1.0
 */

@Api(tags = "用户管理")
@RestController
@RequestMapping("/front/user/userInfo")
public class FrontUserController {

    @Autowired
    private AuthContextHolder authContextHolder;
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "用户认证")
    @ApiImplicitParam(name = "userAuthVo", value = "用户实名认证对象", required = true)
    @PostMapping("/auth/userAuth")
    public Result<Object> userAuth(@RequestBody UserAuthVo userAuthVo, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        int rows = userInfoService.userAuth(userId, userAuthVo);
        return rows == 1 ? Result.ok() : Result.fail();
    }


    @ApiOperation(value = "获取认证信息")
    @GetMapping("/auth/getUserInfo")
    public Result<Object> getUserInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);

        UserInfo userInfo = userInfoService.getUserInfoByUserId(userId);
        return Result.ok(userInfo);
    }

}
