<template>
  <div id="app">
    <el-container>
      <SharedHeader />
    </el-container>
    <el-container class="d-flex flex-row">
      <SharedSideBar style="width:200px" />
      <div style="width:1720px">
        <div class="row d-flex flex-row">
          <!-- TODO pageタイトルをcomponent化 -->
          <div class="page-title">
            <h1>ページタイトル</h1>
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>
              <el-breadcrumb-item>promotion management</el-breadcrumb-item>
              <el-breadcrumb-item>promotion list</el-breadcrumb-item>
              <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </div>
        <router-view />
      </div>
    </el-container>
  </div>
</template>

<script>
import SharedHeader from "./components/common/SharedHeader";
import SharedSideBar from "./components/common/SharedSideBar";

export default {
  name: "App",
  components: {
    SharedHeader,
    SharedSideBar
  }
};
</script>

<style>
@import "./css/common/common.css";
@import "./css/common/app.css";
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
