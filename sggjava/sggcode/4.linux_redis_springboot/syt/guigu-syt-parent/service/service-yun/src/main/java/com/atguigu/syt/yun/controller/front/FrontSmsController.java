package com.atguigu.syt.yun.controller.front;

import com.atguigu.common.service.utils.AuthContextHolder;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.yun.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/18 -15:26
 * @Version: 1.0
 */
@Api(tags = "短信接口")
@RestController
@RequestMapping("/front/yun/sms")
public class FrontSmsController {

    @Autowired
    private AuthContextHolder authContextHolder;

    @Autowired
    private SmsService smsService;


    @ApiOperation("发送短信")
    @ApiImplicitParam(name = "phone", value = "手机号")
    @GetMapping("send/{phone}")
    public Result<Object> send(@PathVariable String phone, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        boolean flag = smsService.sendCode(phone);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
