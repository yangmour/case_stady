<template>
  <div class="app-container">
    <el-table
      :data="tableData"
      style="width: 100%"
      row-key="id"
      border
      lazy
      :load="load"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column prop="name" label="名称" width="180"> </el-table-column>
      <el-table-column prop="code" label="地区编号" width="180">
      </el-table-column>
      <el-table-column prop="level" label="地区级别"> </el-table-column>
    </el-table>
  </div>
</template>

<script>
import regionApi from "@/api/syt/region";
export default {
  data() {
    return {
      tableData: [],
    };
  },
  methods: {
    load(tree, treeNode, resolve) {
      regionApi.getRegionList(tree.code).then((resp) => {
        console.log(resp.data);
        resolve(resp.data);
      });
    },
  },
  created() {
    regionApi.getRegionList("0").then((resp) => {
      this.tableData = resp.data;
    });
  },
};
</script>