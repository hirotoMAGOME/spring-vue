<template>
  <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
    <div slot="header" class="clearfix">
      <span>予算カテゴリ一覧</span>
    </div>
    <template>
      <el-row>
        <el-button type="info" round @click="dialogFormVisible = true">追加</el-button>
      </el-row>
      <el-table :data="options.budgetCategories" border style="width: 100%">
        <el-table-column prop="id" label="ID" width="180"></el-table-column>
        <el-table-column prop="name" label="予算カテゴリ名" width="180"></el-table-column>
        <el-table-column label="編集" width="180"></el-table-column>
        <el-table-column label="削除" width="180"></el-table-column>
      </el-table>
    </template>
    <el-dialog title="新規登録" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <!-- <el-form-item label="Promotion name" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Zones" :label-width="formLabelWidth">
          <el-select v-model="form.region" placeholder="Please select a zone">
            <el-option label="Zone No.1" value="shanghai"></el-option>
            <el-option label="Zone No.2" value="beijing"></el-option>
          </el-select>
        </el-form-item>-->
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="dialogFormVisible = false;onClickRegist()">Confirm</el-button>
      </span>
    </el-dialog>
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
      dialogFormVisible: false,
      form: {}
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
    getFromApi: function() {
      var that = this;
      //GETの実行
      axios
        .get(API_PATH_AST_01)
        .then(function(res) {
          that.options.budgetCategories = res.data.budgetCategories;
        })
        .catch(function(err) {
          console.log("ERROR");
          console.log(err);
        });
    },
    display: function() {},
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
    onClickRegist: function() {
      console.log("onClickRegist method実行");
      var request = {
        test1: "aaa",
        test2: "bbb"
      };

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
    }
  }
};
</script>

<style scoped>
</style>