import Vue from 'vue'
import App from './App.vue'
import router from './router'
import serverData from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import SmartTable from 'vuejs-smart-table'

Vue.use(SmartTable)
Vue.use(VueAxios,axios)
Vue.config.productionTip = false

new Vue({
  router,
  serverData,
  render: function (h) { return h(App) }
}).$mount('#app')

const token = localStorage.getItem("user-token");
if (token) {
  axios.defaults.headers.common['Authorization']= "Bearer " + token
}