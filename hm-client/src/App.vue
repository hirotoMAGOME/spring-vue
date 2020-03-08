<template>
  <div id="app">
    <SharedHeader />
    <HelloWorld msg="Welcome to Your Vue.js App" />
    <router-view />
  </div>
</template>

<script>
import SharedHeader from "./components/SharedHeader";
import HelloWorld from "./components/HelloWorld";

export default {
  name: "App",
  components: {
    HelloWorld,
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
