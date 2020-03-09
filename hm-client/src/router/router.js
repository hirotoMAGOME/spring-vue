import Vue from "vue";
import BootstrapVue from 'bootstrap-vue';
import Router from "vue-router";
import Home from "@/views/Home.vue";

Vue.use(Router);
Vue.use(BootstrapVue);

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'



export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ '@/views/About.vue'),
    },
    {
      path: "/asset",
      name: "asset",
      component: () => import(/* webpackChunkName: "currency" */ '@/views/Asset.vue')
    },
    // ここを追加
    {
      path: "/currency",
      name: "currency",
      component: () => import(/* webpackChunkName: "currency" */ '@/views/Currency.vue')
    }
  ]
});
