package com.atguigu.syt.order.service.impl;

import com.atguigu.syt.enums.PaymentTypeEnum;
import com.atguigu.syt.enums.RefundStatusEnum;
import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.model.order.RefundInfo;
import com.atguigu.syt.order.mapper.RefundInfoMapper;
import com.atguigu.syt.order.service.RefundInfoService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.pay.java.service.refund.model.Refund;
import com.wechat.pay.java.service.refund.model.RefundNotification;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 退款信息表 服务实现类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-15
 */
@Service
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfo> implements RefundInfoService {

    @Override
    public void saveRefundInfo(OrderInfo orderInfo, Refund response) {
        RefundInfo refundInfo = new RefundInfo();
        refundInfo.setOutTradeNo(orderInfo.getOutTradeNo());
        refundInfo.setOrderId(orderInfo.getId());
        refundInfo.setPaymentType(PaymentTypeEnum.WEIXIN.getStatus());

        refundInfo.setTradeNo(response.getTransactionId());
        refundInfo.setTotalAmount(orderInfo.getAmount());
        refundInfo.setSubject("挂号退款信息");
        refundInfo.setRefundStatus(RefundStatusEnum.UNREFUND.getStatus());

        baseMapper.insert(refundInfo);

    }

    @Override
    public void updateRefundInfo(RefundNotification refundNotification, Integer status) {

        LambdaUpdateWrapper<RefundInfo> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(RefundInfo::getOutTradeNo, refundNotification.getOutTradeNo());
        RefundInfo refundInfo = new RefundInfo();
        refundInfo.setOutTradeNo(refundNotification.getOutTradeNo());
        refundInfo.setRefundStatus(status);
        refundInfo.setCallbackTime(new Date());
        refundInfo.setCallbackContent(refundNotification.toString());
        refundInfo.setRefundStatus(status);
        baseMapper.update(refundInfo, queryWrapper);

    }
}
