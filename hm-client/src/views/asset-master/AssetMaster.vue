<template>
  <el-main>
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>マスタ選択</span>
      </div>
      <el-select filterable placeholder="Select" v-model="selectedAssetApiList">
        <el-option
          v-for="item in options.assetApiList"
          :key="item.id"
          :label="item.name"
          :value="item.api_cd"
        >{{item.name}}</el-option>
      </el-select>
    </el-card>
    <div v-show="selectedAssetApiList==='AST_01'">
      <BudgetCategoryList />
    </div>
  </el-main>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios";
import BudgetCategoryList from "./BudgetCategoryList";
import common from "@/js/common/common.js";

//TODO enumで読み込み？
const API_PATH_AST_90 = "http://localhost:8080/api/ast/asset-api-list";

export default {
  name: "AssetMaster",
  mixins:[common],
  components: {
    BudgetCategoryList
  },
  data() {
    return {
      options: {
        assetApiList: []
      },
      selectedAssetApiList: "AST_01"
    };
  },
  created: async function() {
    await this.refresh();
  },
  mounted: function() {},
  methods: {
    refresh: async function() {
      var that = this;

      //GET
      that.getFromApi();
      //画面に初期値をセット
      that.display();
    },
    getFromApi:function(){
      var that = this;
      //GETの実行
      axios
        .get(API_PATH_AST_90)
        .then(function(res) {
          that.options.assetApiList = res.data.assetApiLists;
        })
        .catch(function(err) {
          console.log("ERROR");
          console.log(err);
        });
    },
    display: function() {

    },
    onClickRegist: function() {
      // var request = {
      //   test1: "aaa",
      //   test2: "bbb"
      // };
      console.log("regist");
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
};
</script>

<style scoped>
</style>