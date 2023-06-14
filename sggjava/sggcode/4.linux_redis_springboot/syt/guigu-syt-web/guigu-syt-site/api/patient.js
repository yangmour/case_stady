import request from '@/utils/request'

export default {

    save(patient) {
        return request({
            url: `/front/user/patient/auth/save`,
            method: 'post',
            data: patient
        })
    },
    removeById(pid) {
        return request({
            url: `/front/user/patient/auth/remove/${pid}`,
            method: 'delete'
        })
    },
    getById(pid) {
        return request({
            url: `/front/user/patient/auth/edit/${pid}`,
            method: 'get'
        })
    },
    updateById(patient) {
        return request({
            url: `/front/user/patient/auth/update`,
            method: 'put',
            data: patient
        })
    },


    findList() {
        return request({
            url: `/front/user/patient/auth/findAll`,
            method: `get`
        })
    }
}