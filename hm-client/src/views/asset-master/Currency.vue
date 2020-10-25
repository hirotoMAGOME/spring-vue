<template>
  <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
    <div slot="header" class="clearfix">
      <span>通貨一覧</span>
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
    <el-table :data="options.accounts" border style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="name" label="通貨名" width="180"></el-table-column>
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
          <el-form-item label="表記">{{ form.mark }}</el-form-item>
          <el-form-item label="通貨名">
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

const API_PATH_AST_04 = "http://localhost:8080/api/ast/account"

export default {
  name: "AccountList",
  mixins: [common],
  data() {
    return {
      options: {
        accounts: []
      },
      dialogFormVisible: false, //モーダルの表示状態
      form: {
        id: null,
        mark: null,
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
          .get(API_PATH_AST_04)
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
    display: function() {},
    onClickEdit: function(selectedId) {
      //モーダルに値をセット
      if (selectedId === 0) {
        this.form = {
          id: null,
          name: null,
          mark: null
        }
      } else {
        var getData = this.options.accounts.find(v => v.id === selectedId)

        this.form = {
          id: getData.id,
          name: getData.name,
          mark: getData.mark
        }
      }
    },
    onClickRegistAPI: function() {
      var that = this
      console.log("onClickRegistAPI method実行")
      var request = {
        id: this.form.id,
        name: this.form.name,
        mark: this.form.mark
      }

      axios
        .patch(API_PATH_AST_04, request)
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
        .delete(API_PATH_AST_04 + "/" + selectedId)
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
