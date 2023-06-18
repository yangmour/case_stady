package com.atguigu.syt.order.service;

import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.model.order.RefundInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.pay.java.service.refund.model.Refund;
import com.wechat.pay.java.service.refund.model.RefundNotification;

/**
 * <p>
 * 退款信息表 服务类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-15
 */
public interface RefundInfoService extends IService<RefundInfo> {

    void saveRefundInfo(OrderInfo orderInfo, Refund response);

    void updateRefundInfo(RefundNotification refundNotification, Integer status);
}
