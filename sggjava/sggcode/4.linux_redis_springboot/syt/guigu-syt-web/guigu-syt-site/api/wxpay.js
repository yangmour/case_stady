import request from '~/utils/request'
export default {
  //获取支付二维码url
  nativePay(outTradeNo) {
    return request({
      url: `/front/order/wxpay/nativePay/${outTradeNo}`,
      method: 'get'
    })
  },//查询订单
  queryPayStatus(outTradeNo) {
    return request({
      url: `/front/order/wxpay/queryPayStatus/${outTradeNo}`,
      method: 'get'
    })
  },
}