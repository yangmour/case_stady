import Vue from 'vue'
import App from './App.vue'
// 引入路由器
import router from './router'
// 关闭Vue生产提示
Vue.config.productionTip = false
new Vue({
  render: h => h(App), //将App组件放入容器中
  router: router //将路由挂载到Vue上下文
}).$mount('#app') //渲染页面