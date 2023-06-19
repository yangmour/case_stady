package com.atguigu.syt.hosp.listener;

import com.atguigu.syt.enums.MQConstant;
import com.atguigu.syt.hosp.service.ScheduleService;
import com.atguigu.syt.vo.order.OrderMqVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/19 -15:19
 * @Version: 1.0
 */
@Component
@Slf4j
public class OrderListener {

    @Autowired
    private ScheduleService scheduleService;

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(MQConstant.QUEUE_ORDER),
                    exchange = @Exchange(MQConstant.EXCHANGE_DIRECT_ORDER),
                    key = MQConstant.ROUTING_ORDER
            )
    })
    public void orderConsumer(OrderMqVo orderMqVo) {
        log.info("OrderListener.orderConsumer执行完毕,结果:{}", orderMqVo);
        scheduleService.updateOrderInfo(orderMqVo);
    }
}
