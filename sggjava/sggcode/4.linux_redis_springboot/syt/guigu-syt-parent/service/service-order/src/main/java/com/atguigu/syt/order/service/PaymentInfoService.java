package com.atguigu.syt.order.service;

import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.model.order.PaymentInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.pay.java.service.payments.model.Transaction;

/**
 * <p>
 * 支付信息表 服务类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-15
 */
public interface PaymentInfoService extends IService<PaymentInfo> {

    void savePaymentInfo(OrderInfo orderInfo, Transaction result);
}
