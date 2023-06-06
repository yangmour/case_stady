<template>
  <div class="app-container">
    <div style="margin-bottom: 10px; font-size: 10px">选择：</div>
    <el-container style="height: 100%">
      <el-aside width="200px" style="border: 1px silver solid">
        <!-- 部门 -->
        <el-tree :data="data" :props="defaultProps" @node-click="selectDept">
        </el-tree>
      </el-aside>
      <el-main style="padding: 0 0 0 20px">
        <el-row style="width: 100%">
          <!-- 排班日期 -->
          <el-tag
            v-for="(item, index) in bookingScheduleList"
            :key="item.id"
            @click="selectDate(item.workDate, index)"
            :type="index == activeIndex ? '' : 'info'"
            style="height: 60px; margin-right: 15px; cursor: pointer"
          >
            {{ item.workDate }} {{ item.dayOfWeek }}<br />
            余号{{ item.availableNumber }} / 共{{ item.reservedNumber }}
          </el-tag>
          <!-- 分页 -->
          <el-pagination
            v-if="total > 0"
            :current-page="page"
            :total="total"
            :page-size="limit"
            class="pagination"
            layout="prev, pager, next"
            align="center"
            style="margin-top: 20px"
            @current-change="changePage"
          >
          </el-pagination>
        </el-row>
        <el-row style="margin-top: 20px">
          <!-- 排班日期对应的排班医生 -->
          <el-table
            v-if="scheduleDetailList.length > 0"
            :data="scheduleDetailList"
            border
            fit
            highlight-current-row
          >
            <el-table-column label="序号" width="60" align="center">
              <template slot-scope="scope">
                {{ scope.$index + 1 }}
              </template>
            </el-table-column>
            <el-table-column label="职称" width="150">
              <template slot-scope="scope">
                {{ scope.row.title }} | {{ scope.row.docname }}
              </template>
            </el-table-column>
            <el-table-column label="号源时间" width="80">
              <template slot-scope="scope">
                {{ scope.row.workTime == 0 ? "上午" : "下午" }}
              </template>
            </el-table-column>
            <el-table-column
              prop="reservedNumber"
              label="可预约数"
              width="80"
            />
            <el-table-column
              prop="availableNumber"
              label="剩余预约数"
              width="100"
            />
            <el-table-column prop="amount" label="挂号费(元)" width="90" />
            <el-table-column prop="skill" label="擅长技能" />
          </el-table>
        </el-row>
      </el-main>
    </el-container>
  </div>
</template>
  <script>
import deptApi from "@/api/syt/dept";
import scheduleApi from "@/api/syt/schedule";
export default {
  data() {
    return {
      data: [], //部门列表
      defaultProps: {
        children: "children",
        label: "depname",
      },

      hoscode: null, //医院编号
      depcode: null, //科室编号
      workDate: null, //选中的排班日期
      activeIndex: -1, //选中的排班日期的索引

      bookingScheduleList: [], //当前选中的科室下所显示的排班日期数据
      page: 1, // 当前页
      limit: 6, // 每页个数
      total: 0, // 总页码

      scheduleDetailList: [], //某一个日期下排班详情列表
    };
  },

  created() {
    this.hoscode = this.$route.params.hoscode;
    this.fetchData();
  },

  methods: {
    //查询排班详情
    getDetailSchedule() {
      scheduleApi
        .getScheduleDetail(this.hoscode, this.depcode, this.workDate)
        .then((response) => {
          this.scheduleDetailList = response.data;
        });
    },
    //获取排班日期列表
    getScheduleRule() {
      this.workDate = null;
      this.activeIndex = 0;
      this.scheduleDetailList = [];

      //调用api查询
      scheduleApi
        .getScheduleRule(this.page, this.limit, this.hoscode, this.depcode)
        .then((response) => {
          this.bookingScheduleList = response.data.list;
          this.total = response.data.total;
          this.workDate = this.bookingScheduleList[0].workDate;
          this.getDetailSchedule();
        });
    },
    //日期翻页
    changePage(page) {
      this.page = page;
      this.getScheduleRule();
    },
    //选择日期
    selectDate(workDate, index) {
      this.workDate = workDate;
      this.activeIndex = index;
      this.getDetailSchedule();
    },
    fetchData() {
      deptApi.getDeptByHoscode(this.hoscode).then((response) => {
        this.data = response.data;
        if (this.data != 0) {
          this.depcode = this.data[0].children[0].depcode;
          this.getScheduleRule();
        }
      });
    },

    //选择部门
    selectDept(data) {
      // 科室大类直接返回，
      if (data.children != null) return;

      this.depcode = data.depcode;
      this.getScheduleRule();
    },
  },
};
</script>