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
          <span class="v-link clickable">登录/注册</span>
        </div>
      </div>
    </client-only>
  </div>
</template>
<script>
export default {}
</script>