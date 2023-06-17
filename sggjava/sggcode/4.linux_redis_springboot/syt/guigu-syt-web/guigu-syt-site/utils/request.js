import axios from 'axios'
import { Message, MessageBox } from 'element-ui'

//引入js-cookie
import cookie from 'js-cookie'

// 创建axios实例
const service = axios.create({
    withCredentials: true,
    baseURL: process.env.BASE_API,
    timeout: 20000 // 请求超时时间
})
// http request 拦截器
service.interceptors.request.use(
    config => {
        //从cookie中取出token，并且在请求头中携带token
        if (cookie.get('token')) {
            config.headers['token'] = cookie.get('token')
        }
        return config
    },
    err => {
        return Promise.reject(err)
    })
// http response 拦截器
service.interceptors.response.use(
    response => {
        //如果响应码是214，则需要登录超时
        if (response.data.code === 214) {
            // to re-login
            MessageBox.confirm('登录超时, 请重新登录', '确认退出', {
                confirmButtonText: '重新登录',
                cancelButtonText: '回到首页',
                type: 'warning'
            }).then(() => {
                window.location.href = process.env.BASE_API + '/front/user/wx/login'
            }).catch(() => {
                window.location.href = '/'
            })
        } else if (response.data.code !== 200 && response.data.code !== 250) {
            Message({
                message: response.data.message,
                type: 'error',
                duration: 5 * 1000
            })
            return Promise.reject(response.data)
        } else {
            return response.data
        }
    },
    error => {
        return Promise.reject(error.response)
    })


export default service