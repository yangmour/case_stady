<template>
  <div class="app-container">
    <el-table :data="list" style="width: 100%">
      <el-table-column prop="roleName" label="名字" width="180">
      </el-table-column>
      <el-table-column prop="roleCode" label="代码编号" width="180">
      </el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
      <el-table-column prop="updateTime" label="修改时间"></el-table-column>
    </el-table>

    <el-pagination
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
      pageSize: 10,
      total: 0
    }
  },
  created() {
    sysRole.getRoleList(1, 10, {}).then((resp) => {
      this.list = resp.data.records
      this.total = resp.data.total
    })
  }
}
</script>
