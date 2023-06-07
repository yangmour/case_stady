<template>
  <div class="header-container">
    <client-only>
      <div class="wrapper">
        <!-- logo -->
        <div
          class="left-wrapper v-link selected"
          onclick="javascript:window.location='/'"
          style="cursor: pointer"
        >
          <img
            style="width: 50px"
            width="50"
            height="50"
            src="~/assets/images/logo.png"
          />
          <span class="text">尚医通 预约挂号统一平台</span>
        </div>
        
        <!-- 右侧 -->
        <div class="right-wrapper">
          <span class="v-link clickable">帮助中心</span>

          <span v-if="name == ''" class="v-link clickable" @click="login()" id="loginDialog">登录/注册</span>

          <el-dropdown v-if="name != ''" @command="loginMenu">
                <span class="el-dropdown-link">
                  <img :src="headimgurl" alt="" style="width:35px;border-radius:50%">
                  {{ name }}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
            <el-dropdown-menu class="user-name-wrapper" slot="dropdown">
              <el-dropdown-item command="/user">实名认证</el-dropdown-item>
              <el-dropdown-item command="/order">挂号订单</el-dropdown-item>
              <el-dropdown-item command="/patient">就诊人管理</el-dropdown-item>
			  <el-dropdown-item command="/mobile">绑定手机号</el-dropdown-item>
              <el-dropdown-item command="/logout" divided>退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
        
      </div>
    </client-only>
  </div>
</template>
<script>
import cookie from 'js-cookie'

export default {

  data () {
    return {
      name: '',//登录用户名
      headimgurl: ''//用户头像
    }
  },

  mounted () {

    let code = this.$route.query.code || ''
    if (code == 201) {
      let message = this.$route.query.message || ''
      this.$message.error(message)
    }

    this.showInfo()
  },

  methods: {

    showInfo() {
      let token = cookie.get('token')
      if (token) {
        this.name = cookie.get('name')
        this.headimgurl = cookie.get('headimgurl')
      }
    },

    login() {
      window.location = process.env.BASE_API + '/front/user/wx/login'
    },

    loginMenu(command) {
      if ('/logout' == command) {
        cookie.set('name', '', {domain: 'localhost'})
        cookie.set('token', '', {domain: 'localhost'})
        cookie.set('headimgurl', '', {domain: 'localhost'})

        //跳转页面
        window.location.href = '/'
      } else {
        window.location.href = command
      }
    },
  }
}
</script>