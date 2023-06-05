<template>
    <div class="app-container">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="hosname" placeholder="医院名称" />
        </el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="fetchData()">
          查询
        </el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
      <!-- banner列表 -->
      <el-table
        v-loading="listLoading"
        :data="list"
        element-loading-text="数据加载中"
        border
        highlight-current-row>
        <el-table-column label="序号" width="60" align="center">
          <template slot-scope="scope">
            {{ (page - 1) * limit + scope.$index + 1 }}
          </template>
        </el-table-column>
        <el-table-column label="LOGO" width="80">
          <template slot-scope="scope">
            <img
              :src="'data:image/jpeg;base64,' + scope.row.logoData"
              width="50"
            />
          </template>
        </el-table-column>
        <el-table-column prop="hosname" label="医院名称" />
        <el-table-column prop="param.hospName" label="等级" width="90" />
        <el-table-column prop="param.address" label="详情地址" />
        <el-table-column label="状态" width="80">
          <template slot-scope="scope">
            {{ scope.row.status === 1 ? '已上线' : '未上线' }}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="230" align="center">
          <template slot-scope="scope">
            <router-link
              :to="'/syt/hospset/hosp/show/' + scope.row.hoscode"
              style="margin-right: 5px"
            >
              <el-button type="primary" size="mini">查看</el-button>
            </router-link>
            <router-link
              :to="'/syt/hospset/hosp/schedule/' + scope.row.hoscode"
              style="margin-right: 5px"
            >
              <el-button type="success" size="mini">排班</el-button>
            </router-link>
            <el-button
              v-if="scope.row.status == 1"
              type="warning"
              size="mini"
              @click="updateStatus(scope.row.hoscode, 0)"
              >下线</el-button
            >
            <el-button
              v-else
              type="info"
              size="mini"
              @click="updateStatus(scope.row.hoscode, 1)"
              >上线</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页组件 -->
      <el-pagination
        :current-page="page"
        :total="total"
        :page-size="limit"
        :page-sizes="[2, 5, 10]"
        style="padding: 30px 0; text-align: center"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="changePageSize"
        @current-change="changeCurrentPage"
      />
    </div>
  </template>
  
  <script>
  import hosp from '@/api/syt/hosp'
  export default {
    data() {
      return {
        listLoading: true, // 数据是否正在加载
        list: null, // 医院列表数据集合
        total: 0, // 数据库中的总记录数
        page: 1, // 默认页码
        limit: 10, // 每页记录数
        hosname: '', //查询表单：医院名称
      }
    },
    created() {
      //调用医院列表
      this.fetchData()
    },
    methods: {
      //医院列表
      fetchData() {
        console.log('加载列表')
        this.listLoading = true
        hosp.getPageList(this.page, this.limit, this.hosname).then((response) => {
          this.list = response.data.content
          this.total = response.data.totalElements
          this.listLoading = false
        })
      },
  
      // 每页记录数改变，size：回调参数，表示当前选中的“每页条数”
      changePageSize(size) {
        this.limit = size
        this.fetchData()
      },
      // 改变页码，page：回调参数，表示当前选中的“页码”
      changeCurrentPage(page) {
        this.page = page
        this.fetchData()
      },
      //清空查询表单
      resetData() {
        this.hosname = ''
        this.fetchData()
      },
  
      //修改状态
      updateStatus(hoscode, status) {
        hosp.updateStatus(hoscode, status).then((response ) => {
          this.$message.success(response.message),
          this.fetchData(this.page)
        })
      },
    },
  }
  </script>