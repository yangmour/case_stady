package com.atguigu.syt.order.client.callback;

import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.order.client.OrderInfoFeignClient;
import com.atguigu.syt.vo.statistics.OrderCountQueryVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/19 -20:24
 * @Version: 1.0
 */
@Component
public class OrderInfoFeignClientCallback  implements OrderInfoFeignClient {
    @Override
    public List<OrderInfo> getPatientAdviceList() {
        return null;
    }

    @Override
    public Map<String, Object> getOrderStatistic(OrderCountQueryVo orderCountQueryVo) {
        return null;
    }
}
