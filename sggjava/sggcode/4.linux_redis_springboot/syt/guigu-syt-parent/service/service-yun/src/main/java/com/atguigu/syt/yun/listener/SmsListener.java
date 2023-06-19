package com.atguigu.syt.yun.listener;

import com.atguigu.syt.enums.MQConstant;
import com.atguigu.syt.vo.sms.SmsVo;
import com.atguigu.syt.yun.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/19 -18:27
 * @Version: 1.0
 */

@Component
@Slf4j
public class SmsListener {

    @Autowired
    private SmsService smsService;

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(MQConstant.QUEUE_SMS),
                    exchange = @Exchange(MQConstant.EXCHANGE_DIRECT_SMS),
                    key = MQConstant.ROUTING_SMS
            )
    })
    public void promptMessage(SmsVo smsVo) {
        String dateTime = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println(dateTime + " -------------");
        log.info("SmsListener.promptMessage执行完毕,结果:{}", smsVo);
        // 发送短信，由于没有提示的短信模板先用这个测试
        if (StringUtils.isEmpty(smsVo.getPhone())) {
            log.info("SmsListener.promptMessage执行完毕,结果:{}", "没任务！");
            return;
        }
        smsService.sendCode(smsVo.getPhone());

    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(MQConstant.QUEUE_SMS_CANCEL),
                    exchange = @Exchange(MQConstant.EXCHANGE_DIRECT_SMS_CANCEL),
                    key = MQConstant.ROUTING_SMS_CANCEL
            )
    })
    public void cancelPromptMessage(SmsVo smsVo) {
        String dateTime = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println(dateTime + " -------------");
        log.info("SmsListener.promptMessage执行完毕,结果:{}", smsVo);
        // 发送短信，由于没有提示的短信模板先用这个测试
        smsService.sendCode(smsVo.getPhone());
    }

}
