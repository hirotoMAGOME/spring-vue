<template>
  <el-main>
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>モーダル</span>
      </div>
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>確認ダイヤログ</span>
        </div>
      </el-card>
      <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
        <div slot="header" class="clearfix">
          <div class="template-no-area"></div>
          <span>エラーダイヤログ</span>
        </div>
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
    <el-card class="box-card" shadow="always" body-style="padding:10px 20px">
      <div slot="header" class="clearfix">
        <span>入力フォーム</span>
      </div>
      <el-form ref="form" :model="form" label-width="200px" size="medium">
        <el-form-item label="ラベル">label</el-form-item>
        <el-form-item label="テキストボックス">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="リスト">
          <el-select filterable placeholder="Select" v-model="form.region">
            <el-option
              v-for="item in options.list"
              :key="item.id"
              :label="item.name"
              :value="item.name"
              >{{ item.name }}</el-option
            >
          </el-select>
        </el-form-item>
        <el-form-item label="Activity time">
          <el-col :span="11">
            <el-date-picker
              type="date"
              placeholder="Pick a date"
              v-model="form.date1"
              style="width: 100%;"
            ></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker
              placeholder="Pick a time"
              v-model="form.date2"
              style="width: 100%;"
            ></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="Instant delivery">
          <el-switch v-model="form.delivery"></el-switch>
        </el-form-item>
        <el-form-item label="Activity type">
          <el-checkbox-group v-model="form.type">
            <el-checkbox label="Online activities" name="type"></el-checkbox>
            <el-checkbox label="Promotion activities" name="type"></el-checkbox>
            <el-checkbox label="Offline activities" name="type"></el-checkbox>
            <el-checkbox
              label="Simple brand exposure"
              name="type"
            ></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="Resources">
          <el-radio-group v-model="form.resource">
            <el-radio label="Sponsor"></el-radio>
            <el-radio label="Venue"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="Activity form">
          <el-input type="textarea" v-model="form.desc"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">Create</el-button>
          <el-button>Cancel</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </el-main>
</template>

<script>
export default {
  name: "UiParts",
  data() {
    return {
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: ""
      },
      options: {
        list: [
          {
            item: "item1",
            name: "name1"
          },
          {
            item: "item2",
            name: "name2"
          }
        ]
      }
    }
  },
  methods: {
    setTemplateNo() {
      var getElement = document.querySelectorAll(".template-no-area")
      var count = 1
      getElement.forEach(element => {
        element.innerHTML = "( UIパーツ No." + count + " )"
        count++
      })
    }
  },
  mounted: function() {
    this.setTemplateNo()
  }
}
</script>
