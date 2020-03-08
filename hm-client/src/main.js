import Vue from "vue";
import App from "./App.vue";
import router from "@/router/router.js";
import store from "./store";

import ElementUI from "element-ui";
import locale from "element-ui/lib/locale/lang/ja";
import "element-ui/lib/theme-chalk/index.css"; 

Vue.config.devtools = true;

Vue.config.productionTip = false;
Vue.use(ElementUI, { locale }); // 追記

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
