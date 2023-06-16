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
}