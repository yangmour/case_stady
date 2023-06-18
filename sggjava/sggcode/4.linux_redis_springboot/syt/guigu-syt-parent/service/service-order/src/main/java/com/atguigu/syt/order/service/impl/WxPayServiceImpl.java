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
import com.atguigu.syt.order.service.RefundInfoService;
import com.atguigu.syt.order.service.WxPayService;
import com.atguigu.syt.vo.order.SignInfoVo;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.core.exception.HttpException;
import com.wechat.pay.java.core.exception.MalformedMessageException;
import com.wechat.pay.java.core.exception.ServiceException;
import com.wechat.pay.java.service.payments.model.Transaction;
import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.Amount;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;
import com.wechat.pay.java.service.payments.nativepay.model.QueryOrderByOutTradeNoRequest;
import com.wechat.pay.java.service.refund.RefundService;
import com.wechat.pay.java.service.refund.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    private final RSAAutoCertificateConfig rsaAutoCertificateConfig;
    private final WxPayConfig wxPayConfig;
    private final PaymentInfoService paymentInfoService;
    private final HospitalSetFeignClient hospitalSetFeignClient;
    private final RefundInfoService refundInfoService;

    @Override
    public String createNativePay(Long userId, String outTradeNo) {

        OrderInfo orderInfo = orderInfoService.getOrderInfoByIdAndOutTradeNo(userId, outTradeNo);

        // 构建service
        NativePayService service = new NativePayService.Builder().config(rsaAutoCertificateConfig).build();
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
        NativePayService service = new NativePayService.Builder().config(rsaAutoCertificateConfig).build();
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
    public void refund(OrderInfo orderInfo) {

        // 初始化服务
        RefundService service = new RefundService.Builder().config(rsaAutoCertificateConfig).build();
        // ... 调用接口
        try {
            // 退款申请
            Refund response = create(service, orderInfo);
            //判断是否申请成功
            Status statusResp = response.getStatus();
            //SUCCESS：退款成功（退款申请成功） || PROCESSING：退款处理中
            //记录支退款日志
            if (Status.SUCCESS.equals(statusResp) || Status.PROCESSING.equals(statusResp)) {
                //添加退款信息
                refundInfoService.saveRefundInfo(orderInfo, response);
                //修改订单状态
                orderInfoService.updateStatus(orderInfo.getOutTradeNo(), OrderStatusEnum.CANCLE_REFUND.getStatus());

            } else { // 失败!其他情况
                throw new GuiguException(ResultCodeEnum.FAIL.getCode(), "退款异常");
            }

        } catch (HttpException e) { // 发送HTTP请求失败
            // 调用e.getHttpRequest()获取请求打印日志或上报监控，更多方法见HttpException定义
            log.error(e.getMessage());
            throw new GuiguException(ResultCodeEnum.FAIL);
        } catch (ServiceException e) { // 服务返回状态小于200或大于等于300，例如500
            // 调用e.getResponseBody()获取返回体打印日志或上报监控，更多方法见ServiceException定义
            log.error(e.getMessage());
            throw new GuiguException(ResultCodeEnum.FAIL);
        } catch (MalformedMessageException e) { // 服务返回成功，返回体类型不合法，或者解析返回体失败
            // 调用e.getMessage()获取信息打印日志或上报监控，更多方法见MalformedMessageException定义
            log.error(e.getMessage());
            throw new GuiguException(ResultCodeEnum.FAIL);
        }
    }


    /**
     * 退款申请
     */
    public Refund create(RefundService service, OrderInfo orderInfo) {
        CreateRequest request = new CreateRequest();
        // 调用request.setXxx(val)设置所需参数，具体参数可见Request定义
        request.setOutTradeNo(orderInfo.getOutTradeNo());
        request.setOutRefundNo("TK_" + orderInfo.getOutTradeNo());

        AmountReq amountReq = new AmountReq();
        amountReq.setRefund(orderInfo.getAmount().multiply(new BigDecimal("0.01")).longValue());
        amountReq.setTotal(orderInfo.getAmount().multiply(new BigDecimal("0.01")).longValue());
        amountReq.setCurrency("CNY");
        request.setAmount(amountReq);
        //微信支付申请退款回调地址
        request.setNotifyUrl(wxPayConfig.getNotifyRefundUrl());

        // 调用接口
        return service.create(request);
    }

    /**
     * 查询单笔退款（通过商户退款单号）
     */
    public static Refund queryByOutRefundNo(RefundService service) {

        QueryByOutRefundNoRequest request = new QueryByOutRefundNoRequest();
        // 调用request.setXxx(val)设置所需参数，具体参数可见Request定义
        // 调用接口
        return service.queryByOutRefundNo(request);
    }


}
