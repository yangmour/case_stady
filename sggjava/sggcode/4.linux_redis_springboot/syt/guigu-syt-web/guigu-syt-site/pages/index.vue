<template>
  <div class="home page-component">
    <el-carousel indicator-position="outside">
      <el-carousel-item>
        <img src="~assets/images/web-banner1.png" alt="" />
      </el-carousel-item>
    </el-carousel>
    <!-- 搜索 -->
    <div class="search-container">
      <div class="search-wrapper">
        <div class="hospital-search">
          <el-input
            class="search-input"
            v-model="searchObj.hosname"
            prefix-icon="el-icon-search"
            placeholder="输入医院名称"
          >
            <span
              @click="fetchData()"
              slot="suffix"
              class="search-btn v-link highlight clickable selected"
              >搜索
            </span>
          </el-input>
        </div>
      </div>
    </div>
    <!-- bottom -->
    <div class="bottom">
      <div class="left">
        <div class="home-filter-wrapper">
          <div class="title">医院</div>
          <div>
            <div class="filter-wrapper">
              <span class="label">等级：</span>
              <div class="condition-wrapper">
                <span
                  class="item v-link clickable"
                  :class="hostypeActiveIndex == -1 ? 'selected' : ''"
                  @click="hostypeSelect(undefined, -1)"
                >
                  全部
                </span>
                <span
                  class="item v-link clickable"
                  :class="hostypeActiveIndex == index ? 'selected' : ''"
                  v-for="(item, index) in hostypeList"
                  :key="item.id"
                  @click="hostypeSelect(item.value, index)"
                >
                  {{ item.name }}
                </span>
              </div>
            </div>
            <div class="filter-wrapper">
              <span class="label">地区：</span>
              <div class="condition-wrapper">
                <span
                  class="item v-link clickable"
                  :class="areaActiveIndex == -1 ? 'selected' : ''"
                  @click="areaSelect(undefined, -1)"
                >
                  全部 </span
                ><span
                  class="item v-link clickable"
                  :class="areaActiveIndex == index ? 'selected' : ''"
                  v-for="(item, index) in areaList"
                  :key="item.id"
                  @click="areaSelect(item.code, index)"
                >
                  {{ item.name }}
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="v-scroll-list hospital-list">
          <div
            v-for="item in hospitalList"
            :key="item.hoscode"
            class="v-card clickable list-item"
          >
            <div class="">
              <div
                @click="show(item.hoscode)"
                class="hospital-list-item hos-item"
                index="0"
              >
                <div class="wrapper">
                  <div class="hospital-title">{{ item.hosname }}</div>
                  <div class="bottom-container">
                    <div class="icon-wrapper">
                      <span class="iconfont"></span>
                      {{ item.param.hospName }}
                    </div>
                    <div class="icon-wrapper">
                      <span class="iconfont"></span>
                      每天{{ item.bookingRule.releaseTime }}放号
                    </div>
                  </div>
                </div>
                <img
                  :src="'data:image/jpeg;base64,' + item.logoData"
                  :alt="item.hosname"
                  class="hospital-img"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="right">
        <div class="common-dept">
          <div class="header-wrapper">
            <div class="title">常见科室</div>
            <div class="all-wrapper">
              <span>全部</span>
              <span class="iconfont icon"></span>
            </div>
          </div>
          <div class="content-wrapper">
            <span class="item v-link clickable dark">神经内科 </span>
            <span class="item v-link clickable dark">消化内科 </span>
            <span class="item v-link clickable dark">呼吸内科 </span>
            <span class="item v-link clickable dark">内科 </span>
            <span class="item v-link clickable dark">神经外科 </span>
            <span class="item v-link clickable dark">妇科 </span>
            <span class="item v-link clickable dark"> 产科 </span>
            <span class="item v-link clickable dark">儿科 </span>
          </div>
        </div>
        <div class="space">
          <div class="header-wrapper">
            <div class="title-wrapper">
              <div class="icon-wrapper">
                <span class="iconfont title-icon"></span>
              </div>
              <span class="title">平台公告</span>
            </div>
            <div class="all-wrapper">
              <span>全部</span>
              <span class="iconfont icon"></span>
            </div>
          </div>
          <div class="content-wrapper">
            <div class="notice-wrapper">
              <div class="point"></div>
              <span class="notice v-link clickable dark"
                >关于延长北京大学国际医院放假的通知
              </span>
            </div>
            <div class="notice-wrapper">
              <div class="point"></div>
              <span class="notice v-link clickable dark"
                >北京中医药大学东方医院部分科室医生门诊医
              </span>
            </div>
            <div class="notice-wrapper">
              <div class="point"></div>
              <span class="notice v-link clickable dark">
                武警总医院号源暂停更新通知
              </span>
            </div>
          </div>
        </div>
        <div class="suspend-notice-list space">
          <div class="header-wrapper">
            <div class="title-wrapper">
              <div class="icon-wrapper">
                <span class="iconfont title-icon"></span>
              </div>
              <span class="title">停诊公告</span>
            </div>
            <div class="all-wrapper">
              <span>全部</span>
              <span class="iconfont icon"></span>
            </div>
          </div>
          <div class="content-wrapper">
            <div class="notice-wrapper">
              <div class="point"></div>
              <span class="notice v-link clickable dark">
                中国人民解放军总医院第六医学中心(原海军总医院)呼吸内科门诊停诊公告
              </span>
            </div>
            <div class="notice-wrapper">
              <div class="point"></div>
              <span class="notice v-link clickable dark">
                首都医科大学附属北京潞河医院老年医学科门诊停诊公告
              </span>
            </div>
            <div class="notice-wrapper">
              <div class="point"></div>
              <span class="notice v-link clickable dark"
                >中日友好医院中西医结合心内科门诊停诊公告
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<!-- 客户端渲染实例 -->
<script>
import dictApi from "~/api/dict";
import regionApi from "~/api/region";
import hospApi from "~/api/hosp";

export default {
  // <!-- 服务端渲染异步实例 -->
  // asyncData(){
  //   return dictApi.dictList(1).then((response) => {
  //     const hostypeList = response.data;
  //     return {
  //       hostypeList
  //     }
  //   });
  // },

  // <!-- 服务端渲染同步实例 -->
  async asyncData() {
    //获取等级
    const hostypeResponse = await dictApi.dictList(1);
    //获取地区
    const areaResponse = await regionApi.regionList("110100");
    //获取医院
    const hospitalResponse = await hospApi.hospList({});

    return {
      hostypeList: hostypeResponse.data,
      areaList: areaResponse.data,
      hospitalList: hospitalResponse.data
    };
  },
  data() {
    return {
      hostypeActiveIndex: -1, //类别高亮索引
      areaActiveIndex: -1, //地区高亮索引
      searchObj: {}, //查询对象
      hostypeList: [], //医院类型列表
      hospitalList: [],
      areaList: [],
    };
  },
  created() {},
  methods: {
    //根据医院等级查询
    hostypeSelect(hostype, index) {
      this.hostypeActiveIndex = index;
      this.searchObj.hostype = hostype;
      this.fetchData();
    },
    //根据地区查询
    areaSelect(districtCode, index) {
      this.areaActiveIndex = index;
      this.searchObj.districtCode = districtCode;
      this.fetchData();
    },
    //查询医院数据
    fetchData() {
      hospApi.hospList(this.searchObj).then((response) => {
        this.hospitalList = response.data;
      });
    },
    //点击某个医院名称，跳转到详情页面中
    show(hoscode) {
      window.location.href = "/hospital/" + hoscode;
    },
  },
};
</script>