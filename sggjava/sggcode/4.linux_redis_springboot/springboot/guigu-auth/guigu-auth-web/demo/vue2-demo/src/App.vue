<!--定义页面结构-->
<template>
  <!-- template下必须且只能有一个节点 -->
  <div>
    <h1>{{ title }}</h1>
    <!-- 显示子组件 -->
    <HelloWorld />
    <!-- 显示路由出口 -->
    <router-view />
  </div>
</template>
<!--定义页面脚本-->
<script>
//引入子组件
import HelloWorld from "./components/HelloWorld";
export default {
  name: "App", //定义组件名，默认是不包含扩展名的文件名
  components: {
    HelloWorld, //注册子组件
  },
  // 定义数据
  data() {
    return {
      title: "尚医通",
    };
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
