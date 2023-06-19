package com.atguigu.syt.doingcron.schedule;

import com.atguigu.syt.enums.MQConstant;
import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.order.client.OrderInfoFeignClient;
import com.atguigu.syt.vo.sms.SmsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/19 -20:00
 * @Version: 1.0
 */
@Component
@Slf4j
public class SmsAlertTask {
    @Autowired
    private OrderInfoFeignClient orderInfoFeignClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //希望余额挂号的前一天的下午6点发提示信息
//    @Scheduled(cron = "0 0 18 * * ?")
    //为了测试没三秒发一次
//    @Scheduled(cron = "*/10 * * * * ?")
    public void alertTask() {
        log.info("SmsAlertTask.alertTask执行完毕,结果:{}", "每天定时任务提示用户就医");
        List<OrderInfo> patientAdviceList = orderInfoFeignClient.getPatientAdviceList();
        for (OrderInfo orderInfo : patientAdviceList) {
            SmsVo smsVo = new SmsVo();
            smsVo.setPhone(orderInfo.getPatientPhone());
            smsVo.setTemplateCode("888888");
            System.out.println(orderInfo.getPatientPhone());
            rabbitTemplate.convertAndSend(MQConstant.EXCHANGE_DIRECT_SMS, MQConstant.ROUTING_SMS, smsVo);
        }
    }

}
