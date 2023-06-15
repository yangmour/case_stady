import request from '@/utils/request'
export default {
  //生成订单
  submitOrder(scheduleId, patientId) {
    return request({
      url: `/front/order/orderInfo/submitOrder/${scheduleId}/${patientId}`,
      method: 'get'
    })
  }
}