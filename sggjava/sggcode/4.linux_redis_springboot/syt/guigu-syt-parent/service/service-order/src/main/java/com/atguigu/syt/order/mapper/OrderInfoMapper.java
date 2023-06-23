package com.atguigu.syt.order.mapper;

import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.vo.statistics.OrderCountQueryVo;
import com.atguigu.syt.vo.statistics.OrderCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author xiwen
 * @since 2023-06-15
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    List<OrderCountVo> getOrderStatisticList(OrderCountQueryVo orderCountQueryVo);
}
