package com.atguigu.syt.order.controller.front;

import com.atguigu.common.service.utils.AuthContextHolder;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.order.service.WxPayService;
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
 * @Create: 2023/06/16 -11:53
 * @Version: 1.0
 */
@Api(tags = "微信支付")
@RestController
@RequestMapping("/front/order/wxpay")
public class FrontWxPayController {

    @Autowired
    private AuthContextHolder authContextHolder;
    @Autowired
    private WxPayService wxPayService;

    @ApiOperation("获取支付二维码url")
    @ApiImplicitParam(name = "outTradeNo", value = "订单号", required = true)
    @GetMapping("nativePay/{outTradeNo}")
    public Result<Object> nativePay(@PathVariable String outTradeNo,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        String codeUrl = wxPayService.createNativePay(userId, outTradeNo);

        return Result.ok(codeUrl);
    }

    @ApiOperation("查询支付状态")
    @ApiImplicitParam(name = "outTradeNo", value = "订单id", required = true)
    @GetMapping("queryPayStatus/{outTradeNo}")
    public Result<Object> queryPayStatus(@PathVariable String outTradeNo,
                                         HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        boolean flag = wxPayService.queryPayStatus(userId, outTradeNo);
        if (flag) {
            return Result.ok();
        } else {
            return Result.ok().code(250);
        }
    }

    @ApiOperation("取消预约")
    @ApiImplicitParam(name = "outTradeNo", value = "订单id", required = true)
    @GetMapping("cancelOrder/{outTradeNo}")
    public Result<Object> cancelOrder(@PathVariable String outTradeNo,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);

        wxPayService.cancelOrderByUidAndOutTradeNo(userId, outTradeNo);
        return Result.ok();

    }


}
