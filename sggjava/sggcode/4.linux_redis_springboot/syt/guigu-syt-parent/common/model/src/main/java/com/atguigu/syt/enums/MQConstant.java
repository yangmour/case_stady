package com.atguigu.syt.enums;

public class MQConstant {

    /**
     * 预约/取消订单
     */
    public static final String EXCHANGE_DIRECT_ORDER = "exchange.direct.order";
    public static final String ROUTING_ORDER = "routing.order";
    public static final String QUEUE_ORDER = "queue.order";

    /**
     * 短信
     */
    public static final String EXCHANGE_DIRECT_SMS = "exchange.direct.sms";
    public static final String ROUTING_SMS = "routing.sms";
    public static final String QUEUE_SMS = "queue.sms";

    public static final String EXCHANGE_DIRECT_SMS_CANCEL = "exchange.direct.sms.cancel";
    public static final String ROUTING_SMS_CANCEL = "routing.sms.cancel";
    public static final String QUEUE_SMS_CANCEL = "queue.sms.cancel";
}