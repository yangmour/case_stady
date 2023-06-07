import axios from 'axios'
import { Message, MessageBox } from 'element-ui'
// 创建axios实例
const service = axios.create({
    baseURL: process.env.BASE_API,
    timeout: 20000 // 请求超时时间
})
// http request 拦截器
service.interceptors.request.use(
    config => {
        return config
    },
    err => {
        return Promise.reject(err)
    })
// http response 拦截器
service.interceptors.response.use(
    response => {
        if (response.data.code !== 200) {
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