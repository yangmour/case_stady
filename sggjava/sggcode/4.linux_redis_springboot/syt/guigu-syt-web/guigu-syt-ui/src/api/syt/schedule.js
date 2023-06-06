import request from '@/utils/request'
const apiName = '/admin/hosp/schedule'
export default {
  //查看排班
  getScheduleRule(page, limit, hoscode, depcode) {
    return request({
      url: `${apiName}/getScheduleRule/${hoscode}/${depcode}/${page}/${limit}`,
      method: 'get'
    })
  },
  //查询排班详情
getScheduleDetail(hoscode, depcode, workDate) {
  return request({
      url: `${apiName}/getScheduleDetail/${hoscode}/${depcode}/${workDate}`,
      method: 'get'
  })
}
}