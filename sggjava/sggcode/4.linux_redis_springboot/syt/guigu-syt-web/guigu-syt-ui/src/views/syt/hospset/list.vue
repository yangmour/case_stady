<template>
  <div class="app-container">
    <!-- 搜索表单 -->
    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
            <el-input v-model="searchObj.hosname" placeholder="医院名称"/>
        </el-form-item>
        <el-form-item>
            <el-input v-model="searchObj.hoscode" placeholder="医院编号"/>
        </el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="searchData()" :loading="listLoading">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table
      :data="tableData"
      style="width: 100%"
      :row-class-name="tableRowClassName"
    >
      <el-table-column
        prop="hosname"
        label="医院名称"
        width="180"
      ></el-table-column>
      <el-table-column
        prop="hoscode"
        label="医院编号"
        width="180"
      ></el-table-column>
      <el-table-column
        prop="apiUrl"
        label="api地址"
        width="180"
      ></el-table-column>
      <el-table-column
        prop="contactsName"
        label="联系人"
        width="180"
      ></el-table-column>

      <el-table-column prop="status" label="状态" width="150">
        <template slot-scope="scope">
          {{ scope.row.status == 1 ? "可用" : "禁用" }}
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button
            type="primary"
            size="mini"
            @click="handleEdit(scope.$index, scope.row)"
            class="el-icon-edit"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            class="el-icon-delete"
            >删除</el-button
          >
          <el-button
            size="mini"
            type="warning"
            @click="handleDelete(scope.$index, scope.row)"
            class="el-icon-lock"
            >锁定</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      style="padding: 10px; text-align: center"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pageNum"
      :page-sizes="[3, 10, 20]"
      :page-size="3"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
  </div>
</template>
  
  <style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
  
  <script>
import hospsetApi from "@/api/syt/hospset";

export default {
  data() {
    return {
      tableData: [],
      pageNum: 1,
      pageSize: 3,
      searchObj: {},
      total: 0,
    };
  },
  methods: {
    searchData(){
        this.fetchData()
    },
    resetData(){
        this.searchObj = {}
        this.fetchData();
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.fetchData();
    },
    handleCurrentChange(val) {
      this.fetchData(val);
    },
    fetchData(pageNum = 1, pageSize, searchObj) {
      this.pageNum = pageNum;
      hospsetApi
        .getPageList(this.pageNum, this.pageSize, this.searchObj)
        .then((resp) => {
          this.tableData = resp.data.records; //列表数据
          this.total = resp.data.total; //总记录数
        });
    },
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex === 1) {
        return "warning-row";
      } else if (rowIndex === 3) {
        return "success-row";
      }
      return "";
    },
  },
  created() {
    this.fetchData();
  },
};
</script>