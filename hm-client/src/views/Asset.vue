<template>
    <el-row>
        <el-col :span="24">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span>asset一覧</span>
                </div>
                <el-table
                        :data="currencies"
                        style="width: 100%">
                    <el-table-column
                            prop="id"
                            label="通貨ID"
                            width="300"/>
                    <el-table-column
                            prop="name"
                            label="通貨名"
                            width="300"/>
                    <el-table-column
                            prop="symbol"
                            label="通貨単位"
                            width="300"/>
                    <el-table-column
                            prop="amount"
                            label="数量"
                            width="300"/>
                </el-table>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
  /* eslint-disable no-console */

  import axios from 'axios'

  export default {
    name: "Asset",
    data () {
      return {
        currencies: []
      }
    },
    created: async function () {
      await this.refresh()
    },
    methods: {
      refresh: async function () {
        const res = await axios.get('http://localhost:8080')
        //const res = await axios.get('/')
        this.currencies = res.data.currencies
        console.log(res);
        console.info(this.currencies)
      }
    }
  }
</script>

<style scoped>

</style>