import Vue from "vue"
import BootstrapVue from "bootstrap-vue"
import Router from "vue-router"
import Home from "@/views/Home.vue"

Vue.use(Router)
Vue.use(BootstrapVue)

import "bootstrap/dist/css/bootstrap.css"
import "bootstrap-vue/dist/bootstrap-vue.css"

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ "@/views/About.vue")
    },
    {
      path: "/asset",
      name: "asset",
      component: () =>
        import(/* webpackChunkName: "asset" */ "@/views/Asset.vue")
    },
    {
      path: "/asset/cash",
      name: "cash",
      component: () => import(/* webpackChunkName: "cash" */ "@/views/Cash.vue")
    },
    {
      path: "/currency",
      name: "currency",
      component: () =>
        import(/* webpackChunkName: "currency" */ "@/views/Currency.vue")
    },
    {
      path: "/asset-summary",
      name: "assetSummary",
      component: () =>
        import(
          /* webpackChunkName: "assetMaster" */ "@/views/asset-summary/AssetSummary.vue"
        )
    },
    {
      path: "/cost-performance",
      name: "cost-performance",
      component: () =>
        import(
          /* webpackChunkName: "budget" */ "@/views/cost-performance/CostPerformance.vue"
        )
    },
    {
      path: "/asset-master",
      name: "assetMaster",
      component: () =>
        import(
          /* webpackChunkName: "assetMaster" */ "@/views/asset-master/AssetMaster.vue"
        )
    },
    {
      path: "/budget",
      name: "budget",
      component: () =>
        import(/* webpackChunkName: "budget" */ "@/views/budget/Budget.vue")
    },
    {
      path: "/develop-tool/ui-parts",
      name: "uiParts",
      component: () =>
        import(
          /* webpackChunkName: "uiParts" */ "@/views/develop-tool/UiParts.vue"
        )
    },
    {
      path: "/develop-tool/auto-test",
      name: "autoTest",
      component: () =>
        import(
          /* webpackChunkName: "autoTest" */ "@/views/develop-tool/AutoTest.vue"
        )
    },
    {
      path: "/json",
      name: "json",
      component: () =>
        import(/* webpackChunkName: "json" */ "@/json/budget-category.json")
    }
  ]
})
