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
}