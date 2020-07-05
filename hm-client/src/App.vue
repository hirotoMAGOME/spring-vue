<template>
  <div id="app">
    <SharedHeader />
    <router-view />
  </div>
</template>

<script>
import SharedHeader from "./components/common/SharedHeader";

export default {
  name: "App",
  components: {
    SharedHeader
  }
};

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
