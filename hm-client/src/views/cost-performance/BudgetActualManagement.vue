<template>
  <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
    <div slot="header" class="clearfix">
      <span>予実管理</span>
      <el-select
        filterable
        v-model="appropriateMonth"
        @change="changeMonthsSelect"
      >
        <el-option
          v-for="item in options.months"
          :key="item.appropriateMonth"
          :label="item.name"
          :value="item.appropriateMonth"
          >{{ item.name }}</el-option
        >
      </el-select>
      <div class="balloon2">
        <p>
          TODO いろいろフィルタで絞り込む。予算カテゴリや「今月の予算」など？
        </p>
        <p>
          TODO
          画面定義書がないとキツい。画面の構成。各操作で何を更新するのか定義したい。
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
    <el-table
      :data="options.budgetCategoriesBudgets"
      border
      style="width: 100%"
    >
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
      <el-table-column label="実績(履歴)" width="180">
        <template slot-scope="scope">
          <el-button
            type="info"
            label="scope.row.id"
            round
            @click="
              onClickOpenActualHistory(scope.row.budgetId)
              historyDialogVisible = true
            "
          >
            履歴</el-button
          >
        </template>
      </el-table-column>
      <el-table-column label="登録" width="180">
        <template slot-scope="scope">
          <el-button
            type="info"
            round
            @click="
              onClickActualRegist(scope.row.budgetId)
              dialogFormVisible = true
            "
            >登録</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="実績登録" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form ref="form" :model="form" label-width="200px" size="medium">
          <el-form-item label="予算ID">{{ form.budgetId }}</el-form-item>
          <el-form-item label="口座ID">
            <el-select filterable placeholder="Select" v-model="form.accountId">
              <el-option
                v-for="item in options.accounts"
                :key="item.id"
                :label="item.name"
                :value="item.id"
                >{{ item.name }}</el-option
              >
            </el-select>
          </el-form-item>
          <el-form-item label="datepicker">
            <el-date-picker
              v-model="form.settledAt"
              format="yyyy/MM/dd"
              type="date"
              placeholder="Pick a day"
              :picker-options="pickerOptions"
            >
            </el-date-picker>
          </el-form-item>
          <el-form-item label="金額">
            <el-input v-model="form.price"></el-input>
          </el-form-item>
          <el-form-item label="実績">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <!-- <el-form-item label="予算カテゴリ名">
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
          </el-form-item> -->
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
    <!-- TODO 時刻の表示フォーマット -->
    <el-dialog title="実績の確認" :visible.sync="historyDialogVisible">
      予算名：{{ historyDialog.budgetName }}
      <el-table :data="historyDialog.history" border style="width: 100%">
        <el-table-column prop="name" label="残高"></el-table-column>
        <el-table-column prop="price" label="金額"></el-table-column>
        <el-table-column prop="accountId" label="口座"></el-table-column>
        <el-table-column prop="settledAt" label="記帳日時"></el-table-column>
      </el-table>
    </el-dialog>
  </el-card>
</template>
<script>
/* eslint-disable no-console */

import axios from "axios"
import common from "@/js/common/common.js"

//予実管理(資産)API
const API_PATH_CPF_22 = "http://localhost:8080/api/ast/asset-budget-actual"

export default {
  name: "BudgetActualManagement",
  mixins: [common],
  data() {
    return {
      options: {
        budgetCategoriesBudgets: [],
        budgetsActuals: [],
        months: [],
        accounts: []
      },
      selectedMonth: null, //対象月プルダウン
      thisYMD: null, //今日のyyyy/mm/dd
      appropriateMonth: null, //プルダウンで選択したyyyy/mm/01
      dialogFormVisible: false, //モーダルの表示状態
      historyDialogVisible: false, //履歴モーダルの表示状態
      form: {
        budgetId: null,
        accountId: null,
        price: null,
        name: null,
        settledAt: null
      },
      historyDialog: {
        budgetName: null,
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

      //初期表示時のみappropriateMonthをセット
      if (that.appropriateMonth === null) {
        let dObj = new Date()

        that.thisYMD = dObj.toLocaleString().split(" ")[0]
        that.appropriateMonth =
          that.thisYMD.split("/")[0] + "/" + that.thisYMD.split("/")[1] + "/01"
      }

      //GETの実行
      axios
        .get(API_PATH_CPF_22, {
          // params: {
          //   appropriateMonth: that.selectedMonth
          // }
          //TODO 固定値をやめる
          params: {
            appropriateMonth: this.appropriateMonth
          }
        })
        .then(function(res) {
          console.log(res)
          that.options.budgetCategoriesBudgets =
            res.data.budgetCategoriesBudgets
          that.options.budgetsActuals = res.data.budgetsActuals
          that.options.accounts = res.data.accounts
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
      that.options.months = that.setMonthsSelect(that.thisYMD)
    },
    onClickActualRegist: function(selectedBudgetId) {
      //モーダルに値をセット
      console.log(selectedBudgetId)
      var targetBudgetCategoriesBudgets = this.options.budgetCategoriesBudgets.find(
        v => v.budgetId === selectedBudgetId
      )
      console.log(targetBudgetCategoriesBudgets)
      this.form = {
        budgetId: targetBudgetCategoriesBudgets.budgetId,
        accountId: null,
        price: null,
        name: null
      }
    },
    onClickRegistAPI: function() {
      var that = this

      let textSettlededAt = that.form.settledAt.toLocaleString().split("T")[0]

      console.log("onClickRegistAPI method実行")
      var request = {
        settledAt: textSettlededAt,
        budgetId: that.form.budgetId,
        accountId: that.form.accountId,
        price: that.form.price,
        name: that.form.name
      }

      axios
        .patch(API_PATH_CPF_22, request)
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
    onClickOpenActualHistory: function(budgetId) {
      var that = this
      let getDialogData = Array

      getDialogData = that.options.budgetsActuals.filter(function(value) {
        return value.id === budgetId
      })

      that.historyDialog.budgetName = getDialogData[0].name
      that.historyDialog.history = getDialogData[0].actuals
    },
    //プルダウンのセット用
    setMonthsSelect: function(thisYMD) {
      let year = thisYMD.split("/")[0]
      let month = thisYMD.split("/")[1]

      var returnObj = []
      for (let i = 0; i < 3; i++) {
        let MonthNum = (Number(month) - i) % 12
        if (MonthNum === 0) {
          MonthNum = 12
        }

        returnObj.push({
          name: year + "年" + MonthNum + "月",
          appropriateMonth: year + "/" + MonthNum + "/01"
        })
      }

      return returnObj
    },
    //プルダウンのchangeアクション用
    changeMonthsSelect: function() {
      this.getFromApi()
    }
  }
}
</script>

<style scoped></style>
