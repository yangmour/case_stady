import request from '~/utils/request'

const departmentApi = "/front/hosp/department";

export default {
    //根据医院编号显示所有科室
    getDeptList(hoscode) {
        return request({
            url: `${departmentApi}/getDeptList/${hoscode}`,
            method: 'get'
        })
    }
}