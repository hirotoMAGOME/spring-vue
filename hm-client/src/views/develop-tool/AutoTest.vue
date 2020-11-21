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
        <div v-show="testIsArrayErrFlg" style="background-color:red">{{ testIsArrayErrList }}</div>
      </el-card>
      <!-- isObject -->
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>isObject</span>
        </div>
        <div v-show="testIsObjectErrFlg" style="background-color:red">{{ testIsObjectErrList }}</div>
      </el-card>
      <!-- testTransformationToCamelTextFromSnakeText -->
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>testTransformationToCamelFromSnakeText</span>
        </div>
        <div
          v-show="testTransformationToCamelTextFromSnakeTextErrFlg"
          style="background-color:red"
        >{{ testTransformationToCamelTextFromSnakeTextErrList }}</div>
      </el-card>
      <!-- testObjectArraySort -->
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>testObjectArraySort</span>
        </div>
        <div
          v-show="testObjectArraySortErrFlg"
          style="background-color:red"
        >{{ testObjectArraySortErrList }}</div>
      </el-card>

      <!-- ここまで -->
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
      testIsObjectErrFlg: false,
      testTransformationToCamelTextFromSnakeTextErrList: [],
      testTransformationToCamelTextFromSnakeTextErrFlg: false,
      testObjectArraySortErrList: [],
      testObjectArraySortErrFlg: false
    }
  },
  methods: {
    test: function() {
      this.testIsArray()
      this.testIsObject()
      this.testTransformationToCamelTextFromSnakeText()
      this.testObjectArraySort()
      // this.testTransformationToCamelFromSnake()
    },
    testIsArray: function() {
      if (this.isArray("String")) {
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
    },
    testTransformationToCamelTextFromSnakeText: function() {
      if (
        this.transformationToCamelTextFromSnakeText("test_snake_case") !==
        "testSnakeCase"
      ) {
        this.testTransformationToCamelTextFromSnakeTextErrList.push(
          "ERROR testTransformationToCamelTextFromSnakeText(001)"
        )
        this.testTransformationToCamelTextFromSnakeTextErrFlg = true
      }
    },
    testObjectArraySort: function() {
      //判定用テストデータ
      var testObjectArray = [
        { id: 1, name: "ZZZ" },
        { id: 5, name: "BBB" },
        { id: 3, name: "aaa" }
      ]
      var CorrectArray1 = [
        { id: 1, name: "ZZZ" },
        { id: 3, name: "aaa" },
        { id: 5, name: "BBB" }
      ]
      var CorrectArray2 = [
        { id: 1, name: "ZZZ" },
        { id: 5, name: "BBB" },
        { id: 3, name: "aaa" }
      ]

      if (
        JSON.stringify(
          testObjectArray.sort(this.objectArraySort("id", "asc"))
        ) !== JSON.stringify(CorrectArray1)
      ) {
        this.testObjectArraySortErrList.push("ERROR testObjectArraySort(001)")
        this.testObjectArraySortErrFlg = true
      }
      if (
        JSON.stringify(
          testObjectArray.sort(this.objectArraySort("name", "desc"))
        ) !== JSON.stringify(CorrectArray2)
      ) {
        this.testObjectArraySortErrList.push("ERROR testObjectArraySort(002)")
        this.testObjectArraySortErrFlg = true
      }
    }
  },
  mounted: function() {
    this.test()
  }
}
</script>
