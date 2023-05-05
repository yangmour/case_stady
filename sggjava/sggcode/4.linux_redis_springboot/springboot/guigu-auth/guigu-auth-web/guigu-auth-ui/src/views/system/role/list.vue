<template>
  <div class="app-container">
    <el-table :data="list" style="width: 100%" :row-class-name="tableRowClassName">
      <el-table-column prop="roleName" label="序号" width="50" type="index">
        <template slot-scope="scope">
          {{ (currentNum - 1) * pageSize + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="roleName" label="名字" width="180">
      </el-table-column>
      <el-table-column prop="roleCode" label="代码编号" width="180">
      </el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
      <el-table-column prop="updateTime" label="修改时间"></el-table-column>
    </el-table>

    <el-pagination
      @current-change="fetchData"
      style="padding: 30px;text-align: center"
      :current-page="currentNum"
      :page-size="pageSize"
      layout="total, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
  </div>
</template>

<script>
import sysRole from '@/api/system/sysRole.js'

export default {
  data() {
    return {
      list: [],
      currentNum: 1,
      pageSize: 5,
      total: 0
    }
  }, methods: {
    fetchData(pageNum = 1) {
      this.currentNum = pageNum
      sysRole.getRoleList(this.currentNum, this.pageSize, {}).then((resp) => {
        this.list = resp.data.records
        this.total = resp.data.total
      })
    },
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex === 1) {
        return 'warning-row'
      } else if (rowIndex === 3) {
        return 'success-row'
      }
      return ''
    }
  },
  created() {
    this.fetchData()
  }
}
</script>

<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
