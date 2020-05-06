<!-- 商品首页 -->
<template>
  <div>
    <div class="line"></div>
    <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#1a472a"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="1" @click="cur = 0" :class="{ active: cur==0 }">商品首页</el-menu-item>
      <el-submenu index="2">
        <template slot="title">商品类型</template>
        <el-menu-item
          v-for="item in goodsTypeData"
          :key="'2' + item.id"
          :label="item.typename"
          value="item.id"
        >{{ item.typename }}</el-menu-item>
      </el-submenu>
      <el-menu-item index="3" @click.native="$router.push({name: 'Cart'})">购物车</el-menu-item>
      <el-menu-item index="4">联系我们</el-menu-item>
      <el-menu-item index="5">关于我们</el-menu-item>
      <el-menu-item index="6">
        <a href="#" target="_blank">商家登录</a>
      </el-menu-item>
    </el-menu>
    <!-- 轮播图 -->
    <div class="box" v-show="cur == 0">
      <el-carousel height="450px">
        <el-carousel-item v-for="item in carouselList" :key="item.id">
          <h1 class="small">{{ item.cardsec }}</h1>
          <el-image
            style="width: 790px; height:340px"
            :src="serverImageUrl + 'carousel/' + item.imgpath"
          ></el-image>
        </el-carousel-item>
      </el-carousel>
    </div>
    <!-- 商品列表 ，每一列显示3个 -->
    <div class="goodsLists" v-show="cur == 0">
      <el-row :gutter="20">
        <el-col :span="8" v-for="item in goodsList" :key="item.id">
          <div class="item">
            <el-image
              style="width: 350px; height: 350px;"
              :src="serverImageUrl + 'goods/' + item.imgpath"
            ></el-image>
            <h3>{{ item.name }}</h3>
            <p>{{ item.goodsdesc }}</p>
          </div>
        </el-col>
      </el-row>
    </div>
    <Cart v-show="cur == 1" />
  </div>
</template>

<script>
import { carouselList } from "@/api/carouselManage/carousel";
import { goods } from "@/api/goodsManage/list";
import { serverApiUrl } from "@/config/apiUrl";
import { goodsTypeList } from "@/api/goodsTypeManage/goodsType";
import Cart from "./Cart.vue";
export default {
  data() {
    return {
      serverImageUrl: serverApiUrl + "/upload/",
      activeIndex2: "1",
      //轮播图
      carouselList: [],
      // 商品信息
      goodsList: [],
      pageNo: 1,
      pageSize: 9,
      cur: 0
    };
  },
  created() {
    this.initData();
  },
  methods: {
    initData() {
      carouselList()
        .then(r => {
          this.carouselList = r;
        })
        .catch(() => {});
      goods({
        pageNo: this.pageNo,
        pageSize: this.pageSize
      })
        .then(r => {
          this.goodsList = r.list;
        })
        .catch(() => {});
      goodsTypeList()
        .then(r => {
          //获取商品类型列表
          this.goodsTypeData = r;
        })
        .catch(() => {});
    }
  },
  components: { Cart }
};
</script>

<style lang="scss">
.box {
  text-align: center;
  padding: 30px;
  background: #3b734f;
}
.goodsLists {
  margin: 30px 10px;
  text-align: center;
}
.box h1 {
  color: #ffffff;
  margin-bottom: 20px;
}
.item {
  height: 500px;
}
</style>
