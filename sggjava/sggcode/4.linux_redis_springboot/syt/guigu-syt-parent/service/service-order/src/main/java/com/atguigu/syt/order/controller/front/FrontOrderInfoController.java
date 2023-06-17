package com.atguigu.syt.order.controller.front;

import com.atguigu.common.service.utils.AuthContextHolder;
import com.atguigu.common.util.result.Result;
import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.order.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @Create: 2023/06/15 -21:19
 * @Version: 1.0
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("/front/order/orderInfo")
public class FrontOrderInfoController {

    @Autowired
    private AuthContextHolder authContextHolder;

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation("创建订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "scheduleId", value = "排班id", required = true),
            @ApiImplicitParam(name = "patientId", value = "就诊人id", required = true)})
    @GetMapping("submitOrder/{scheduleId}/{patientId}")
    public Result<Object> submitOrder(@PathVariable String scheduleId, @PathVariable Long patientId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        Long orderId = orderInfoService.submitOrder(userId, scheduleId, patientId);
        return Result.ok(orderId);
    }

    @ApiOperation("查询订单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oid", value = "订单id", required = true),
    })
    @GetMapping("getOrderInfo/{oid}")
    public Result<Object> getOrderInfo(@PathVariable Long oid, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);
        OrderInfo orderInfo = orderInfoService.getOrderInfoById(userId, oid);
        return Result.ok(orderInfo);
    }

    @ApiOperation("取消预约")
    @ApiImplicitParam(name = "outTradeNo", value = "订单id", required = true)
    @GetMapping("cancelOrder/{outTradeNo}")
    public Result<Object> cancelOrder(@PathVariable String outTradeNo,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) {
        Long userId = authContextHolder.checkAuth(httpServletRequest, httpServletResponse);

        orderInfoService.cancelOrderByUidAndOutTradeNo(userId, outTradeNo);
        return Result.ok();

    }

}
