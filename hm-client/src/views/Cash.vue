<template>
  <div class="row">
    <div class="row">
      <span>サマリー</span>
    </div>
    <div class="row">
        
    </div>
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
        const res = await axios.get("http://localhost:8080/cash");
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