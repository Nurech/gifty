import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import SmartTable from 'vuejs-smart-table'
import { FormDatepickerPlugin } from 'bootstrap-vue'
import VueRouter from 'vue-router'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(VueRouter)
Vue.use(FormDatepickerPlugin)
Vue.use(SmartTable)
Vue.use(VueAxios,axios)
Vue.config.productionTip = false

new Vue({
  router,
  render: function (h) { return h(App) }
}).$mount('#app')

const token = localStorage.getItem("user-token");
if (token) {
  axios.defaults.headers.common['Authorization']= "Bearer " + token
}