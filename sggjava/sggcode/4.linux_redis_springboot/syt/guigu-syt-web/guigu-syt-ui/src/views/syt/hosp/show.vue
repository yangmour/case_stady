<template>
    <div class="app-container">
      <h4>基本信息</h4>
      <table
        class="table table-striped table-condenseda table-bordered"
        width="100%"
      >
        <tbody>
          <tr>
            <th width="15%">医院名称</th>
            <td width="35%">
              <b style="font-size: 14px">{{ hospital.hosname }}</b> |
              {{ hospital.param.hospName }}
            </td>
            <th width="15%"></th>
            <td width="35%">
              <img
                :src="'data:image/jpeg;base64,' + hospital.logoData"
                width="80"
              />
            </td>
          </tr>
          <tr>
            <th>医院编码</th>
            <td>{{ hospital.hoscode }}</td>
            <th>地址</th>
            <td>{{ hospital.param.address }}</td>
          </tr>
          <tr>
            <th>坐车路线</th>
            <td colspan="3">{{ hospital.route }}</td>
          </tr>
          <tr>
            <th>医院简介</th>
            <td colspan="3">{{ hospital.intro }}</td>
          </tr>
        </tbody>
      </table>
      <h4>预约规则信息</h4>
      <table
        class="table table-striped table-condenseda table-bordered"
        width="100%"
      >
        <tbody>
          <tr>
            <th width="15%">预约周期</th>
            <td width="35%">{{ hospital.bookingRule.cycle }}天</td>
            <th width="15%">放号时间</th>
            <td width="35%">{{ hospital.bookingRule.releaseTime }}</td>
          </tr>
          <tr>
            <th>停挂时间</th>
            <td>{{ hospital.bookingRule.stopTime }}</td>
            <th>退号时间</th>
            <td>
              {{ hospital.bookingRule.quitDay == -1 ? '就诊前一工作日' : '就诊当日'
              }}{{ hospital.bookingRule.quitTime }} 前取消
            </td>
          </tr>
          <tr>
            <th>预约规则</th>
            <td colspan="3">
              <ol>
                <li v-for="item in hospital.bookingRule.rule" :key="item">{{ item }}</li>
              </ol>
            </td>
          </tr>
        </tbody>
      </table>
      <p style="text-align:center;"><el-button @click="back">返回</el-button></p>
      
    </div>
  </template>
  
  <script>
  import hospApi from '@/api/syt/hosp'
  import '@/styles/show.css'
  
  export default {
    data() {
      return {
        hospital: null, //医院信息
      }
    },
  
    created () {
      
      this.fetchHospByHoscode(this.$route.params.hoscode)
  
    },
  
    methods: {
      //获取医院详情
      fetchHospByHoscode(hoscode){
        hospApi.getHospByCode(hoscode).then(response => {
          this.hospital = response.data
        })
      },
  
      //返回到医院列表
      back(){
        //   this.$router.push({path: '/syt/hospset/hosp/list'})
        //   this.$router.push('/syt/hospset/hosp/list')
          window.history.back(-1)
        //   Window.history.forward(1)
      }
    }
  }
  </script>