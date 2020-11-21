<template>
  <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
    <div slot="header" class="clearfix">
      <span>口座残高管理</span>
    </div>
    <el-table :data="options.latestAccountBalances" border style="width: 100%">
      <el-table-column
        prop="accountId"
        label="口座名"
        width="180"
      ></el-table-column>
      <el-table-column
        prop="balance"
        label="残高"
        width="180"
      ></el-table-column>
      <el-table-column
        prop="recordedAt"
        label="最終記録日時"
        width="180"
      ></el-table-column>
      <el-table-column label="編集" width="180">
        <template slot-scope="scope">
          <el-button
            type="info"
            round
            @click="
              onClickEdit(scope.row.accountId)
              dialogFormVisible = true
            "
            >編集</el-button
          >
        </template>
      </el-table-column>
      <el-table-column label="履歴" width="180">
        <template slot-scope="scope">
          <el-button
            type="info"
            round
            @click="
              onClickOpenHistory(scope.row.accountId, scope.row.currencyId)
              historyDialogVisible = true
            "
            >履歴</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="最新の口座状況の登録" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form ref="form" :model="form" label-width="200px" size="medium">
          <el-form-item label="口座名">{{ form.accountId }}</el-form-item>
          <el-form-item label="記帳日時">
            <el-date-picker
              v-model="recordedAt"
              type="date"
              placeholder="口座残高を確認した日付"
              :picker-options="pickerOptions"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item label="残高">
            <el-input v-model="form.balance"></el-input>
          </el-form-item>
          <el-form-item label="通貨">
            <el-input v-model="form.balance"></el-input>
          </el-form-item>
        </el-form>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button
          type="primary"
          @click="
            dialogFormVisible = false
            onClickPostApi()
          "
          >Confirm</el-button
        >
      </span>
    </el-dialog>

    <el-dialog title="履歴の確認" :visible.sync="historyDialogVisible">
      口座名：{{ historyDialog.accountNm }}
      <el-table :data="historyDialog.history" border style="width: 100%">
        <el-table-column prop="balance" label="残高"></el-table-column>
        <el-table-column
          prop="recordedAt"
          label="最終記録日時"
        ></el-table-column>
      </el-table>
    </el-dialog>
  </el-card>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios"
import common from "@/js/common/common.js"

//口座残高管理API
const API_PATH_CPF_21 =
  "http://localhost:8080/api/ast/account-balance-management"

export default {
  name: "AccountBalance",
  mixins: [common],
  data() {
    return {
      options: {
        latestAccountBalances: [],
        accountBalanceHistory: []
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
      },
      pickerOptions: {
        //datepicker用
        disabledDate(time) {
          return time.getTime() > Date.now()
        },
        shortcuts: [
          {
            text: "Today",
            onClick(picker) {
              picker.$emit("pick", new Date())
            }
          },
          {
            text: "Yesterday",
            onClick(picker) {
              const date = new Date()
              date.setTime(date.getTime() - 3600 * 1000 * 24)
              picker.$emit("pick", date)
            }
          },
          {
            text: "A week ago",
            onClick(picker) {
              const date = new Date()
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
              picker.$emit("pick", date)
            }
          }
        ]
      },
      recordedAt: "" //datepicker用 defaultの設定を共通化したい
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
        .get(API_PATH_CPF_21)
        .then(function(res) {
          that.options.latestAccountBalances = res.data.latestAccountBalance
          that.options.accountBalanceHistory = res.data.accountBalanceHistory
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
      // that.options.budgetCategories.push({
      //   id: 0,
      //   name: "指定なし"
      // })

      that.options.latestAccountBalances.sort(
        that.objectArraySort("accountId", "asc")
      )
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
        .post(API_PATH_CPF_21, request)
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
