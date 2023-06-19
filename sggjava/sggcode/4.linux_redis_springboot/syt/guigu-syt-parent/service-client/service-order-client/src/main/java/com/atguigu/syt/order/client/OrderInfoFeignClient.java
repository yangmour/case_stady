package com.atguigu.syt.order.client;

import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.order.client.callback.OrderInfoFeignClientCallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/19 -20:22
 * @Version: 1.0
 */
@FeignClient(value = "service-order", fallback = OrderInfoFeignClientCallback.class, path = "/inner/order/orderInfo")
public interface OrderInfoFeignClient {


    @GetMapping("getPatientAdviceList")
    List<OrderInfo> getPatientAdviceList();
}
