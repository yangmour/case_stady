<template>
  <div>
    <h2>{{ title }}</h2>
    <ul class="nav">
      <li>
        <router-link to="/index">主页面</router-link>
      </li>
      <li>
        <router-link to="/order">订单页面</router-link>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      title: '子组件'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
