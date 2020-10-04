<template>
  <el-main>
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
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
    </el-card>
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>予実管理</span>
      </div>
      <el-row>
        <el-button
          type="info"
          round
          @click="
            onClickEdit(0)
            dialogFormVisible = true
          "
          >追加</el-button
        >
      </el-row>
      <el-table :data="options.budgetCategories" border style="width: 100%">
        <el-table-column prop="id" label="ID" width="180"></el-table-column>
        <el-table-column
          prop="name"
          label="予算カテゴリ名"
          width="180"
        ></el-table-column>
        <el-table-column label="編集" width="180">
          <template slot-scope="scope">
            <el-button
              type="info"
              round
              @click="
                onClickEdit(scope.row.id)
                dialogFormVisible = true
              "
              >編集</el-button
            >
          </template>
        </el-table-column>
        <el-table-column label="削除" width="180">
          <template slot-scope="scope">
            <el-button type="info" round @click="onClickDelete(scope.row.id)"
              >削除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <el-dialog title="新規登録" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form ref="form" :model="form" label-width="200px" size="medium">
            <el-form-item label="ID">{{ form.id }}</el-form-item>
            <el-form-item label="予算カテゴリ名">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="固定費/変動費">
              <el-radio-group v-model="form.budgetCategoryType">
                <el-radio
                  v-for="v in options.budgetCategoryType"
                  :key="v.clsTypeKey"
                  :label="v.clsTypeKey"
                  >{{ v.name }}</el-radio
                >
              </el-radio-group>
            </el-form-item>
          </el-form>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">Cancel</el-button>
          <el-button
            type="primary"
            @click="
              dialogFormVisible = false
              onClickRegist()
            "
            >Confirm</el-button
          >
        </span>
      </el-dialog>
    </el-card>
    <AccountBalance />
  </el-main>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios"
import AccountBalance from "./AccountBalance"
import common from "@/js/common/common.js"

const API_PATH_BAL_01 = "http://localhost:8080/api/ast/account-balance"

export default {
  name: "CostPerformance",
  mixins: [common],
  components: {
    AccountBalance
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
    onClickRegist: function() {
      console.log("onClickRegist method実行")
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
