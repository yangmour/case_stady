package com.atguigu.syt.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.service.utils.HttpRequestHelper;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.enums.MQConstant;
import com.atguigu.syt.enums.OrderStatusEnum;
import com.atguigu.syt.hosp.client.HospitalSetFeignClient;
import com.atguigu.syt.hosp.client.ScheduleFeignClient;
import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.model.user.Patient;
import com.atguigu.syt.order.mapper.OrderInfoMapper;
import com.atguigu.syt.order.service.OrderInfoService;
import com.atguigu.syt.order.service.WxPayService;
import com.atguigu.syt.user.client.PatientFeignClient;
import com.atguigu.syt.vo.hosp.ScheduleOrderVo;
import com.atguigu.syt.vo.order.OrderMqVo;
import com.atguigu.syt.vo.order.SignInfoVo;
import com.atguigu.syt.vo.sms.SmsVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author xiwen
 * @since 2023-06-15
 */
@Service
@Slf4j
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {


    @Autowired
    private PatientFeignClient patientFeignClient;

    @Autowired
    private ScheduleFeignClient scheduleFeignClient;

    @Autowired
    private HospitalSetFeignClient hospitalSetFeignClient;

    @Autowired
    private WxPayService wxPayService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Long submitOrder(Long userId, String scheduleId, Long patientId) {

        //获取就诊人信息
        Patient patientInfo = patientFeignClient.getPatientInfo(patientId);
        if (patientInfo == null) {
            throw new GuiguException(ResultCodeEnum.PARAM_ERROR);
        }
        //获取排班信息
        ScheduleOrderVo scheduleInfo = scheduleFeignClient.getScheduleInfo(scheduleId);
        if (scheduleInfo == null) {
            throw new GuiguException(ResultCodeEnum.PARAM_ERROR);
        }


        //基本信息
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderStatus(OrderStatusEnum.UNPAID.getStatus());
        String outTradeNo = UUID.randomUUID().toString().replaceAll("-", "");
        orderInfo.setOutTradeNo(outTradeNo);
        orderInfo.setUserId(userId);

        //医院信息
        BeanUtils.copyProperties(scheduleInfo, orderInfo);
        orderInfo.setScheduleId(scheduleId);

        //就诊人信息
        orderInfo.setPatientId(patientId);
        orderInfo.setPatientName(patientInfo.getName());
        orderInfo.setPatientPhone(patientInfo.getPhone());

        //给第三方医院发送请求
        SignInfoVo signInfoVo = hospitalSetFeignClient.getSignInfoVo(scheduleInfo.getHoscode());
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hoscode", orderInfo.getHoscode());
        paramMap.put("depcode", orderInfo.getDepcode());
        paramMap.put("hosScheduleId", orderInfo.getHosScheduleId());
        paramMap.put("reserveDate", orderInfo.getReserveDate());
        paramMap.put("reserveTime", orderInfo.getReserveTime());
        paramMap.put("amount", orderInfo.getAmount());
        paramMap.put("name", orderInfo.getPatientName());
        paramMap.put("certificatesType", patientInfo.getCertificatesType());
        paramMap.put("certificatesNo", patientInfo.getCertificatesNo());
        paramMap.put("birthdate", patientInfo.getBirthdate());
        paramMap.put("phone", patientInfo.getPhone());
        paramMap.put("provinceCode", patientInfo.getProvinceCode());
        paramMap.put("cityCode", patientInfo.getCityCode());
        paramMap.put("districtCode", patientInfo.getDistrictCode());
        paramMap.put("address", patientInfo.getAddress());
        paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
        paramMap.put("sign", HttpRequestHelper.getSign(paramMap, signInfoVo.getSignKey()));
        JSONObject jsonObject = HttpRequestHelper.sendRequest(paramMap, signInfoVo.getApiUrl() + "/order/submitOrder");
        if (jsonObject.getInteger("code") != 200) {
            log.error("预约失败，"
                    + "code：" + jsonObject.getInteger("code")
                    + "，message：" + jsonObject.getString("message")
            );
            throw new GuiguException(ResultCodeEnum.FAIL.getCode(), jsonObject.getString("message"));
        }
        //第三次医院信息封装
        JSONObject data = jsonObject.getJSONObject("data");
        String hosOrderId = data.getString("hosOrderId");
        Integer number = data.getInteger("number");
        String fetchTime = data.getString("fetchTime");
        String fetchAddress = data.getString("fetchAddress");
        orderInfo.setHosOrderId(hosOrderId);
        orderInfo.setNumber(number);
        orderInfo.setFetchTime(fetchTime);
        orderInfo.setFetchAddress(fetchAddress);
        //插入订单数据
        baseMapper.insert(orderInfo);

        //使用这两个数据更新平台端的最新的排班数量
        Integer reservedNumber = data.getInteger("reservedNumber");
        Integer availableNumber = data.getInteger("availableNumber");

        //预约数不足
        if (scheduleInfo.getAvailableNumber() <= 0) {
            throw new GuiguException(ResultCodeEnum.NUMBER_NO);
        }

        //通知修改库存等
        OrderMqVo orderMqVo = new OrderMqVo();
        orderMqVo.setScheduleId(scheduleId);
        orderMqVo.setReservedNumber(reservedNumber);
        orderMqVo.setAvailableNumber(availableNumber);
        rabbitTemplate.convertSendAndReceive(MQConstant.EXCHANGE_DIRECT_ORDER, MQConstant.ROUTING_ORDER, orderMqVo);

        //发送提示短信
        SmsVo smsVo = new SmsVo();
        smsVo.setPhone(orderInfo.getPatientPhone());
        smsVo.setTemplateCode("xxxxxxxx");

        Map<String, Object> paramsSms = new HashMap<String, Object>() {{
            put("hosname", orderInfo.getHosname());
            put("hosdepname", orderInfo.getDepname());
            put("date", new DateTime(orderInfo.getReserveDate()).toString("yyyy-MM-dd"));
            put("name", orderInfo.getPatientName());
        }};
        smsVo.setParam(paramsSms);
        rabbitTemplate.convertSendAndReceive(MQConstant.EXCHANGE_DIRECT_SMS, MQConstant.ROUTING_SMS, smsVo);

        return orderInfo.getId();
    }

    @Override
    public OrderInfo getOrderInfoById(Long userId, Long oid) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderInfo::getUserId, userId);
        queryWrapper.eq(OrderInfo::getId, oid);

        OrderInfo orderInfo = baseMapper.selectOne(queryWrapper);
        orderInfo.getParam().put("orderStatusString", OrderStatusEnum.getStatusNameByStatus(orderInfo.getOrderStatus()));
        log.info("OrderInfoServiceImpl.getOrderInfoById执行完毕,结果:{}", orderInfo);
        return orderInfo;
    }

    @Override
    public OrderInfo getOrderInfoByIdAndOutTradeNo(Long userId, String outTradeNo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderInfo::getUserId, userId);
        queryWrapper.eq(OrderInfo::getOutTradeNo, outTradeNo);

        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public void updateStatus(String outTradeNo, Integer status) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderInfo::getOutTradeNo, outTradeNo);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderStatus(status);
        baseMapper.update(orderInfo, queryWrapper);
    }

    @Override
    public void cancelOrderByUidAndOutTradeNo(Long userId, String outTradeNo) {
        OrderInfo orderInfo = getOrderInfoByIdAndOutTradeNo(userId, outTradeNo);


        SignInfoVo signInfoVo = hospitalSetFeignClient.getSignInfoVo(orderInfo.getHoscode());
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("hoscode", orderInfo.getHoscode());
        paramMap.put("hosOrderId", orderInfo.getHosOrderId());
        paramMap.put("hosScheduleId", orderInfo.getHosScheduleId());
        paramMap.put("timestamp", HttpRequestHelper.getTimestamp());
        paramMap.put("sign", HttpRequestHelper.getSign(paramMap, signInfoVo.getSignKey()));
        JSONObject jsonObject = HttpRequestHelper.sendRequest(paramMap, signInfoVo.getApiUrl() + "/order/updateCancelStatus");

        //检查第三方医院是否能用
        if (jsonObject == null || 200 != jsonObject.getInteger("code")) {
            log.info("WxPayServiceImpl.cancelOrderByUidAndOutTradeNo执行完毕,结果:code {},msg {}", jsonObject.get("code"), jsonObject.get("message"));
            throw new GuiguException(ResultCodeEnum.CANCEL_ORDER_NO);
        }
        //已支付状态
        if (orderInfo.getOrderStatus().intValue() == OrderStatusEnum.PAID.getStatus()) {
            DateTime quitTime = new DateTime(orderInfo.getQuitTime());
//            如果以及过了退号时间就不能取消
            if (quitTime.isBeforeNow()) {
                throw new GuiguException(ResultCodeEnum.CANCEL_ORDER_NO);
            }
            //可以取消预约
            log.info("WxPayServiceImpl.cancelOrderByUidAndOutTradeNo执行完毕,结果:{}", "已支付的退款申请!");
            wxPayService.refund(orderInfo);

            //修改状态
            updateStatus(outTradeNo, OrderStatusEnum.CANCLE_UNREFUND.getStatus());
        } else {//未支付状态
            updateStatus(outTradeNo, OrderStatusEnum.CANCLE.getStatus());
        }

        //修改数量
        OrderMqVo orderMqVo = new OrderMqVo();
        orderMqVo.setScheduleId(orderInfo.getScheduleId());

        JSONObject data = jsonObject.getJSONObject("data");
        Integer reservedNumber = data.getInteger("reservedNumber");
        Integer availableNumber = data.getInteger("availableNumber");

        orderMqVo.setReservedNumber(reservedNumber);
        orderMqVo.setAvailableNumber(availableNumber);
        rabbitTemplate.convertAndSend(MQConstant.EXCHANGE_DIRECT_ORDER, MQConstant.ROUTING_ORDER, orderMqVo);
        //发送取消订单信息
        SmsVo smsVo = new SmsVo();
        smsVo.setPhone(orderInfo.getPatientPhone());
        smsVo.setTemplateCode("xxxxxx");
        rabbitTemplate.convertAndSend(MQConstant.EXCHANGE_DIRECT_SMS_CANCEL, MQConstant.ROUTING_SMS_CANCEL, smsVo);

    }

    @Override
    public List<OrderInfo> getPatientAdviceList() {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();
        String dateTime = new DateTime().plusDays(1).toString("yyyy-MM-dd");
        queryWrapper.eq(OrderInfo::getReserveDate, dateTime);
        queryWrapper.notIn(OrderInfo::getOrderStatus,
                OrderStatusEnum.CANCLE.getStatus(),
                OrderStatusEnum.CANCLE_UNREFUND.getStatus(),
                OrderStatusEnum.CANCLE_REFUND.getStatus());

        return baseMapper.selectList(queryWrapper);

    }
}
