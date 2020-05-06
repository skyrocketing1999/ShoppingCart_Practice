import Layout from "@/views/layout/App.vue";
export default {
  path: "/goods_manage",
  component: Layout,
  name: "GoodsManage",
  redirect: "/goods_manage/list",
  meta: {
    title: "商品管理"
  },
  children: [
    {
      path: "list",
      name: "GoodsManageList",
      meta: {
        title: "商品列表"
      },
      component: resolve =>
        require(["@/views/goodsManage/goodsList/Index.vue"], resolve)
    }
  ]
};
