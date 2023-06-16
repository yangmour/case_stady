package com.atguigu.syt.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.service.utils.HttpRequestHelper;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.enums.OrderStatusEnum;
import com.atguigu.syt.hosp.client.HospitalSetFeignClient;
import com.atguigu.syt.hosp.client.ScheduleFeignClient;
import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.model.user.Patient;
import com.atguigu.syt.order.mapper.OrderInfoMapper;
import com.atguigu.syt.order.service.OrderInfoService;
import com.atguigu.syt.user.client.PatientFeignClient;
import com.atguigu.syt.vo.hosp.ScheduleOrderVo;
import com.atguigu.syt.vo.order.SignInfoVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

        //医院信息
        BeanUtils.copyProperties(scheduleInfo, orderInfo);
        orderInfo.setScheduleId(scheduleId);

        //就诊人信息
        orderInfo.setPatientId(patientId);
        orderInfo.setPatientName(patientInfo.getName());
        orderInfo.setPatientPhone(patientInfo.getPhone());
        BeanUtils.copyProperties(patientInfo, orderInfo);

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
}
