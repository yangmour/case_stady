<template>

  <!-- header -->
  <div class="nav-container page-component">
    <!--左侧导航 #start -->
    <div class="nav left-nav">
      <div class="nav-item ">
        <span class="v-link clickable dark" onclick="javascript:window.location='/user'">实名认证 </span>
      </div>
      <div class="nav-item ">
        <span class="v-link clickable dark" onclick="javascript:window.location='/order'"> 挂号订单 </span>
      </div>
      <div class="nav-item selected">
        <span class="v-link selected dark" onclick="javascript:window.location='/patient'"> 就诊人管理 </span>
      </div>
      <div class="nav-item">
        <span
          class="v-link clickable dark"
          onclick="javascript:window.location='/mobile'"
        >
          绑定手机号
        </span>
      </div>
      <div class="nav-item ">
        <span class="v-link clickable dark"> 意见反馈 </span>
      </div>
    </div>
    <!-- 左侧导航 #end -->

    <!-- 右侧内容 #start -->
    <div class="page-container">
      <div class="personal-patient">
        <div class="header-wrapper">
          <div class="title"> 就诊人管理</div>
        </div>
        <div class="content-wrapper">
          <el-card class="patient-card" shadow="always" v-for="item in patientList" :key="item.id">
            <div slot="header" class="clearfix">
              <div>
                <span class="name">{{ item.name }}</span>
                  <span>
                    {{ item.certificatesNo }} 
                    {{ item.param.certificatesTypeString }}
                    <el-tag>{{ item.param.expenseMethod }}</el-tag>
                  </span>
                <div  class="detail" @click="show(item.id)"> 查看详情 <span  class="iconfont"></span></div>
              </div>
            </div>
          </el-card>

          <div class="item-add-wrapper v-card clickable" @click="add()">
            <div class="">
              <div>+ 添加就诊人</div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 右侧内容 #end -->
  </div>
  <!-- footer -->
</template>

<script>
import '~/assets/css/hospital_personal.css'
import '~/assets/css/hospital.css'
import '~/assets/css/personal.css'

import patientApi from '~/api/patient'

export default {

  data() {
    return {
      patientList: []
    }
  },

  //created：Nuxt会执行2次，服务器渲染与客户端渲染
  mounted() {
    this.findPatientList()
  },

  methods: {
    findPatientList() {
      patientApi.findList().then(response => {
        this.patientList = response.data
      })
    },

    add() {
      window.location.href = '/patient/add'
    },

    show(id) {
      window.location.href = '/patient/show?id=' + id
    }
  }
}
</script>
<style>
  .header-wrapper .title {
    font-size: 16px;
    margin-top: 0;
  }

  .content-wrapper {
    margin-left: 0;
  }
  .patient-card .el-card__header .detail{
    font-size: 14px;
  }

</style>
