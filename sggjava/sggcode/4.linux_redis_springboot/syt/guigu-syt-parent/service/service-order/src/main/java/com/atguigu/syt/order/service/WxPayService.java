package com.atguigu.syt.order.service;

import com.atguigu.syt.model.order.OrderInfo;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/16 -14:00
 * @Version: 1.0
 */
public interface WxPayService {
    String createNativePay(Long userId, String outTradeNo);

    boolean queryPayStatus(Long userId, String outTradeNo);

    void refund(OrderInfo orderInfo);
}
