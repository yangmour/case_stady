package com.atguigu.syt.statistics.service.impl;

import com.atguigu.syt.order.client.OrderInfoFeignClient;
import com.atguigu.syt.statistics.service.StatisticsService;
import com.atguigu.syt.vo.statistics.OrderCountQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/23 -11:36
 * @Version: 1.0
 */
@Service
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private OrderInfoFeignClient orderInfoFeignClient;

    @Override
    public Map<String, Object> getCountMap(OrderCountQueryVo orderCountQueryVo) {
        Map<String, Object> map = orderInfoFeignClient.getOrderStatistic(orderCountQueryVo);
        log.info("StatisticsServiceImpl.getCountMap执行完毕,结果:{}", map);
        return map;
    }
}
