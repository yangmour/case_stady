<template>
  <div class="app-container">
    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="searchObj.keyword" placeholder="姓名/手机" />
      </el-form-item>

      <el-form-item label="创建时间">
        <el-date-picker
          v-model="searchObj.createTimeBegin"
          type="datetime"
          placeholder="选择开始时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      至
      <el-form-item>
        <el-date-picker
          v-model="searchObj.createTimeEnd"
          type="datetime"
          placeholder="选择截止时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>

      <el-button type="primary" icon="el-icon-search" @click="fetchData()"
        >查询</el-button
      >
      <el-button type="default" @click="resetData()">清空</el-button>
    </el-form>

    <!-- 列表 -->
    <el-table v-loading="listLoading" :data="list" stripe style="width: 100%">
      <el-table-column label="序号" width="70" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="phone" label="手机号" width="110px" />
      <el-table-column prop="nickName" label="昵称" width="150px" />
      <el-table-column prop="name" label="姓名" />
      <el-table-column prop="param.certificatesTypeString" label="证件类型" />
      <el-table-column prop="certificatesNo" label="证件号" width="165px" />
      <el-table-column prop="param.statusString" label="状态" />
      <el-table-column prop="param.authStatusString" label="认证状态" />
      <el-table-column prop="createTime" label="注册时间" width="165px" />

      <el-table-column label="操作" width="300" align="center">
        <template slot-scope="scope">
          <router-link
            :to="'/userInfo/show/' + scope.row.id"
            style="margin-right: 5px"
          >
            <el-button type="primary" size="mini">查看</el-button>
          </router-link>
          <el-button
            v-if="scope.row.status == 1"
            type="danger"
            size="mini"
            @click="lock(scope.row.id, 0)"
            >锁定</el-button
          >
          <el-button
            v-if="scope.row.status == 0"
            type="info"
            size="mini"
            @click="lock(scope.row.id, 1)"
            >解锁</el-button
          >

          <el-button
            v-if="scope.row.authStatus !== 0"
            type="success"
            size="mini"
            @click="approval(scope.row.id, 2)"
            >通过</el-button
          >
          <el-button
            v-if="scope.row.authStatus !== 0"
            type="danger"
            size="mini"
            @click="approval(scope.row.id, -1)"
            >不通过</el-button>
          
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
import userInfoApi from '@/api/syt/userInfo'
export default {
  // 定义数据
  data() {
    return {
      listLoading: true, // 数据是否正在加载
      list: null, // 数据列表
      total: 0, // 总记录数
      page: 1, // 默认页码
      limit: 10, // 每页记录数
      searchObj: {}, // 查询对象
    }
  },
  // 当页面加载时获取数据
  created() {
    this.fetchData()
  },
  methods: {
    //加载数据列表
    fetchData() {
      console.log('加载数据列表')
      this.listLoading = true
      //远程接口的调用
      userInfoApi
        .getPageList(this.page, this.limit, this.searchObj)
        .then((response) => {
          //数据绑定
          this.list = response.data.records
          this.total = response.data.total
          //数据加载成功
          this.listLoading = false
        })
    },

    //改变每页记录数
    changePageSize(size) {
      console.log('size', size)
      this.limit = size
      this.fetchData()
    },

    //翻页
    changeCurrentPage(page) {
      this.page = page
      this.fetchData()
    },

    //重置列表数据
    resetData() {
      this.searchObj = {}
      this.fetchData()
    },

    //锁定与解锁
    lock(id, status) {
      userInfoApi.lock(id, status).then((response) => {
        this.fetchData(this.page)
        if (response.code) {
          this.$message.success(response.message)
        }
      })
    },

    // 审批
    approval(id, authStatus) {
      userInfoApi.approval(id, authStatus).then((response) => {
        this.fetchData(this.page)
        if (response.code) {
          this.$message.success(response.message)
        }
      })
    },
  },
}
</script>