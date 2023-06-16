package com.atguigu.syt.order.controller.front;

import com.atguigu.common.service.utils.AuthContextHolder;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.order.service.WxPayService;
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
 * @Create: 2023/06/16 -11:53
 * @Version: 1.0
 */
@RestController
@RequestMapping("/front/order/wxpay")
public class FrontWxPayController {

    @Autowired
    private AuthContextHolder authContextHolder;
    @Autowired
    private WxPayService wxPayService;

    @GetMapping("nativePay/{outTradeNo}")
    public Result<Object> nativePay(@PathVariable String outTradeNo,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        String codeUrl = wxPayService.createNativePay(userId, outTradeNo);

        return Result.ok(codeUrl);
    }

}
