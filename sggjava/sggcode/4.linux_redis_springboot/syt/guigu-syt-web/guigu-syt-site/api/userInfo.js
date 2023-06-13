import request from '@/utils/request'

//引入js-cookie
const api = "/front/user/userInfo"

export default {

    saveUserAuth(userAuth) {
        return request({
            url: `${api}/auth/userAuth`,
            method: 'post',
            data: userAuth,
        })
    },

    getUserInfo() {
        return request({
            url: `${api}/auth/getUserInfo`,
            method: `get`,
        })
    }
}