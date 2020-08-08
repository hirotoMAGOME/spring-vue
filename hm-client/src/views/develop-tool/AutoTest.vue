<template>
  <el-main>
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>テスト結果(common.js)</span>
      </div>
      <!-- isArray -->
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>isArray</span>
        </div>
        <div v-show="testIsArrayErrFlg" style="background-color:red">
          {{ testIsArrayErrList }}
        </div>
      </el-card>
      <!-- isObject -->
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>isObject</span>
        </div>
        <div v-show="testIsObjectErrFlg" style="background-color:red">
          {{ testIsObjectErrList }}
        </div>
      </el-card>
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>エラーダイヤログ</span>
        </div>
        <div>{{ testIsArrayErrList }}</div>
      </el-card>
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>モーダル(中)</span>
        </div>
      </el-card>
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>モーダル(大)</span>
        </div>
      </el-card>
    </el-card>
  </el-main>
</template>

<script>
import common from "@/js/common/common.js"

export default {
  name: "AutoTest",
  mixins: [common],
  data() {
    return {
      testIsArrayErrList: [],
      testIsArrayErrFlg: false,
      testIsObjectErrList: [],
      testIsObjectErrFlg: false
    }
  },
  methods: {
    test: function() {
      this.testIsArray()
      this.testIsObject()
    },
    testIsArray: function() {
      if (this.isArray("aaa")) {
        this.testIsArrayErrList.push("ERROR isArray(001)")
        this.testIsArrayErrFlg = true
      }
      if (this.isArray({ test: "test" })) {
        this.testIsArrayErrList.push("ERROR isArray(002)")
        this.testIsArrayErrFlg = true
      }
      if (!this.isArray(["aaa", "bbb"])) {
        this.testIsArrayErrList.push("ERROR isArray(003)")
        this.testIsArrayErrFlg = true
      }
    },
    testIsObject: function() {
      if (this.isObject("aaa")) {
        this.testIsObjectErrList.push("ERROR isObject(001)")
        this.testIsObjectErrFlg = true
      }
      if (!this.isObject({ test: "test" })) {
        this.testIsArrayErrList.push("ERROR isObject(002)")
        this.testIsObjectErrFlg = true
      }
      if (this.isObject(["aaa", "bbb"])) {
        this.testIsArrayErrList.push("ERROR isObject(003)")
        this.testIsObjectErrFlg = true
      }
    }
  },
  mounted: function() {
    this.test()
  }
}
</script>
