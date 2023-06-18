<template>
  <!-- header -->
  <div class="nav-container page-component">
    <!--左侧导航 #start -->
    <div class="nav left-nav">
      <div class="nav-item">
        <span
          class="v-link clickable dark"
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
      <div class="nav-item selected">
        <span
          class="v-link selected dark"
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
        <div class="title">绑定手机号</div>
        <div class="form-wrapper">
          <div>
            <el-form label-width="110px" label-position="left">
              <el-form-item prop="phone" label="手机号：" class="form-normal">
                <div class="name-input">
                  <el-input
                    v-model="phone"
                    placeholder="请输入手机号"
                    class="input v-input"
                  >
                    <span
                      slot="suffix"
                      class="sendText v-link highlight clickable selected"
                      v-if="!sending"
                      @click="sendCode()"
                      >发送验证码
                    </span>
                    <span slot="suffix" class="sendText v-link" v-if="sending"
                      >{{ second }}s
                    </span>
                  </el-input>
                </div>
              </el-form-item>
              <el-form-item prop="code" label="验证码：">
                <div class="name-input">
                  <el-input
                    v-model="code"
                    placeholder="请输入验证码"
                    class="input v-input"
                  />
                </div>
              </el-form-item>
            </el-form>

            <div class="bottom-wrapper">
              <div class="button-wrapper">
                <div class="v-button" @click="saveBind()">
                  {{ submitBtn }}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 右侧内容 #end -->
  </div>
  <!-- footer -->
</template>

<script>
import "~/assets/css/hospital_personal.css";
import "~/assets/css/hospital.css";
import "~/assets/css/personal.css";

import smsApi from "~/api/sms";
import userInfoApi from "~/api/userInfo";

export default {
  data() {
    return {
      phone: "", //手机号
      code: "", //验证码
      second: 60, //验证码重发时间
      sending: false, //是否正在发送
      submitBtn: "绑定",
      binding: false, //是否正在绑定
    };
  },

  methods: {
    // 获取验证码
    sendCode() {
      //校验手机号
      if (!/^1[3456789]\d{9}$/.test(this.phone)) {
        this.$message.error("手机号码不正确");
        return;
      }

      //开始发送
      this.sending = true;

      //发送验证码
      smsApi
        .sendCode(this.phone)
        .then((response) => {
          this.$message.success(response.message);
          //倒计时
          this.timeDown();
        })
        .catch(() => {
          this.sending = false;
        });
    },

    // 倒计时
    timeDown() {
      let oriSecond = this.second;
      let timer = setInterval(() => {
        --this.second;
        if (this.second < 1) {
          //清除定时器
          clearInterval(timer);
          // 设置可发送
          this.sending = false;
          this.second = oriSecond;
        }
      }, 1000);
    },

    //绑定手机号
    saveBind() {
      if (this.binding) return;
      this.binding = true;
      this.submitBtn = "绑定中...";
      userInfoApi
        .bindPhone(this.phone, this.code)
        .then((response) => {
          this.$message.success(response.message);
          this.$router.push({ path: "/user" });
        })
        .catch(() => {
          this.binding = false;
          this.submitBtn = "绑定";
        });
    },
  },
};
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
.bottom-wrapper {
  width: 100%;
  padding: 0;
  margin-top: 0;
}
</style>
