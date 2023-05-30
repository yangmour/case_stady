<template>
  <div class="app-container">
    <!-- 搜索表单 -->
    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="searchObj.hosname" placeholder="医院名称" />
      </el-form-item>
      <el-form-item>
        <el-input v-model="searchObj.hoscode" placeholder="医院编号" />
      </el-form-item>
      <el-button
        type="primary"
        icon="el-icon-search"
        @click="searchData()"
        :loading="listLoading"
        >查询</el-button
      >
      <el-button type="default" @click="resetData()">清空</el-button>
    </el-form>
    <!-- 表格 -->
    <el-table
      :data="tableData"
      style="width: 100%"
      :row-class-name="tableRowClassName"
      @selection-change="handleSelectionChange"
    >
      >
      <!--  选择框 -->
      <el-table-column type="selection" width="50"> </el-table-column>
      <el-table-column width="50" label="序号">
        <template slot-scope="scope">
          {{ (pageNum - 1) * pageSize + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column
        prop="hosname"
        label="医院名称"
        width="130"
      ></el-table-column>
      <el-table-column
        prop="hoscode"
        label="医院编号"
        width="130"
      ></el-table-column>
      <el-table-column
        prop="apiUrl"
        label="api地址"
        width="160"
      ></el-table-column>
      <el-table-column
        prop="contactsName"
        label="联系人"
        width="150"
      ></el-table-column>

      <el-table-column prop="status" label="状态" width="60">
        <template slot-scope="scope">
          {{ scope.row.status == 1 ? "可用" : "禁用" }}
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <router-link :to="'/syt/hospset/edit/'+scope.row.id">>
                <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
            </router-link>

          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.id, scope.$index)"
            class="el-icon-delete"
            >删除</el-button
          >
          <el-button
            size="mini"
            v-if="scope.row.status == 1"
            type="warning"
            class="el-icon-lock"
            @click="updateStatus(scope.row.id, 0, scope.$index)"
            >锁定</el-button
          >

          <el-button
            size="mini"
            v-if="scope.row.status == 0"
            type="success"
            class="el-icon-lock"
            @click="updateStatus(scope.row.id, 1, scope.$index)"
            >可用</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-button style="margin-top: 10px" type="danger" plain @click="batchDel"
      >批量删除</el-button
    >

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
      multipleSelection: [],
    };
  },
  methods: {
    updateStatus(id, status, index) {
      hospsetApi.updateStatus(id, status).then((resp) => {
        this.tableData[index].status = status;
        this.$message.success(resp.message);
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    batchDel() {
      if (this.multipleSelection == 0) {
        this.$message.success("没有选择数据");
      } else {
        this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            var ids = [];
            this.multipleSelection.forEach((element) => {
              ids.push(element.id);
            });
            hospsetApi.batchDelete(ids).then((resp) => {
              this.$message.success(resp.message);
              this.fetchData(1);
            });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除",
            });
          });
      }
    },
    handleDelete(val, index) {
      console.log(index);
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          hospsetApi.deleteById(val).then((resp) => {
            this.$message.success(resp.message);
            if (this.tableData.length == 1) {
              this.fetchData(this.pageNum - 1);
            } else {
              this.fetchData(this.pageNum);
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    searchData() {
      this.fetchData();
    },
    resetData() {
      this.searchObj = {};
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