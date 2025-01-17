package com.atguigu.syt.order.controller.inner;

import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.order.service.OrderInfoService;
import com.atguigu.syt.vo.statistics.OrderCountQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/19 -20:09
 * @Version: 1.0
 */
@RestController
@RequestMapping("/inner/order/orderInfo")
public class InnerOrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("getPatientAdviceList")
    public List<OrderInfo> getPatientAdviceList() {
        return orderInfoService.getPatientAdviceList();
    }

    @PostMapping("getOrderStatistic")
    public Map<String, Object> getOrderStatistic(@RequestBody OrderCountQueryVo orderCountQueryVo) {
        return orderInfoService.getOrderStatisticMap(orderCountQueryVo);

    }

    @GetMapping("a")
    public String a() {
        System.out.println("aaa");
        return "orderInfoService.getPatientAdviceList();";
    }

}
