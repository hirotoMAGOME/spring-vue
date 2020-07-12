<template>
  <el-main>
    aaaaaaaaaaaaaaaa
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>個人マスタ選択</span>
      </div>
      <div>
        <p>aaaaa</p>
        <p>bbbbbb</p>
      </div>
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
  // data() {
  //   return {
  //     accounts: []
  //   };
  // },
  data() {
    return {};
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
      const res = await axios.get(url);
      console.log(res);
      // axios
      //   .get(url)
      //   .then(function(res) {
      //     console.log("success");
      //     console.log(res);
      //   })
      //   .catch(function(err) {
      //     console.log("ERROR");
      //     console.log(err);
      //   });

      // this.display(res);
    },
    display: function(res) {
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