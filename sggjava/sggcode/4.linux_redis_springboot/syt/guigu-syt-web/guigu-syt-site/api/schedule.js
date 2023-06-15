import request from '@/utils/request'

//引入js-cookie
const api = "/front/hosp/schedule"

export default {

    //获取可预约排班日期列表
    getBookingScheduleRule(pageNum, pageSize, hoscode, depcode) {
        return request({
            url: `${api}/getBookingScheduleRule/${pageNum}/${pageSize}/${hoscode}/${depcode}`,
            method: 'get'
        })
    },
    //获取可预约排班日期列表
    findScheduleList(pageNum, pageSize, workDate) {
        return request({
            url: `${api}/getScheduleList/${pageNum}/${pageSize}/${workDate}`,
            method: 'get'
        })
    },
    getScheduleDetail(scheduleId) {
        return request({
            url: `${api}/getScheduleDetail/${scheduleId}`,
            method: 'get'
        })
    }
}