import request from '~/utils/request'

const hospitalApi = "/front/hosp/hospital";

export default {
    hospList(searchObj) {
        return request({
            url: `${hospitalApi}/getHospitalList`,
            method: 'get',
            params: searchObj
        })
    },
    //根据医院编号显示医院详情
    show(hoscode) {
        return request({
            url: `${hospitalApi}/show/${hoscode}`,
            method: 'get'
        })
    },
    
}