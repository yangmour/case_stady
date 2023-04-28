//创建应用程序的路由器
import Vue from "vue"
import VueRouter from "vue-router"
//此时就可以在vue中配置路由器了
Vue.use(VueRouter)
//引入组件
import index from "../views/index"
import order from "../views/order"

//创建路由器并暴露一个路由
export default new VueRouter({
    routes:[
        {
            path: "/",
            component: index
        },
        {
            path: "/order",
            component: order
        }
    ]
})
