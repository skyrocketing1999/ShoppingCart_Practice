<template>
  <el-dialog
    @opened="openDialog"
    :width="dialogWidth"
    :title="title"
    :visible.sync="showEditDialog"
    :show-close="false"
    :close-on-click-modal="false"
  >
    <el-form
      :model="forms"
      :rules="rules"
      ref="editForms"
      class="edit-forms"
      label-position="left"
      :label-width="labelWidth"
    >
      <el-form-item label="商品名称" prop="name">
        <el-input v-model="forms.name"></el-input>
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input v-model="forms.price" placeholder="最多2位小数"></el-input>
      </el-form-item>
      <el-form-item label="描述" prop="goodsdesc">
        <el-input type="textarea" v-model="forms.goodsdesc"></el-input>
      </el-form-item>
      <el-form-item label="商品类型" prop="typeid">
        <el-select v-model="forms.typeid" placeholder="请选择商品类型">
          <el-option
            v-for="item in goodsTypeData"
            :key="item.id"
            :label="item.typename"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="图片" prop="imgpath">
        <el-upload
          name="picture"
          class="avatar-uploader"
          :action="serverApiUrl + '/upload/uploadGoodsImg'"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
        >
          <img v-if="forms.url" :src="forms.url" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="$emit('close')">取消</el-button>
      <el-button type="primary" @click="submit">确认</el-button>
    </div>
  </el-dialog>
</template>

<script>
import {
  Required,
  Float2,
  Boolean,
  FillerFieldRules
} from "@/utils/validateRules";
import { serverApiUrl } from "@/config/apiUrl";
import { fillerLeft, resetObject } from "@/utils/common";
import { goodsTypeList } from "@/api/goodsTypeManage/goodsType";
import { saveGoods, getGoods } from "@/api/goodsManage/list";
export default {
  props: {
    title: {
      type: String,
      default: "编辑"
    },
    dialogWidth: {
      type: String,
      default: "700px"
    },
    labelWidth: {
      type: String,
      default: "120px"
    },
    showEditDialog: Boolean
  },
  data() {
    return {
      forms: {
        name: "",
        goodsdesc: "",
        price: "",
        url: "",
        typeid: "",
        imgpath: ""
      },
      rules: {
        ...FillerFieldRules(["name", "desc"], Required),
        price: [Required, Float2],
        typeid: Boolean
      },
      serverApiUrl: serverApiUrl,
      goodsTypeData: []
    };
  },
  created() {
    this.initData();
  },
  methods: {
    initData() {
      goodsTypeList()
        .then(r => {
          this.goodsTypeData = r;
        })
        .catch(() => {});
    },
    submit() {
      this.$refs.editForms.validate(valid => {
        if (valid) {
          this.$message({
            message: "字段验证通过，提交请求，成功后刷新分页！",
            type: "success"
          });
          saveGoods(this.forms)
            .then(r => {
              this.$message({
                message: r.msg,
                type: "success"
              });
              // this.$emit("success");
              this.$parent.refresh();
              this.$parent.showEditDialog = false;
            })
            .catch(() => {});
        } else {
          this.$message({
            message: "请按照提示正确填写内容！",
            type: "warning"
          });
          return false;
        }
      });
    },
    openDialog() {
      if (this.$parent.id != null) {
        getGoods({ id: this.$parent.id })
          .then(r => {
            //根据ID获取商品信息
            this.FillerFormField(this.$parent.id, r);
            this.forms.url = this.$parent.serverImageUrl + r.imgpath;
            this.$parent.id = null;
          })
          .catch(() => {});
      } else {
        resetObject(this.forms);
        this.$set(this.forms, "id", null);
        this.$refs.editForms.resetFields();
      }
    },
    FillerFormField(id, data) {
      //可以外部填充回写做编辑用，也可以请求详情接口填充表单
      this.$set(this.forms, "id", id);
      fillerLeft(this.forms, data);
    },
    handleAvatarSuccess(res, file) {
      console.log(res);
      console.log(file);
      this.$message({
        type: "info",
        message: "图片上传成功",
        duration: 6000
      });
      if (file.response.status == "success") {
        this.forms.imgpath = file.response.msg;
        this.forms.url = URL.createObjectURL(file.raw);
      }
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isGIF = file.type === "image/gif";
      const isPNG = file.type === "image/png";
      const isBMP = file.type === "image/bmp";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isGIF && !isPNG && !isBMP) {
        this.$message.error("上传头像图片不能是" + file.type + "格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return (isJPG || isGIF || isPNG || isBMP) && isLt2M;
    }
  }
};
</script>
<style lang="scss">
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
