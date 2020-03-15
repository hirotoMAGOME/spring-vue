<template>
  <div class="row">
    <div class="card col-4">
      <div class="card-header">現金</div>
      <div class="card-body">
        <h5 class="card-title">口座管理</h5>
        <p
          class="card-text"
        >Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
    <div class="card col-4">
      <div class="card-header">銀行口座</div>
      <div class="card-body">
        <h5 class="card-title">口座管理</h5>
        <p
          class="card-text"
        >Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
        <div class="card col-4">
      <div class="card-header">仮想通貨口座</div>
      <div class="card-body">
        <h5 class="card-title">口座管理</h5>
        <p class="card-text" >
          Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
        <div class="card col-4">
      <div class="card-header">仮想通貨口座</div>
      <div class="card-body">
        <h5 class="card-title">口座管理</h5>
        <p class="card-text" >
          Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
        <div class="card col-4">
      <div class="card-header">FX口座</div>
      <div class="card-body">
        <h5 class="card-title">口座管理</h5>
        <p class="card-text" >
          Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
    <ul class="nav nav-tabs">
      <li class="nav-item" v-for="(value,key) in accounts" :key="key">
        <a
          class="nav-link"
          role="tab"
          data-toggle="tab"
          v-bind:href="'#account-tab-' + value.code"
        >{{value.name}}</a>
      </li>
    </ul>
    <!---->
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
  name: "Asset",
  data() {
    return {
      accounts: []
    };
  },
  created: async function() {
    await this.refresh();
  },
  methods: {
    refresh: async function() {
      const res = await axios.get("http://localhost:8080/account");
      //const res = await axios.get('/')
      this.accounts = res.data.accounts;
      console.log(res);
      console.info(this.accounts);
    }
  },
  mounted: function() {}
};
</script>

<style scoped>
</style>