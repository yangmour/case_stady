<template>
  <div class="app-container">
    <el-table
      :data="tableData"
      style="width: 100%"
      :row-class-name="tableRowClassName"
    >
      <el-table-column
        prop="hosname"
        label="医院名称"
        width="150"
      ></el-table-column>
      <el-table-column
        prop="hoscode"
        label="医院编号"
        width="150"
      ></el-table-column>
      <el-table-column
        prop="apiUrl"
        label="api地址"
        width="150"
      ></el-table-column>
      <el-table-column
        prop="contactsName"
        label="联系人"
        width="150"
      ></el-table-column>

      <el-table-column
        prop="status"
        label="状态"
        width="150">
      <template slot-scope="scope">
        {{scope.row.status==1?"可用":"禁用"}}
      </template>
    </el-table-column>
    </el-table>
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
      pageSize: 5,
      searchObj: {},
      total: 0,
    };
  },
  methods: {
    fetchData(pageNum = 1, searchObj) {
        this.pageNum=pageNum
      hospsetApi.getPageList(this.pageNum, this.pageSize, this.searchObj).then(resp => {
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
    console.log("cs");
    this.fetchData();
  },
};
</script>