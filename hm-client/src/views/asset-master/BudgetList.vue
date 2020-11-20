<template>
  <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
    <div slot="header" class="clearfix">
      <span>予算一覧</span>
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
      >予算カテゴリ：
      <el-select
        filterable
        placeholder="Select"
        v-model="selectedBudgetCategory"
      >
        <el-option
          v-for="item in options.budgetCategories"
          :key="item.id"
          :label="item.name"
          :value="item.id"
          >{{ item.name }}</el-option
        >
      </el-select>
      <el-button type="info" round @click="onClickBudgetFix()"
        >予算の確定</el-button
      >
    </el-row>
    <div class="balloon2">
      <p>TODO 削除機能はとりあえず物理削除。</p>
      <p>
        論理削除や非表示フラグなどはあってもいいかも。月末しか変更できないようにとか。
      </p>
    </div>
    <el-table :data="options.budgets" border style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column
        prop="budgetCategoryId"
        label="予算カテゴリ名"
        width="180"
      ></el-table-column>
      <el-table-column prop="name" label="予算名" width="180"></el-table-column>
      <el-table-column prop="amount" label="予算" width="180"></el-table-column>
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
          <el-form-item label="予算カテゴリ">
            <el-select
              filterable
              placeholder="Select"
              v-model="form.budgetCategoryId"
            >
              <el-option
                v-for="item in options.budgetCategories"
                :key="item.id"
                :label="item.name"
                :value="item.id"
                >{{ item.name }}</el-option
              >
            </el-select>
          </el-form-item>
          <el-form-item label="予算名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="予算">
            <el-input v-model="form.amount"></el-input>
          </el-form-item>

          <!-- <el-form-item label="固定費/変動費">
            <el-radio-group v-model="form.budgetCategoryType">
              <el-radio
                v-for="v in options.budgetCategoryType"
                :key="v.clsTypeKey"
                :label="v.clsTypeKey"
              >{{v.name}}</el-radio>
            </el-radio-group>
          </el-form-item>-->
        </el-form>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button
          type="primary"
          @click="
            dialogFormVisible = false
            onClickRegistAPI()
          "
          >Confirm</el-button
        >
      </span>
    </el-dialog>
  </el-card>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios"
import common from "@/js/common/common.js"

const API_PATH_AST_02 = "http://localhost:8080/api/ast/budget"
const API_PATH_AST_06 = "http://localhost:8080/api/ast/budget-fix"

export default {
  name: "BudgetList",
  mixins: [common],
  data() {
    return {
      options: {
        budgets: [],
        budgetCategories: [
          // TODO APIで取得
          {
            id: 1,
            name: "予算カテゴリ１"
          },
          {
            id: 2,
            name: "予算カテゴリ２"
          },
          {
            id: 3,
            name: "予算カテゴリ３"
          },
          {
            id: 4,
            name: "予算カテゴリ４"
          },
          {
            id: 5,
            name: "予算カテゴリ５"
          },
          {
            id: 6,
            name: "予算カテゴリ６"
          }
        ]
      },
      dialogFormVisible: false, //モーダルの表示状態
      form: {
        id: null,
        budgetCategoryId: null,
        name: null,
        amount: null
        // selectedBudgetCategory: null
        // budgetCategoryType: false
      },
      selectedBudgetCategory: null
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
    that.display(that)
  },
  mounted: function() {},
  methods: {
    // TODO 共通パーツ化
    openSuccessNotification: function(defaultFlg, originalMessage) {
      console.log(defaultFlg)
      var message =
        defaultFlg === true ? "This is a success message" : originalMessage
      this.$notify({
        title: "Success",
        message: message,
        type: "success"
      })
    },
    getFromApi: function() {
      var that = this

      //GETの実行
      axios
        .get(API_PATH_AST_02)
        .then(function(res) {
          that.options.budgets = res.data.budgets
        })
        .catch(function(err) {
          console.log("ERROR")
          console.log(err)
        })
    },
    // setClsType: function(data) {
    //   var that = this
    //   that.options.budgetCategoryType = data.budgetCategoryType
    // },
    // setClsTypeErr: function(data) {
    //   console.log(data)
    // },
    display: function(that) {
      that.options.budgetCategories.push({
        id: 0,
        name: "指定なし"
      })
      // debugger
      that.options.budgetCategories.sort(that.objectArraySort("id", "asc"))
      // debugger
    },
    onClickEdit: function(selectedId) {
      //モーダルに値をセット
      if (selectedId === 0) {
        this.form = {
          id: null,
          budgetCategoryId: null,
          name: null,
          amount: null
        }
      } else {
        var getData = this.options.budgets.find(v => v.id === selectedId)

        this.form = {
          id: getData.id,
          budgetCategoryId: getData.budgetCategoryId,
          name: getData.name,
          amount: getData.amount
        }
      }
      console.log(this.form)
      //モーダルを開く
      // this.dialogFormVisible = true;
    },
    onClickRegistAPI: function() {
      var that = this
      console.log("onClickRegistAPI method実行")
      var request = {
        id: this.form.id,
        budgetCategoryId: this.form.budgetCategoryId,
        name: this.form.name,
        amount: this.form.amount
      }

      axios
        .patch(API_PATH_AST_02, request)
        .then(function(response) {
          console.log("ok")
          console.log(response)
          that.openSuccessNotification(true)
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
        .delete(API_PATH_AST_02 + "/" + selectedId)
        .then(function(response) {
          console.log("ok")
          console.log(response)
        })
        .catch(function(error) {
          console.log("ERROR")
          console.log(error)
        })
    },
    onClickBudgetFix: function() {
      var that = this

      var request = {
        userId: 2,
        appropriateMonth: "2020-11-01"
      }

      axios
        .patch(API_PATH_AST_06, request)
        .then(function(response) {
          console.log("ok")
          console.log(response)
          that.openSuccessNotification(true)
        })
        .catch(function(error) {
          console.log("NG")
          console.log(error)
        })
    }
  }
}
</script>

<style scoped></style>
