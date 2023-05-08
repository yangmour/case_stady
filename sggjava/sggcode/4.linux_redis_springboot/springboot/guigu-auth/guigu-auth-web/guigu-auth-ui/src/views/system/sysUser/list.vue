<template>
  <div class="app-container">

    <div class="search-div">
      <el-form label-width="70px" size="small">
        <el-row>
          <el-col :span="8">
            <el-form-item label="关 键 字">
              <el-input v-model="searchObj.keyword" style="width: 95%" placeholder="用户名/姓名/手机号码" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="操作时间">
              <el-date-picker
                v-model="createTimes"
                type="datetimerange"
                range-separator="至"
                start-placeholder="开始时间"
                end-placeholder="结束时间"
                value-format="yyyy-MM-dd HH:mm:ss"
                style="margin-right: 10px;width: 100%;"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row style="display:flex">
          <el-button type="primary" icon="el-icon-search" size="mini" @click="fetchData()">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetData">重置</el-button>
        </el-row>
      </el-form>
    </div>

    <!-- 工具条 -->
    <div class="tools-div">
      <el-button type="success" icon="el-icon-plus" size="mini" @click="add">添 加</el-button>
    </div>

    <!-- 列表 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%;margin-top: 10px;"
    >

      <el-table-column
        label="序号"
        width="70"
        align="center"
      >
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="username" label="用户名" width="180" />
      <el-table-column prop="name" label="姓名" width="110" />
      <el-table-column prop="phone" label="手机" />
      <el-table-column label="状态" width="80">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.status === 1"
            @change="switchStatus(scope.row)"
          />
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" />

      <el-table-column label="操作" align="center" fixed="right">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini" title="修改" @click="edit(scope.row.id)" />
          <el-button
            type="danger"
            icon="el-icon-delete"
            size="mini"
            title="删除"
            @click="removeDataById(scope.row.id)"
            :disabled="!$hasBP('bnt.sysUser.remove')"
          />
          <el-button
            type="warning"
            icon="el-icon-baseball"
            size="mini"
            title="分配角色"
            @click="showAssignRole(scope.row)"
          />
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="fetchData"
    />

    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%">
      <el-form
        ref="dataForm"
        :rules="rules"
        :model="sysUser"
        label-width="100px"
        size="small"
        style="padding-right: 40px;"
      >
        <el-form-item label="用户名" prop="username">
          <el-input v-model="sysUser.username" />
        </el-form-item>
        <el-form-item v-if="!sysUser.id" label="密码" prop="password">
          <el-input v-model="sysUser.password" type="password" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="sysUser.name" />
        </el-form-item>
        <el-form-item label="手机" prop="phone">
          <el-input v-model="sysUser.phone" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button size="small" icon="el-icon-refresh-right" @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" icon="el-icon-check" size="small" @click="saveOrUpdate()">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog title="分配角色" :visible.sync="dialogRoleVisible">
      <el-form label-width="80px">
        <el-form-item label="用户名">
          <el-input disabled :value="sysUser.username" />
        </el-form-item>

        <el-form-item label="角色列表">
          <el-checkbox v-model="checkAll" :indeterminate="isIndeterminate" @change="handleCheckAllChange">全选
          </el-checkbox>
          <div style="margin: 15px 0;" />
          <el-checkbox-group v-model="userRoleIds" @change="handleCheckedChange">
            <el-checkbox v-for="role in allRoles" :key="role.id" :label="role.id">{{ role.roleName }}</el-checkbox>
          </el-checkbox-group>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button type="primary" size="small" @click="assignRole">保存</el-button>
        <el-button size="small" @click="dialogRoleVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import api from '@/api/system/sysUser'
import roleApi from '@/api/system/sysRole'

const defaultForm = {
  id: '',
  username: '',
  password: '',
  name: '',
  phone: '',
  status: 1
}
export default {
  data() {
    return {
      listLoading: true, // 数据是否正在加载
      list: null, // 用户列表
      total: 0, // 数据库中的总记录数
      page: 1, // 默认页码
      limit: 2, // 每页记录数
      searchObj: {}, // 查询表单对象

      createTimes: [],

      dialogVisible: false,
      sysUser: defaultForm,

      dialogRoleVisible: false,
      allRoles: [], // 所有角色列表
      userRoleIds: [], // 用户的角色ID的列表
      isIndeterminate: false, // 是否是不确定的
      checkAll: false, // 是否全选
      rules: {
        username: [
          { required: true, message: '请输用户名', trigger: 'blur' },
          { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
        ]
      }
    }
  },

  // 生命周期函数：内存准备完毕，页面尚未渲染
  created() {
    console.log('list created......')
    this.fetchData()
  },

  // 生命周期函数：内存准备完毕，页面渲染成功
  mounted() {
    console.log('list mounted......')
  },

  methods: {
    // 分页加载用户列表数据
    fetchData(page = 1) {
      debugger
      if (this.createTimes && this.createTimes.length == 2) {
        this.searchObj.createTimeBegin = this.createTimes[0]
        this.searchObj.createTimeEnd = this.createTimes[1]
      }
      // 设值listLoading的值为false
      this.listLoading = false
      this.page = page
      api.findPageList(this.page, this.limit, this.searchObj).then(res => {
        // 给list赋值
        this.list = res.data.records
        // 给总页数赋值
        this.total = res.data.total
      })
    },

    // 重置查询表单
    resetData() {
      // 将搜索条件清空
      this.searchObj = {}
      // 清空日期
      this.createTimes = []
      // 重新查询
      this.fetchData()
    },

    // 根据id删除数据
    removeDataById(id) {
      // debugger
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => { // promise
        // 点击确定，远程调用ajax
        return api.delete(id)
      }).then((response) => {
        this.fetchData(this.page)
        this.$message.success(response.message || '删除成功')
      }).catch(() => {
        this.$message.info('取消删除')
      })
    },

    // 弹出添加表单
    add() {
      // 弹出表单
      this.dialogVisible = true
      // 清空表单中的数据
      this.sysUser = Object.assign({}, defaultForm)
    },

    // 编辑
    edit(id) {
      // 弹出表单
      this.dialogVisible = true
      // 调用api中根据id查询的方法
      api.getById(id).then((res) => {
        // 给sysUser赋值
        this.sysUser = res.data
      })
    },

    // 添加或更新
    saveOrUpdate() {
      // 对表单中的数据进行校验
      this.$refs['dataForm'].validate(res => {
        if (res) {
          // 隐藏表单
          this.dialogVisible = false
          // 判断用户是在添加还是在更新
          if (!this.sysUser.id) {
            // 调用添加的函数
            this.save()
          } else {
            // 调用更新的函数
            this.update()
          }
        } else {
          return false
        }
      })
    },

    // 添加
    save() {
      // 调用api中添加的方法
      api.save(this.sysUser).then(res => {
        // 弹出提示框
        this.$message.success(res.message)
        // 再查询一遍
        this.fetchData()
      })
    },

    // 更新
    update() {
      // 调用api中更新的方法
      api.update(this.sysUser).then(res => {
        // 弹出提示框
        this.$message.success(res.message)
        // 再查询一遍
        this.fetchData(this.page)
      })
    },

    // 切换用户状态
    switchStatus(row) {
      // 切换status的值
      row.status = row.status == 1 ? 0 : 1
      // 调用api中更新状态的方法
      api.updateStatus(row.id, row.status).then(res => {
        // 弹出提示框
        this.$message.success(res.message)
        // 重新查询
        this.fetchData(this.page)
      })
    },

    // 去分配角色的页面
    showAssignRole(row) {
      // 将当前行的数据赋值给sysUser
      this.sysUser = row
      // 弹出分配角色的表单
      this.dialogRoleVisible = true
      // 调用roleApi中的方法查询当所有角色及当前用户已分配的角色id
      roleApi.getRolesByUserId(row.id).then(res => {
        // 给所有角色赋值
        this.allRoles = res.data.allRoles
        // 给当前用户已经拥有的角色id赋值
        this.userRoleIds = res.data.userRoleIds
        // 全选复选框的状态
        this.checkAll = (this.userRoleIds.length == this.allRoles.length)
        // 设置是否是不确定的值
        this.isIndeterminate = (this.userRoleIds.length > 0 && this.userRoleIds.length < this.allRoles.length)
      })
    },

    /*
    全选勾选状态发生改变的监听
    */
    handleCheckAllChange(value) { // value 当前勾选状态true/false
      // 如果当前全选, userRoleIds就是所有角色id的数组, 否则是空数组
      this.userRoleIds = value ? this.allRoles.map(item => item.id) : []
      // 如果当前不是全选也不全不选时, 指定为false
      this.isIndeterminate = false
    },

    /*
    角色列表选中项发生改变的监听
    */
    handleCheckedChange(value) {
      const { userRoleIds, allRoles } = this
      this.checkAll = userRoleIds.length === allRoles.length && allRoles.length > 0
      this.isIndeterminate = userRoleIds.length > 0 && userRoleIds.length < allRoles.length
    },

    // 分配角色
    assignRole() {
      // 隐藏分配角色的表单
      this.dialogRoleVisible = false
      // 设置一个变量用来提交数据
      var assignRoleVo = {
        userId: this.sysUser.id,
        roleIdList: this.userRoleIds
      }
      // 调用roleApi中分配角色的方法
      roleApi.assignRoles(assignRoleVo).then(res => {
        this.$message.success(res.message)
        this.fetchData(this.page)
      })
    }

  }
}
</script>
