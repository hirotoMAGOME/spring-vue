<template>
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>予算カテゴリ一覧</span>
      </div>
    </el-card>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios";

const API_PATH_AST_01 = "http://localhost:8080/api/ast/budget-category";

export default {
  name: "PersonalMasterSetting",
  data() {
    return {
      options: {
        budgetCategories: []
      },

    };
  },
  created: function() {
    this.refresh();
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
        .get(API_PATH_AST_01)
        .then(function(res) {
          that.options.assetApiList = res.data.assetApiLists;
        })
        .catch(function(err) {
          console.log("ERROR");
          console.log(err);
        });
    },
    display: function() {
      debugger;

    }
    // onClickRegist: function() {

    //   var request = {
    //     test1: "aaa",
    //     test2: "bbb"
    //   };
    //   console.log("regist");
    //   axios
    //     .post(API_PATH_AST_01, request)
    //     .then(function(response) {
    //       console.log("ok");
    //       console.log(response);
    //     })
    //     .catch(function(error) {
    //       console.log("NG");
    //       console.log(error);
    //     });
    //   console.log("regist2");
    // }
  }
};
</script>

<style scoped>
</style>