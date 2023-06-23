
import request from '@/utils/request'

const apiName = '/admin/statics'
export default {

    //用户列表
    getCountMap(searchObj) {
        return request({
            url: `${apiName}/getCountMap`,
            method: 'post',
            data: searchObj
        })
    },
}