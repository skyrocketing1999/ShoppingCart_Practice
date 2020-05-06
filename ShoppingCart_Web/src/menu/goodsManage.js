export default {
  name: "商品管理",
  permissionsKey: "",
  icon: "fa fa-envelope-open",
  children: {
    courseCardList: {
      name: "商品列表",
      permissionsKey: "",
      path: "/goods_manage/list"
    },
    organCardList: {
      name: "商品分类",
      permissionsKey: "",
      path: "/goods_manage/category"
    }
  }
};
