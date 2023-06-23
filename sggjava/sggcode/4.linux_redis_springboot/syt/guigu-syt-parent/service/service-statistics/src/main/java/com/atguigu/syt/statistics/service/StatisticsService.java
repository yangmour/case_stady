package com.atguigu.syt.statistics.service;

import com.atguigu.syt.vo.statistics.OrderCountQueryVo;

import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/23 -11:33
 * @Version: 1.0
 */
public interface StatisticsService {
    Map<String, Object> getCountMap(OrderCountQueryVo orderCountQueryVo);
}
