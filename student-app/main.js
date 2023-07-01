
// #ifndef VUE3
import Vue from 'vue'
import App from './App'


import { request } from "@/utils/request.js"
Vue.prototype.$request=request

Vue.config.productionTip = false

import store from 'store/index.js'
Vue.prototype.$store =store;

App.mpType = 'app'

const app = new Vue({
	store,
    ...App
})
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
import vant from 'vant'
import 'vant/lib/index'
import App from './App.vue'
export function createApp() {
  const app = createSSRApp(App)
  app.use(vant)
  return {
    app
  }
}
// #endif