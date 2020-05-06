<template>
  <div>
    <ToolBar>
      <div>
        <el-button type="primary" size="small" @click="showEditDialog = true">添加商品</el-button>
        <el-button type="primary" size="small" @click="exportTable">本地导出表格</el-button>
      </div>
      <div>
        <el-input
          placeholder="请输入商品名"
          size="small"
          style="width: 140px"
          v-model="searchParams.title"
          clearable
        ></el-input>
        <el-select
          v-model="searchParams.type"
          clearable
          style="width: 140px"
          placeholder="请选择商品类型"
          size="small"
        >
          <el-option
            v-for="item in goodsTypeData"
            :key="item.id"
            :label="item.typename"
            value="item.id"
          ></el-option>
        </el-select>
        <el-button type="success" size="small" @click="refresh()">查询</el-button>
        <el-button type="warning" size="small" @click="clearSearchParams()">重置</el-button>
      </div>
    </ToolBar>//商品列表
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="name" label="商品名"></el-table-column>
      <el-table-column prop="price" label="价格"></el-table-column>
      <el-table-column prop label="图片">
        <template slot-scope="s">
          <el-image style="width: 100px; height: 100px" :src="serverImageUrl+s.row.imgpath"></el-image>
        </template>
      </el-table-column>
      <el-table-column prop lable="状态">
        <template slot-scope="s">
          <div v-if="s.row.state == 1">已下架</div>
          <div v-if="s.row.state == 2">已上架</div>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="240">
        <div slot-scope="s">
          <el-button type="primary" size="small" @click="editItem(s.row.id)">修改</el-button>
          <el-button
            v-if="s.row.state == 1"
            type="success"
            size="small"
            @click="updateState(s.row.id, 2)"
          >上架</el-button>
          <el-button
            v-if="s.row.state == 2"
            type="warning"
            size="small"
            @click="updateState(s.row.id, 1)"
          >下架</el-button>
          <el-button type="danger" size="small" @click="removeItem(s.row)">删除</el-button>
        </div>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      :page-size="pageSize"
      layout="prev, pager, next"
      :total="total"
      @current-change="changePage"
    ></el-pagination>
    <!--    <Pagination-->
    <!--      :params="searchParams"-->
    <!--      :requestFunc="requestFunc"-->
    <!--      ref="pagination"-->
    <!--      @returnData="returnData"-->
    <!--    />-->
    <Edit :showEditDialog="showEditDialog" @close="showEditDialog = false" @success="refresh()" />
  </div>
</template>

<script>
import { goods, updateGoodsState } from "@/api/goodsManage/list";
import { goodsTypeList } from "@/api/goodsTypeManage/goodsType";
import { exportCvsTable } from "@/utils/cvs";
import { resetObject } from "@/utils/common";
import { serverApiUrl } from "@/config/apiUrl";
import Edit from "./Edit.vue";
export default {
  data() {
    return {
      pageSize: 5,
      total: 0,
      pageNo: 1,
      serverImageUrl: serverApiUrl + "/upload/goods/",
      searchParams: {
        title: "",
        type: ""
      },
      showEditDialog: false,
      tableData: [],
      goodsTypeData: [],
      id: null
    };
  },
  created() {
    this.initData();
  },
  methods: {
    changePage(val) {
      this.pageNo = val;
      this.initData();
    },
    initData() {
      goods({
        //获取商品列表
        name: this.searchParams.title,
        typeid: this.searchParams.type,
        pageNo: this.pageNo,
        pageSize: this.pageSize
      })
        .then(r => {
          this.tableData = r.list;
          this.total = r.count;
        })
        .catch(() => {});

      goodsTypeList()
        .then(r => {
          //获取商品类型列表
          this.goodsTypeData = r;
        })
        .catch(() => {});
    },
    editItem(id) {
      this.id = id;
      this.showEditDialog = true;
    },
    routeDemo() {
      this.$message.info("待添加");
    },
    exportTable() {
      exportCvsTable(
        [
          { title: "文章标题", field: "title" },
          { title: "浏览量", field: "visit_count" }
        ],
        this.tableData,
        "文章列表"
      );
    },
    refresh() {
      this.initData();
    },
    returnData(pageList) {
      this.tableData = pageList.list;
    },
    clearSearchParams() {
      resetObject(this.searchParams);
      this.refresh();
    },
    updateState(id, newstate) {
      if (newstate == 0) {
        this.$confirm("确定删除?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        })
          .then(() => {
            this.updateStateApi(id, newstate);
          })
          .catch(() => {});
      } else {
        this.updateStateApi(id, newstate);
      }
    },
    updateStateApi(id, newstate) {
      updateGoodsState({
        id: id,
        state: newstate
      })
        .then(r => {
          this.$message({
            type: "success",
            message: r.msg
          });
          this.refresh();
        })
        .catch(() => {});
    }
  },
  components: { Edit }
};
</script>
