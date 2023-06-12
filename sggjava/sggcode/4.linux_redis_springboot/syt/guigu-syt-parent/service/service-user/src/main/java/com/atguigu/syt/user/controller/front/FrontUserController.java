package com.atguigu.syt.user.controller.front;

import com.atguigu.common.service.utils.AuthContextHolder;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.user.service.UserInfoService;
import com.atguigu.syt.vo.user.UserAuthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    public Result<Object> userAuth(UserAuthVo userAuthVo, HttpServletRequest httpServletRequest) {
        Long userId = authContextHolder.checkAuth(httpServletRequest);
        int rows = userInfoService.userAuth(userId, userAuthVo);
        return rows == 1 ? Result.ok() : Result.fail();
    }

}
