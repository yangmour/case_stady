package com.atguigu.syt.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.common.service.exception.GuiguException;
import com.atguigu.common.service.utils.HttpRequestHelper;
import com.atguigu.common.util.result.ResultCodeEnum;
import com.atguigu.syt.enums.OrderStatusEnum;
import com.atguigu.syt.hosp.client.HospitalSetFeignClient;
import com.atguigu.syt.model.order.OrderInfo;
import com.atguigu.syt.order.config.WxPayConfig;
import com.atguigu.syt.order.service.OrderInfoService;
import com.atguigu.syt.order.service.PaymentInfoService;
import com.atguigu.syt.order.service.WxPayService;
import com.atguigu.syt.vo.order.SignInfoVo;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.exception.ServiceException;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.Amount;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;
import com.wechat.pay.java.service.payments.nativepay.model.QueryOrderByOutTradeNoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/06/16 -14:00
 * @Version: 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class WxPayServiceImpl implements WxPayService {

    private final OrderInfoService orderInfoService;
    private final Config wxConfig;
    private final WxPayConfig wxPayConfig;
    private final PaymentInfoService paymentInfoService;
    private final HospitalSetFeignClient hospitalSetFeignClient;

    @Override
    public String createNativePay(Long userId, String outTradeNo) {

        OrderInfo orderInfo = orderInfoService.getOrderInfoByIdAndOutTradeNo(userId, outTradeNo);

        // 构建service
        NativePayService service = new NativePayService.Builder().config(wxConfig).build();
        // request.setXxx(val)设置所需参数，具体参数可见Request定义
        PrepayRequest request = new PrepayRequest();
        Amount amount = new Amount();
        amount.setTotal(1);
        request.setAmount(amount);
        request.setAppid(wxPayConfig.getAppid());
        request.setMchid(wxPayConfig.getMchId());
        request.setDescription("挂号费");
        request.setNotifyUrl(wxPayConfig.getNotifyUrl());
        request.setOutTradeNo(orderInfo.getOutTradeNo());
        // 调用下单方法，得到应答
        PrepayResponse response = service.prepay(request);
        // 使用微信扫描 code_url 对应的二维码，即可体验Native支付
        log.info("WxPayServiceImpl.createNativePay执行完毕,结果:{}", response.getCodeUrl());

        return response.getCodeUrl();
    }

    @Override
    @Transactional
    public boolean queryPayStatus(Long userId, String outTradeNo) {

        //根据userId和订单编号查询订单信息
        OrderInfo orderInfo = orderInfoService.getOrderInfoByIdAndOutTradeNo(userId, outTradeNo);
        //没查出来就抛异常
        if (orderInfo == null) {
            throw new GuiguException(ResultCodeEnum.PARAM_ERROR);
        }

        //处理支付成功后重复查单
        //保证接口调用的幂等性：无论接口被调用多少次，产生的结果是一致的
        if (orderInfo.getOrderStatus().intValue() != OrderStatusEnum.UNPAID.getStatus()) {
            return true;//支付成功、关单、。。。
        }

        //支付成功
        //1.远程调用微信支付接口查询支付状态
        QueryOrderByOutTradeNoRequest queryRequest = new QueryOrderByOutTradeNoRequest();
        queryRequest.setMchid(wxPayConfig.getMchId());
        queryRequest.setOutTradeNo(orderInfo.getOutTradeNo());


        // 构建service
        NativePayService service = new NativePayService.Builder().config(wxConfig).build();
        try {
            Transaction result = service.queryOrderByOutTradeNo(queryRequest);
            log.info("WxPayServiceImpl.queryPayStatus执行完毕,结果:{}", result.getTradeState());

            //支付失败就返回false或者抛异常
            if (Transaction.TradeStateEnum.SUCCESS.equals(result.getTradeState())) {

                //2.修改订单状态
                orderInfoService.updateStatus(orderInfo.getOutTradeNo(), OrderStatusEnum.PAID.getStatus());
                //3.添加支付信息
                paymentInfoService.savePaymentInfo(orderInfo, result);
                //4.通知第三方医院修改订单状态
                SignInfoVo signInfoVo = hospitalSetFeignClient.getSignInfoVo(orderInfo.getHoscode());
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("hoscode", orderInfo.getHoscode());
                paramMap.put("hosOrderId", orderInfo.getHosOrderId());
                paramMap.put("hosScheduleId", orderInfo.getHosScheduleId());
                paramMap.put("timestamp", HttpRequestHelper.getTimestamp());

                paramMap.put("sign", HttpRequestHelper.getSign(paramMap, signInfoVo.getSignKey()));
                JSONObject jsonObject = HttpRequestHelper.sendRequest(paramMap, signInfoVo.getApiUrl() + "/order/updatePayStatus");

                if (jsonObject == null || 200 != jsonObject.getInteger("code")) {
                    log.info("WxPayServiceImpl.queryPayStatus执行完毕,结果: code {},msg {}", jsonObject.get("code"), jsonObject.getString("message"));
                    throw new GuiguException(ResultCodeEnum.FAIL.getCode(), jsonObject.getString("message"));
                }
                return true;
            }

            return false;


        } catch (ServiceException e) {
            // API返回失败, 例如ORDER_NOT_EXISTS
            log.info("WxPayServiceImpl.queryPayStatus执行完毕,结果: code={}, message={}", e.getErrorCode(), e.getErrorMessage());
            log.info("WxPayServiceImpl.queryPayStatus执行完毕,结果: reponse body={}", e.getResponseBody());
            throw new GuiguException(ResultCodeEnum.FAIL);
        } catch (Exception e) {
            log.info("WxPayServiceImpl.queryPayStatus执行完毕,结果:{}", e.getMessage());
            throw new GuiguException(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public void cancelOrderByUidAndOutTradeNo(Long userId, String outTradeNo) {
        OrderInfo orderInfo = orderInfoService.getOrderInfoByIdAndOutTradeNo(userId, outTradeNo);


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
            //todo：申请退款

            //修改状态
            orderInfoService.updateStatus(outTradeNo, OrderStatusEnum.CANCLE_UNREFUND.getStatus());
        } else {//未支付状态
            orderInfoService.updateStatus(outTradeNo, OrderStatusEnum.CANCLE.getStatus());
        }


    }
}
