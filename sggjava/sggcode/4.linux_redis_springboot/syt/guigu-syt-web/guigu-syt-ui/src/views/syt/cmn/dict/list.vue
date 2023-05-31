<template>
  <div class="app-container">
    <el-table
      :data="tableData"
      style="width: 100%; margin-bottom: 20px"
      row-key="id"
      border
      default-expand-all
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column prop="name" label="名称" sortable width="180">
      </el-table-column>
      <el-table-column prop="id" label="ID" sortable width="180">
      </el-table-column>
      <el-table-column prop="value" label="值"> </el-table-column>
    </el-table>
  </div>
</template>

<script>
import dictApi from "@/api/syt/dict";

export default {
  data() {
    return {
      tableData: [],
    };
  },
  methods: {},
  created() {
    dictApi.getList().then((resp) => {
      this.tableData = resp.data
      this.$message.success(resp.message)
    });
  },
};
</script>