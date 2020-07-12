<template>
  <div class="row">
    <div class="row">
      <span>aaaaa</span>
    </div>
    <!-- <div class="card col-12">
      <div class="card-header">実績入力</div>
      <div class="card-body">
        <h5 class="card-title">口座管理</h5>
        <p class="card-text">決済日</p>
        <p>予算ID</p>
        <p>口座ID</p>
        <p>実績名</p>
        <p>金額</p>
        <a href="/asset/cash/" class="btn btn-primary">登録</a>
      </div>
    </div>
    <div class="card col-12">
      <div class="card-header">実績入力</div>
      <div class="card-body">
        <p class="card-text">予算</p>
        <p>
          口座
          <select v-model="actual.account">
            <option value="abc">ABC</option>
            <option value="222">222</option>
          </select>
        </p>
        <p>
          実績名
          <input v-model="actual.name" placeholder="edit me" />
        </p>
        <p>
          金額
          <input v-model="actual.price" placeholder="edit me" />
        </p>
        <a class="btn btn-primary" @click="onClickRegist">登録</a>
      </div>
    </div> -->
  </div>
  <!-- <el-row>
    <el-col :span="24">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>asset一覧</span>
        </div>
        <el-table :data="currencies" style="width: 100%">
          <el-table-column prop="id" label="通貨ID" width="300" />
          <el-table-column prop="name" label="通貨名" width="300" />
          <el-table-column prop="symbol" label="通貨単位" width="300" />
          <el-table-column prop="amount" label="数量" width="300" />
        </el-table>
      </el-card>
    </el-col>
  </el-row>-->
</template>
<script>
/* eslint-disable no-console */

import axios from "axios";

export default {
  name: "PersonalMasterSetting",
  // data() {
  //   return {
  //     accounts: []
  //   };
  // },
  data() {
    return {

    };
  },
  created: async function() {
    await this.refresh();
  },
  methods: {
    refresh: async function() {
      // const url = "http://localhost:8080/cash";
      // const res = await axios.get(url);
      console.log("Aaa");
      const url = "http://localhost:8080/api/budget-category";
      // const res = url;
      
      axios.get(url)
        .then(function (res){
          console.log("success");
          console.log(res);
        })
        .catch(function (err){
          console.log("ERROR");
          console.log(err);
        })

      // this.display(res);

    },
    display: function(res){
      this.budgets = res.data.budgets;
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