<template>
  <div class="app-container">

    <!-- 搜索  -->
    <el-form :inline="true" :model="searchObj" class="demo-form-inline">
      <el-form-item label="名字">
        <el-input v-model="searchObj.roleName" placeholder="角色名字"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchNameFunc">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="danger" @click="searchReset()">重置</el-button>
      </el-form-item>

      <el-button @click="showSavePage" type="success" round>新增角色</el-button>
    </el-form>

    <!--  主页面  -->
    <el-table
      ref="table"
      row-key="id"
      :data="list"
      style="width: 100%"
      :row-class-name="tableRowClassName"
      @selection-change="selectionRemoveByIds"
      v-loading="loading"
      element-loading-text="拼命加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.8)">
      <el-table-column
        reserve-selection
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column prop="roleName" label="序号" width="50" type="index">
        <template slot-scope="scope">
          {{ (currentNum - 1) * pageSize + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="roleName" label="名字" width="160">
      </el-table-column>
      <el-table-column prop="roleCode" label="代码编号" width="160">
      </el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
      <el-table-column prop="updateTime" label="修改时间"></el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="180">
        <template slot-scope="scope">
          <el-button @click="removeById(scope.row.id)" class="el-icon-delete" type="danger" size="small">删除
          </el-button>
          <el-button @click="edit(scope.row.id)" type="primary" class="el-icon-edit-outline" size="small">
            编辑
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-button style="margin: 20px" @click="batchRemoveByIds" type="danger" round>批量删除</el-button>

    <el-pagination
      @current-change="fetchData"
      style="padding: 30px;text-align: center"
      :current-page="currentNum"
      :page-size="pageSize"
      layout="total, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>

    <!--  新增和修改的  -->
    <el-dialog :visible.sync="dialogVisible" title="新增/修改">
      <el-form ref="dataForm" :model="sysRole" label-width="150px" size="small" style="padding-right: 40px;">
        <el-form-item label="角色名称">
          <el-input v-model="sysRole.roleName"/>
        </el-form-item>
        <el-form-item label="角色编码">
          <el-input v-model="sysRole.roleCode"/>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="sysRole.description"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small" icon="el-icon-refresh-right">取 消</el-button>
        <el-button type="primary" icon="el-icon-check" @click="saveOrUpdate()" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import sysRole from '@/api/system/sysRole.js'

export default {
  data() {
    return {
      // 查询
      searchObj: {
        roleName: ''
      },

      // 获取数据，分页
      list: [],
      currentNum: 1,
      pageSize: 5,
      total: 0,

      // 批量选择的数据
      rows: [],
      loading: true,

      // 新增和修改弹窗
      dialogVisible: false,
      sysRole: {
        roleName: '',
        roleCode: '',
        description: ''
      }
    }
  }, methods: {
    edit(id) {
      this.dialogVisible = true
      sysRole.edit(id).then(resp => {
        this.sysRole = resp.data
      })
    },
    saveOrUpdate() {
      if (!this.sysRole.id) {
        sysRole.save(this.sysRole).then(resp => {
          this.$message.success('添加成功！')
        })
      } else {
        sysRole.modifRole(this.sysRole).then(resp => {
          this.$message.success('修改成功！')
        })
      }
      this.dialogVisible = false
      this.fetchData()
    },
    showSavePage() {
      this.sysRole = {}
      this.dialogVisible = true
    },
    batchRemoveByIds() {
      var ids = []
      this.rows.forEach(o => ids.push(o.id))

      // 如果没有选择就不删除做提示
      if (!ids.length) {
        this.$message.warning('批量删除不能为空！')
        return
      }

      this.$confirm('此操作将永久删除该角色, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        sysRole.batchRemoveByIds(ids).then(resp => {
          this.fetchData(this.list.length === 1 ? this.currentNum - 1 : this.currentNum)
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
          this.$refs.table.clearSelection()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    selectionRemoveByIds(rows) {
      this.rows = rows
    },
    searchReset() {
      this.searchObj = {}
      this.fetchData()
    },
    searchNameFunc() {
      console.log(this.searchObj)
      this.fetchData(1)
    },
    removeById(id) {
      console.log(id)

      this.$confirm('此操作将永久删除该角色, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        sysRole.removeById(id).then(resp => {
          this.fetchData(this.list.length === 1 ? this.currentNum - 1 : this.currentNum)
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    fetchData(pageNum = 1) {
      this.currentNum = pageNum
      sysRole.getRoleList(this.currentNum, this.pageSize, this.searchObj).then((resp) => {
        this.list = resp.data.records
        this.total = resp.data.total
        this.loading = false
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
