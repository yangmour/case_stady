package com.atguigu.syt.order.service.impl;

import com.atguigu.syt.enums.PaymentStatusEnum;
import com.atguigu.syt.enums.PaymentTypeEnum;
import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.model.order.PaymentInfo;
import com.atguigu.syt.order.mapper.PaymentInfoMapper;
import com.atguigu.syt.order.service.PaymentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.pay.java.service.payments.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 支付信息表 服务实现类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-15
 */
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {

    @Override
    public void savePaymentInfo(OrderInfo orderInfo, Transaction result) {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setOutTradeNo(orderInfo.getOutTradeNo());
        paymentInfo.setOrderId(orderInfo.getId());
        paymentInfo.setPaymentType(PaymentTypeEnum.WEIXIN.getStatus());
        paymentInfo.setTradeNo(result.getTransactionId());
        paymentInfo.setTotalAmount(orderInfo.getAmount());
        paymentInfo.setSubject("挂号费用");
        paymentInfo.setPaymentStatus(PaymentStatusEnum.PAID.getStatus());
        paymentInfo.setCallbackTime(new Date());
        paymentInfo.setCallbackContent(result.toString());
        baseMapper.insert(paymentInfo);
    }
}
