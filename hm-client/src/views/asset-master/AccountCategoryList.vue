<template>
  <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
    <div slot="header" class="clearfix">
      <span>口座カテゴリ一覧</span>
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
    <el-table :data="options.accountCategories" border style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column
        prop="name"
        label="口座カテゴリ名"
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
          <el-form-item label="口座カテゴリ名">
            <el-input v-model="form.name"></el-input>
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
</template>
<script>
/* eslint-disable no-console */

import axios from "axios"
import common from "@/js/common/common.js"

const API_PATH_AST_03 = "http://localhost:8080/api/ast/account-category"

export default {
  name: "AccountCategoryList",
  mixins: [common],
  data() {
    return {
      options: {
        accountCategories: []
      },
      dialogFormVisible: false, //モーダルの表示状態
      form: {
        id: null,
        name: null
      }
    }
  },
  created: function() {
    var that = this
    // //GET
    // that.getFromApi()
    //   //初期値をセット
    //   that.display()
    that.getFromApi().then(() => {
      that.display()
    })
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

      return new Promise(function(resolve, reject) {
        //GETの実行
        axios
          .get(API_PATH_AST_03)
          .then(function(res) {
            that.$set(
              that.options,
              "accountCategories",
              res.data.accountCategories
            )
            resolve()
          })
          .catch(function(err) {
            console.log("ERROR")
            console.log(err)
            reject()
          })
      })
    },
    display: function() {},
    onClickEdit: function(selectedId) {
      //モーダルに値をセット
      if (selectedId === 0) {
        this.form = {
          id: null,
          name: null
        }
      } else {
        var getData = this.options.accountCategories.find(
          v => v.id === selectedId
        )

        this.form = {
          id: getData.id,
          name: getData.name
        }
      }
    },
    onClickRegist: function() {
      var that = this
      console.log("onClickRegist method実行")
      var request = {
        id: this.form.id,
        name: this.form.name
      }

      axios
        .patch(API_PATH_AST_03, request)
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
        .delete(API_PATH_AST_03 + "/" + selectedId)
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
