package com.atguigu.syt.order.controller.api;

import com.atguigu.common.service.utils.RequestUtils;
import com.atguigu.syt.enums.OrderStatusEnum;
import com.atguigu.syt.enums.RefundStatusEnum;
import com.atguigu.syt.order.service.OrderInfoService;
import com.atguigu.syt.order.service.RefundInfoService;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.core.notification.NotificationParser;
import com.wechat.pay.java.core.notification.RequestParam;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import com.wechat.pay.java.service.refund.model.Status;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/17 -23:20
 * @Version: 1.0
 */
@Api(tags = "微信回调接口")
@Controller
@RequestMapping("/api/order/wxpay")
public class ApiWxPayController {

    @Autowired
    private RSAAutoCertificateConfig wxConfig;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private RefundInfoService refundInfoService;

    @PostMapping("refunds/notify")
    public Map<String, Object> refundsNotify(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        //HTTP 头 Wechatpay-Signature
        //HTTP 头 Wechatpay-Nonce
        //HTTP 头 Wechatpay-Timestamp
        //HTTP 头 Wechatpay-Serial
        //HTTP 头 Wechatpay-Signature-Type

        //请求体
        String requestBody = RequestUtils.readData(httpServletRequest);

        // 构造 RequestParam
        RequestParam requestParam = new RequestParam.Builder()
                .serialNumber(httpServletRequest.getHeader("Wechatpay-Serial"))
                .nonce(httpServletRequest.getHeader("Wechatpay-Nonce"))
                .signature(httpServletRequest.getHeader("Wechatpay-Signature"))
                .timestamp(httpServletRequest.getHeader("Wechatpay-Timestamp"))
                .body(requestBody)
                .build();

        // 如果已经初始化了 RSAAutoCertificateConfig，可直接使用
        // 没有的话，则构造一个
        // 初始化 NotificationParser
        NotificationParser parser = new NotificationParser(wxConfig);

        // 以支付通知回调为例，验签、解密并转换成 Transaction
        RefundNotification refundNotification = parser.parse(requestParam, RefundNotification.class);

        HashMap<String, Object> map = new HashMap<>();

        //判断是否成功
        Status refundStatus = refundNotification.getRefundStatus();
        if (Status.SUCCESS.equals(refundStatus)) {
            //修改回退订单信息
            refundInfoService.updateRefundInfo(refundNotification, RefundStatusEnum.REFUND.getStatus());

            //修改订单状态
            orderInfoService.updateStatus(refundNotification.getOutTradeNo(), OrderStatusEnum.CANCLE_REFUND.getStatus());
            map.put("code", Status.SUCCESS);
            map.put("message", "退款成功！");
        } else { //其他情况抛异常
            httpServletResponse.setStatus(400);
            map.put("code", "xxxx");
            map.put("message", "退款失败！");
        }

        return map;
    }

}
