import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router/index.js'
import Element from 'element-ui'

import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

import "element-ui/lib/theme-chalk/index.css"
import axios from 'axios'
import "./axios"
import "./permission"

Vue.use(mavonEditor)
Vue.use(Element)


Vue.config.productionTip = false
Vue.prototype.$axios= axios



new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
