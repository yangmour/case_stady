import request from '@/utils/request'
export default {
  //生成订单
  submitOrder(scheduleId, patientId) {
    return request({
      url: `/front/order/orderInfo/submitOrder/${scheduleId}/${patientId}`,
      method: 'get'
    })
  },
  //订单详情
  getOrder(orderId) {
    return request({
      url: `/front/order/orderInfo/getOrderInfo/${orderId}`,
      method: `get`
    })
  },
  //取消预约
  cancelOrder(outTradeNo) {
    return request({
      url: `/front/order/orderInfo/cancelOrder/${outTradeNo}`,
      method: 'get'
    })
  },
  //获取订单列表
  getList() {
    return request({
      url: `/front/order/orderInfo/getOrderList`,
      method: 'get'
    })
  },

}