package com.atguigu.syt.order.service.impl;

import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.order.config.WxPayConfig;
import com.atguigu.syt.order.service.OrderInfoService;
import com.atguigu.syt.order.service.WxPayService;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.Amount;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/16 -14:00
 * @Version: 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class WxPayServiceImpl implements WxPayService {

    private final OrderInfoService orderInfoService;
    private final Config wxConfig;
    private final WxPayConfig wxPayConfig;

    @Override
    public String createNativePay(Long userId, String outTradeNo) {

        OrderInfo orderInfo = orderInfoService.getOrderInfoByIdAndOutTradeNo(userId, outTradeNo);

        // 构建service
        NativePayService service = new NativePayService.Builder().config(wxConfig).build();
        // request.setXxx(val)设置所需参数，具体参数可见Request定义
        PrepayRequest request = new PrepayRequest();
        Amount amount = new Amount();
        amount.setTotal(1);
        request.setAmount(amount);
        request.setAppid(wxPayConfig.getAppid());
        request.setMchid(wxPayConfig.getMchId());
        request.setDescription("挂号费");
        request.setNotifyUrl(wxPayConfig.getNotifyUrl());
        request.setOutTradeNo(orderInfo.getOutTradeNo());
        // 调用下单方法，得到应答
        PrepayResponse response = service.prepay(request);
        // 使用微信扫描 code_url 对应的二维码，即可体验Native支付
        log.info("WxPayServiceImpl.createNativePay执行完毕,结果:{}", response.getCodeUrl());

        return response.getCodeUrl();
    }
}
