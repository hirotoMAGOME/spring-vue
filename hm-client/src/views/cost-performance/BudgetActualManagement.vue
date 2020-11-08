<template>
  <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
    <div slot="header" class="clearfix">
      <span>予実管理</span>
      <div class="balloon2">
        <p>
          TODO いろいろフィルタで絞り込む。予算カテゴリや「今月の予算」など？
        </p>
      </div>
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
      <el-table-column
        prop="budgetName"
        label="予算名(カテゴリ名)"
        width="180"
      ></el-table-column>
      <el-table-column prop="amount" label="予算" width="180"></el-table-column>
      <el-table-column
        prop="price"
        label="実績(計)"
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
            >実績</el-button
          >
        </template>
      </el-table-column>
      <el-table-column label="削除→予算の変更履歴とか？" width="180">
        <template slot-scope="scope">
          <el-button type="info" round @click="onClickDelete(scope.row.id)">
            削除</el-button
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

//口座残高管理API
const API_PATH_CPF_22 = "http://localhost:8080/api/ast/asset-budget-actual"

export default {
  name: "BudgetActualManagement",
  mixins: [common],
  data() {
    return {
      options: {
        budgetCategories: []
      },
      dialogFormVisible: false, //モーダルの表示状態
      historyDialogVisible: false, //履歴モーダルの表示状態
      form: {
        accountId: null,
        recordedAt: null,
        balance: null,
        currencyId: null
      },
      historyDialog: {
        accountNm: null,
        history: []
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
        .get(API_PATH_CPF_22)
        .then(function(res) {
          that.options.budgetCategories = res.data.budgetCategories
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
      // that.options.latestAccountBalances.sort(
      //   that.objectArraySort("accountId", "asc")
      // )
      console.log(that)
    },
    onClickEdit: function(selectedId) {
      //モーダルに値をセット

      var getAccountBalance = this.options.latestAccountBalances.find(
        v => v.accountId === selectedId
      )

      this.form = {
        accountId: getAccountBalance.accountId,
        recordedAt: getAccountBalance.recordedAt,
        balance: getAccountBalance.balance,
        currencyId: getAccountBalance.currencyId
      }
    },
    onClickPostApi: function() {
      var that = this
      console.log("onClickPostApi method実行")

      //POSTリクエスト項目
      var request = {
        accountId: this.form.accountId,
        recordedAt: this.form.recordedAt,
        balance: this.form.balance,
        currencyId: 1 //TODOマスタから取得
      }

      axios
        .post(API_PATH_CPF_22, request)
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
    onClickOpenHistory: function(accountId, currencyId) {
      var that = this

      var getDialogData = that.options.accountBalanceHistory.filter(function(
        value
      ) {
        return value.accountId === accountId && value.currencyId === currencyId
      })
      that.historyDialog.accountNm = getDialogData[0].accountId //TODO accountId=>accountNm
      that.historyDialog.history =
        getDialogData[0].accountBalanceHistoryFiltered
    }
  }
}
</script>

<style scoped></style>
