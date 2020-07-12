<template>
  <el-main>
    aaaaaaaaaaaaaaaa
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>個人マスタ選択{{options.budgetCategories}}</span>
      </div>
      <el-select filterable placeholder="Select">
        <el-option
          v-for="item in options.budgetCategories"
          :key="item.id"
          :label="item.name"
          :value="item.id"
        >{{item.name}}</el-option>
      </el-select>
    </el-card>

    <el-card class="box-card" shadow="always">
      <div slot="header" class="clearfix">
        <span>〇〇一覧</span>
      </div>
    </el-card>
  </el-main>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios";

export default {
  name: "PersonalMasterSetting",
  data() {
    return {
      options: {
        budgetCategories: []
      }
    };
  },
  created: async function() {
    await this.refresh();
  },
  methods: {
    refresh: async function() {
      var that = this;

      const url = "http://localhost:8080/api/budget-category";
      await axios
        .get(url)
        .then(function(res) {
          that.display(res);
        })
        .catch(function(err) {
          console.log("ERROR");
          console.log(err);
        });
    },
    display: function(res) {
      console.log("display!!");
      console.log(res.data.budgetCategories);
      this.data.options.budgetCategories = res.data.budgetCategories;
    },
    onClickRegist: function() {
      const url = "http://localhost:8080/cash";
      var request = {
        test1: "aaa",
        test2: "bbb"
      };
      console.log("regist");
      axios
        .post(url, request)
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
  },
  mounted: function() {}
};
</script>

<style scoped>
</style>