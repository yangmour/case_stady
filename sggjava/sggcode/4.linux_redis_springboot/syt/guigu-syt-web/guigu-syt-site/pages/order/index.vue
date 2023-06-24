<template>
  <!-- header -->
  <div class="nav-container page-component">
    <!--左侧导航 #start -->
    <div class="nav left-nav">
      <div class="nav-item">
        <span
          class="v-link clickable dark"
          onclick="javascript:window.location='/user'"
          >实名认证
        </span>
      </div>
      <div class="nav-item selected">
        <span
          class="v-link selected dark"
          onclick="javascript:window.location='/order'"
        >
          挂号订单
        </span>
      </div>
      <div class="nav-item">
        <span
          class="v-link clickable dark"
          onclick="javascript:window.location='/patient'"
        >
          就诊人管理
        </span>
      </div>
      <div class="nav-item">
        <span
          class="v-link clickable dark"
          onclick="javascript:window.location='/mobile'"
        >
          绑定手机号
        </span>
      </div>
      <div class="nav-item">
        <span class="v-link clickable dark"> 意见反馈 </span>
      </div>
    </div>
    <!-- 左侧导航 #end -->
    <!-- 右侧内容 #start -->
    <div class="page-container">
      <div class="personal-order">
        <div class="header-wrapper">
          <div class="title" style="margin-bottom:40px;">挂号订单</div>
        </div>
        <div class="table-wrapper table">
          <el-table :data="orderInfolist" stripe style="width: 100%">
            <el-table-column label="就诊时间" width="120">
              <template slot-scope="scope">
                {{ scope.row.reserveDate }}
                {{ scope.row.reserveTime === 0 ? '上午' : '下午' }}
              </template>
            </el-table-column>
            <el-table-column prop="hosname" label="医院" width="100">
            </el-table-column>
            <el-table-column prop="depname" label="科室"> </el-table-column>
            <el-table-column prop="title" label="医生"> </el-table-column>
            <el-table-column prop="amount" label="医事服务费">
            </el-table-column>
            <el-table-column prop="patientName" label="就诊人">
            </el-table-column>
            <el-table-column prop="param.orderStatusString" label="订单状态">
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                  type="text"
                  class="v-link highlight clickable selected"
                  @click="show(scope.row.id)"
                  >详情</el-button
                >
              </template>
            </el-table-column>
          </el-table>
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
import orderInfoApi from '~/api/orderInfo'

export default {
  data() {
    return {
      orderInfolist: [],
    }
  },

  mounted() {
    this.orderId = this.$route.query.orderId
    this.fetchData()
  },

  methods: {
    //订单列表
    fetchData() {
      orderInfoApi.getList().then((response) => {
        this.orderInfolist = response.data
      })
    },

    show(id) {
      window.location.href = '/order/show?orderId=' + id
    },
  },
}
</script>