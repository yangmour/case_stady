<template>
  <div class="app-container">
    <!--医院设置表单-->
    <el-form label-width="100px" :rules="rules" :model="hospset" ref="hospset">
      <el-form-item label="医院名称">
        <el-input v-model="hospset.hosname" />
      </el-form-item>
      <el-form-item label="医院编号">
        <el-input v-model="hospset.hoscode" />
      </el-form-item>
      <el-form-item label="api地址">
        <el-input v-model="hospset.apiUrl" />
      </el-form-item>
      <el-form-item label="联系人">
        <el-input v-model="hospset.contactsName" />
      </el-form-item>
      <el-form-item label="电话" prop="contactsPhone">
        <el-input v-model="hospset.contactsPhone" maxlength="11" />
      </el-form-item>
      <el-form-item>
        <el-button
          :disabled="saveBtnDisabled"
          type="primary"
          @click="saveOrUpdate"
          >保存</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import hospsetApi from "@/api/syt/hospset";

export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (!/^1(3|4|5|6|7|8|9)\d{9}$/.test(value)) {
        callback(new Error("手机号有误"));
      } else {
        callback();
      }
    };
    return {
      saveBtnDisabled: false,
      hospset: {},
      rules: {
        contactsPhone: [
          { required: true, message: "请输入手机号", trigger: "blur" },
          { min: 11, max: 11, message: "长度在 11 个字符", trigger: "blur" },
          { validator: validatePass, trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    saveOrUpdate() {
      this.$refs["hospset"].validate((valid) => {
        if (valid) {
          if (!this.hospset.id) {
            hospsetApi.save(this.hospset).then((resp) => {
              this.$message.success(resp.message);
            });
          } else {
            hospsetApi.update(this.hospset).then((resp) => {
              this.$message.success(resp.message);
            });
          }
          //路由跳转
          this.$router.push({ path: "/syt/hospset/list" });
        } else {
          this.$message.error("表单有误!");
          return false;
        }
      });
    },
  },
  created() {
    if (this.$route.params.id) {
      hospsetApi.edit(this.$route.params.id).then((resp) => {
        this.hospset = resp.data;
      });
    }
  },
};
</script>