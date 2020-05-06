<template>
  <div class="cartList" v-show="cur == 1">
    <el-table
      ref="multipleTable"
      :data="cartTableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="selected"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop label="图片">
        <template slot-scope="s">
          <el-image
            style="width: 100px; height: 100px"
            :src="serverImageUrl + 'goods/' + s.row.goods.imgpath"
          ></el-image>
        </template>
      </el-table-column>
      <el-table-column prop="goods.name" label="商品名"></el-table-column>
      <el-table-column prop="goods.price" label="价格"></el-table-column>
      <el-table-column label="数量" width="200">
        <template slot-scope="s">
          <div>
            <el-input v-model="s.row.num" @change="handleInput(s.row)">
              <el-button slot="prepend" @click="del(s.row)">
                <i class="el-icon-minus"></i>
              </el-button>
              <el-button slot="append" @click="add(s.row)">
                <i class="el-icon-plus"></i>
              </el-button>
            </el-input>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="小计" width="150" prop="goodsTotal"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="s">
          <el-button type="danger" @click="handleDelete(s.$index)">
            删除
            <i class="el-icon-delete2 el-icon--right"></i>
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-button type="info" style="margin-top: 20px">{{ "商品总额：" + moneyTotal }}</el-button>
    <div style="margin-top: 20px">
      <el-button @click="toggleSelection()">取消选择</el-button>
    </div>
  </div>
</template>

<script>
import { serverApiUrl } from "@/config/apiUrl";
import { cartList } from "@/api/cartManage/cart";

export default {
  data() {
    return {
      serverImageUrl: serverApiUrl + "/upload/",
      goodsTypeData: [],
      cur: 0,
      multipleSelection: [],
      cartTableData: [],
      moneyTotal: 0
    };
  },
  created() {
    this.initData();
  },
  methods: {
    initData() {
      cartList({
        userId: 1
      })
        .then(r => {
          //获取购物车列表
          this.cartTableData = r;
          for (var i = 0; i < this.cartTableData.length; i++) {
            this.cartTableData[i].goodsTotal =
              this.cartTableData[i].goods.price * this.cartTableData[i].num;
          }
        })
        .catch(() => {});
    },
    handleDelete(index) {
      this.$confirm("确定删除该商品？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.cartTableData.splice(index, 1);
          this.$message({ type: "success", message: "删除成功!" });
        })
        .catch(() => {
          this.$message({ type: "info", message: "已取消删除" });
        });
    },
    handleInput(value) {
      if (null == value.num || value.num == "" || value.num == 0) {
        value.num = 1;
      }
      value.goodsTotal = (value.num * value.goods.price).toFixed(2);
      //保留两位小数 //增加商品数量也需要重新计算商品总价
      this.selected(this.multipleSelection);
    },
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    add(addGood) {
      //输入框输入值变化时会变为字符串格式返回到js
      //此处要用v-model，实现双向数据绑定
      if (typeof addGood.num == "string") {
        addGood.num = parseInt(addGood.num);
      }
      addGood.num += 1;
    },
    del(delGood) {
      if (typeof delGood.num == "string") {
        delGood.num = parseInt(delGood.num);
      }
      if (delGood.num > 1) {
        delGood.num -= 1;
      }
    },
    //返回的参数为选中行对应的对象
    selected(selection) {
      this.multipleSelection = selection;
      this.moneyTotal = 0;
      //此处不支持forEach循环，只能用原始方法了
      for (var i = 0; i < selection.length; i++) {
        //判断返回的值是否是字符串
        if (typeof selection[i].goodsTotal == "string") {
          selection[i].goodsTotal = parseInt(selection[i].goodsTotal);
        }
        this.moneyTotal += selection[i].goodsTotal;
      }
    }
  }
};
</script>
