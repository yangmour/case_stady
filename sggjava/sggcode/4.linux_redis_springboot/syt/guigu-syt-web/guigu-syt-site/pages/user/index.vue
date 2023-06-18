<template>
  <!-- header -->
  <div class="nav-container page-component">
    <!--左侧导航 #start -->
    <div class="nav left-nav">
      <div class="nav-item selected">
        <span
          class="v-link selected dark"
          onclick="javascript:window.location='/user'"
          >实名认证
        </span>
      </div>
      <div class="nav-item">
        <span
          class="v-link clickable dark"
          onclick="javascript:window.location='/order'"
        >
          挂号订单
        </span>
      </div>
      <div class="nav-item">
        <span
          class="v-link clickable dark"
          onclick="javascript:window.location='/patient'"
        >
          就诊人管理
        </span>
      </div>
      <div class="nav-item">
        <span
          class="v-link clickable dark"
          onclick="javascript:window.location='/mobile'"
        >
          绑定手机号
        </span>
      </div>
      <div class="nav-item">
        <span class="v-link clickable dark"> 意见反馈 </span>
      </div>
    </div>
    <!-- 左侧导航 #end -->
    <!-- 右侧内容 #start -->
    <div class="page-container">
      <div>
        <div class="title">实名认证</div>
        <div class="status-bar">
          <div class="status-wrapper">
            <span class="iconfont"></span>
            <span>{{ userInfo.param.authStatusString }}</span>
          </div>
        </div>
        <div class="tips">
          <span class="iconfont"></span>
          <span
            >完成实名认证后才能添加就诊人，正常进行挂号，为了不影响后续步骤，建议提前实名认证。</span
          >
        </div>
        <div class="form-wrapper" v-if="userInfo.authStatus == 0">
          <div>
            <el-form
              :model="userAuth"
              label-width="110px"
              label-position="left"
            >		
              <el-form-item prop="name" label="姓名：" class="form-normal">
                <div class="name-input">
                  <el-input
                    v-model="userAuth.name"
                    placeholder="请输入联系人姓名全称"
                    class="input v-input"
                  />
                </div>
              </el-form-item>
              <el-form-item prop="certificatesType" label="证件类型：">
                <el-select
                  v-model="userAuth.certificatesType"
                  placeholder="请选择证件类型"
                  class="v-select patient-select"
                >
                  <el-option
                    v-for="item in certificatesTypeList"
                    :key="item.value"
                    :label="item.name"
                    :value="item.value"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item prop="certificatesNo" label="证件号码：">
                <el-input
                  v-model="userAuth.certificatesNo"
                  placeholder="请输入联系人证件号码"
                  class="input v-input"
                />
              </el-form-item>
              <el-form-item prop="name" label="上传证件：">
                <div class="upload-wrapper">
                  <div class="avatar-uploader">
                    <el-upload
                      v-loading="uploadLoading"
                      element-loading-text="文件上传中"
                      class="avatar-uploader"
                      :action="uploadUrl"
                      :headers="{ token }"
                      :show-file-list="false"
                      :on-progress="onUploadProgress"
                      :on-success="onUploadSuccess"
                      :on-error="onUploadError"
                    >
                      <div class="upload-inner-wrapper">
                        <img
                          v-if="previewUrl"
                          :src="previewUrl"
                          class="avatar"
                        />
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        <div v-if="!previewUrl" class="text">上传证件合照</div>
                      </div>
                    </el-upload>
                  </div>
                  <img src="~/assets/images/auth_example.png" class="example" />
                </div>
              </el-form-item>
            </el-form>

            <div class="bottom-wrapper">
              <div class="button-wrapper">
                <div class="v-button" @click="saveUserAuth()">
                  {{ submitBnt }}
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="context-container" v-if="userInfo.authStatus != 0">
          <div>
            <el-form label-width="110px" label-position="right">
			  <el-form-item prop="name" label="手机号：" class="form-normal">
                <div class="name-input" v-if="userInfo.phone">
                  {{ userInfo.phone }}
                </div>
                <div v-else>
                  <a class="v-link" href="/mobile">绑定手机号</a>
                </div>
              </el-form-item>		
              <el-form-item prop="name" label="姓名：" class="form-normal">
                <div class="name-input">
                  {{ userInfo.name }}
                </div>
              </el-form-item>
              <el-form-item prop="name" label="证件类型：">
                {{ userInfo.param.certificatesTypeString }}
              </el-form-item>
              <el-form-item prop="name" label="证件号码：">
                {{ userInfo.certificatesNo }}
              </el-form-item>
              <el-form-item prop="name" label="证件合照：">
                <img
                  :src="userInfo.param.previewUrl"
                  alt="证件合照："
                  style="width: 300px"
                />
              </el-form-item>
              <el-form-item prop="name" label="用户状态">
                {{ userInfo.param.statusString }}
              </el-form-item>
            </el-form>
          </div>
        </div>
      </div>
    </div>
    <!-- 右侧内容 #end -->
  </div>
  <!-- footer -->
</template>

<script>
import '~/assets/css/hospital_personal.css'
import '~/assets/css/hospital.css'
import '~/assets/css/personal.css'

import cookie from 'js-cookie'
import dictApi from '~/api/dict'
import userInfoApi from '~/api/userInfo'

export default {
  data() {
    return {
      uploadLoading: false, //文件上传状态
      token: cookie.get('token'),
      userAuth: {},
      previewUrl: '',
      certificatesTypeList: [],
      uploadUrl: process.env.BASE_API + '/front/yun/file/auth/upload',

      userInfo: {
        param: {},
      },

      submitBnt: '提交',
    }
  },

  mounted() {
    this.init()
  },

  methods: {
    
    init() {
      this.getUserInfo()

      this.getDict()
    },

    getUserInfo() {
      userInfoApi.getUserInfo().then((response) => {
        this.userInfo = response.data
      })
    },

    saveUserAuth() {
      if (this.submitBnt == '正在提交...') {
        this.$message.info('请勿重复提交')
        return
      }

      this.submitBnt = '正在提交...'
      userInfoApi
        .saveUserAuth(this.userAuth)
        .then((response) => {
          this.$message.success('提交成功')
          window.location.reload()
        })
        .catch((e) => {
          this.submitBnt = '提交'
        })
    },

    getDict() {
      dictApi.dictList(2).then((response) => {
        this.certificatesTypeList = response.data
      })
    },

    //文件上传中
    onUploadProgress() {
      this.uploadLoading = true
    },

    //文件上传成功
    onUploadSuccess(response) {
      this.uploadLoading = false

      if (response.code !== 200) {
        this.$message.error('上传失败')
        return
      }

      // 填充上传文件列表
      this.userAuth.certificatesUrl = response.data.url
      this.previewUrl = response.data.previewUrl
    },

    //文件上传失败
    onUploadError() {
      this.uploadLoading = false
      this.$message.error('上传失败')
    },
  },
}
</script>


<style>
  .header-wrapper .title {
    font-size: 16px;
    margin-top: 0;
  }

  .patient-card .el-card__header .detail {
    font-size: 14px;
  }

  .page-container .title {
    letter-spacing: 1px;
    font-weight: 700;
    color: #333;
    font-size: 16px;
    margin-top: 0;
    margin-bottom: 20px;
  }

  .page-container .tips {
    width: 100%;
    padding-left: 0;
  }

  .page-container .form-wrapper {
    padding-left: 92px;
    width: 580px;
  }

  .form-normal {
    height: 40px;
  }
  .bottom-wrapper{
    width: 100%;
    padding: 0;
    margin-top: 0;
  }
</style>
