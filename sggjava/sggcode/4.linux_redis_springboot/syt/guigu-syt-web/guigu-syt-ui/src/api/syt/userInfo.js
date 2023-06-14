
import request from '@/utils/request'

const apiName = '/admin/user/userInfo'
export default {

    //用户列表
    getPageList(page, limit, searchObj) {
        return request({
            url: `${apiName}/page/${page}/${limit}`,
            method: 'get',
            params: searchObj
        })
    },
}