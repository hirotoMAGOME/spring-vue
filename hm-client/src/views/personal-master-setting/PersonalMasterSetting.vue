<template>
  <el-main>
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>個人マスタ選択</span>
      </div>
      <el-select filterable placeholder="Select" v-model="selectedBudgetCategories">
        <el-option
          v-for="item in options.budgetCategory"
          :key="item.id"
          :label="item.name"
          :value="item.id"
        >{{item.name}}</el-option>
      </el-select>
    </el-card>
    <BudgetCategoryList />
  </el-main>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios";
import BudgetCategoryList from "./BudgetCategoryList";

//TODO enumで読み込み？
const API_PATH_AST_01 = "http://localhost:8080/api/ast/budget-category";
const API_PATH_AST_90 = "http://localhost:8080/api/ast/asset-api-list";

export default {
  name: "PersonalMasterSetting",
  components: {
    BudgetCategoryList
  },
  data() {
    return {
      options: {
        budgetCategories: [],
        assetApiList: []
      },
      selectedBudgetCategories: null
    };
  },
  created: async function() {
    await this.refresh();
  },
  mounted: function() {},
  methods: {
    refresh: async function() {
      var that = this;

      //GETの実行
      await axios
        .get(API_PATH_AST_90)
        .then(function(res) {
          that.options.assetApiList = res.data.assetApiLists;
        })
        .catch(function(err) {
          console.log("ERROR");
          console.log(err);
        });

      await axios
        .get(API_PATH_AST_01)
        .then(function(res) {
          that.options.budgetCategory = res.data.budgetCategories;
        })
        .catch(function(err) {
          console.log("ERROR");
          console.log(err);
        });

      //画面に初期値をセット
      that.display();
    },
    display: function() {
      debugger;

      // this.options.budgetCategories = res.data.budgetCategories;
      // this.options.assetApiList = res.data.assetApiList;
    },
    onClickRegist: function() {
      var request = {
        test1: "aaa",
        test2: "bbb"
      };
      console.log("regist");
      axios
        .post(API_PATH_AST_01, request)
        .then(function(response) {
          console.log("ok");
          console.log(response);
        })
        .catch(function(error) {
          console.log("NG");
          console.log(error);
        });
      console.log("regist2");
    }
  }
};
</script>

<style scoped>
</style>