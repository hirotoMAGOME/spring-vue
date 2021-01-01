<template>
  <el-main>
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>summary1</span>
      </div>
    </el-card>
    <ActualSummary />
    <!-- <div v-show="selectedAssetApiList === 'AST_01'">
      <BudgetCategoryList />
    </div>
    <div v-show="selectedAssetApiList === 'AST_02'">
      <BudgetList />
    </div>
    <div v-show="selectedAssetApiList === 'AST_03'">
      <AccountCategoryList />
    </div>
    <div v-show="selectedAssetApiList === 'AST_04'">
      <AccountList />
    </div> -->
  </el-main>
</template>
<script>
/* eslint-disable no-console */

// import axios from "axios"
import ActualSummary from "./ActualSummary"
// import BudgetCategoryList from "./BudgetCategoryList"
// import BudgetList from "./BudgetList"
// import AccountCategoryList from "./AccountCategoryList"
// import AccountList from "./AccountList"
import common from "@/js/common/common.js"

//TODO enumで読み込み？
// const API_PATH_AST_90 = "http://localhost:8080/api/ast/asset-api-list"

export default {
  name: "AssetSummary",
  mixins: [common],
  components: {
    ActualSummary
    // BudgetCategoryList,
    // BudgetList,
    // AccountCategoryList,
    // AccountList
  },
  data() {
    return {
      options: {}
    }
  },
  created: async function() {
    await this.refresh()
  },
  mounted: function() {},
  methods: {
    refresh: async function() {
      // var that = this
      // //GET
      // that.getFromApi()
      // //画面に初期値をセット
      // that.display()
    },
    getFromApi: function() {
      // var that = this
      //GETの実行
      // axios
      //   .get(API_PATH_AST_90)
      //   .then(function(res) {
      //     that.options.assetApiList = res.data.assetApiLists
      //   })
      //   .catch(function(err) {
      //     console.log("ERROR")
      //     console.log(err)
      //   })
    },
    display: function() {},
    onClickRegistAPI: function() {
      // var request = {
      //   test1: "aaa",
      //   test2: "bbb"
      // };
      // axios
      //   .post(API_PATH_AST_01, request)
      //   .then(function(response) {
      //     console.log("ok");
      //     console.log(response);
      //   })
      //   .catch(function(error) {
      //     console.log("NG");
      //     console.log(error);
      //   });
      // console.log("regist2");
    }
  }
}
</script>

<style scoped></style>
