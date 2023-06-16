package com.atguigu.syt.order.service;

import com.atguigu.syt.model.order.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-15
 */
public interface OrderInfoService extends IService<OrderInfo> {

    Long submitOrder(Long userId, String scheduleId, Long patientId);

    OrderInfo getOrderInfoById(Long userId, Long oid);

    OrderInfo getOrderInfoByIdAndOutTradeNo(Long userId, String outTradeNo);
}
