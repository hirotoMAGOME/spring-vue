<template>
  <el-main>
    <!-- <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>メニュー</span>
      </div>
      <el-select filterable placeholder="Select" v-model="selectedAssetApiList">
        <el-option
          v-for="item in options.assetApiList"
          :key="item.id"
          :label="item.name"
          :value="item.api_cd"
          >{{ item.name }}</el-option
        >
      </el-select>
    </el-card> -->
    <BudgetActualManagement />
    <AccountBalance />
  </el-main>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios"
import BudgetActualManagement from "./BudgetActualManagement"
import AccountBalance from "./AccountBalance"
import common from "@/js/common/common.js"

const API_PATH_BAL_01 = "http://localhost:8080/api/ast/account-balance"

export default {
  name: "CostPerformance",
  mixins: [common],
  components: {
    AccountBalance,
    BudgetActualManagement
  },
  data() {
    return {
      options: {
        budgetCategories: [], //未使用
        budgetCategoryType: [] //未使用
      },
      dialogFormVisible: false, //モーダルの表示状態//未使用
      form: {
        id: null, //未使用
        name: null, //未使用
        budgetCategoryType: false //未使用
      }
    }
  },
  created: function() {
    var that = this
    //GET
    that.getFromApi()

    //GET(種別)
    // that
    //   .getClsType("budget_category_type", true)
    //   .then(that.setClsType, that.setClsTypeErr)

    //初期値をセット
    that.display()
  },
  mounted: function() {},
  methods: {
    getFromApi: function() {
      var that = this

      return new Promise(function(resolve, reject) {
        //GETの実行
        axios
          .get(API_PATH_BAL_01)
          .then(function(res) {
            that.$set(that.options, "accounts", res.data.accounts)
            resolve()
          })
          .catch(function(err) {
            console.log("ERROR")
            console.log(err)
            reject()
          })
      })
    },
    setClsType: function(data) {
      var that = this
      that.options.budgetCategoryType = data.budgetCategoryType
    },
    setClsTypeErr: function(data) {
      console.log(data)
    },
    display: function() {},
    onClickEdit: function(selectedId) {
      //モーダルに値をセット
      if (selectedId === 0) {
        this.form = {
          id: null,
          name: null,
          budgetCategoryType: null
        }
      } else {
        var getData = this.options.budgetCategories.find(
          v => v.id === selectedId
        )

        this.form = {
          id: getData.id,
          name: getData.name,
          budgetCategoryType: getData.budgetCategoryType
        }
      }

      //モーダルを開く
      // this.dialogFormVisible = true;
    },
    onClickRegistAPI: function() {
      console.log("onClickRegistAPI method実行")
      var request = {
        id: this.form.id,
        name: this.form.name,
        budgetCategoryType: this.form.budgetCategoryType
      }

      axios
        .patch(API_PATH_BAL_01, request)
        .then(function(response) {
          console.log("ok")
          console.log(response)
        })
        .catch(function(error) {
          console.log("NG")
          console.log(error)
        })
    },
    onClickDelete: function(selectedId) {
      // var params = { id: selectedId }
      //DELETEの実行
      axios
        .delete(API_PATH_BAL_01 + "/" + selectedId)
        .then(function(response) {
          console.log("ok")
          console.log(response)
        })
        .catch(function(error) {
          console.log("ERROR")
          console.log(error)
        })
    }
  }
}
</script>

<style scoped></style>
