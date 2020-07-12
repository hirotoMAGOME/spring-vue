<template>
  <div id="app">
    <!-- <link rel="stylesheet" href="sample.css"> -->
    <!-- 画面サイズ固定 -->
    <div id="app-shared-header">

    </div>
    <SharedHeader />
    <SharedSideBar />
    <router-view />

    <link rel="stylesheet" href="./css/common/app.css">
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
