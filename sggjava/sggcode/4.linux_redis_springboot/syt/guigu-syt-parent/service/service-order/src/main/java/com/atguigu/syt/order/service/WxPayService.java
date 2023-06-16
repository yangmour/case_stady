package com.atguigu.syt.order.service;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/16 -14:00
 * @Version: 1.0
 */
public interface WxPayService {
    String createNativePay(Long userId, String outTradeNo);
}
