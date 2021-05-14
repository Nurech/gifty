import Vue from 'vue'
import VueRouter from 'vue-router'
import ChooseGift from "@/views/ChooseGift.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/createEvent',
    name: 'Create Gifter event',
    component: () => import(/* webpackChunkName: "Create Event" */ '../views/Event2.vue')
  },
/*  {
    path: '/e',
    name: 'ChooseGift',
    component: () => import(/!* webpackChunkName: "Choose Gift" *!/ '../views/ChooseGift.vue')
  },*/

  { path: '/e/:eventId/u/:userId',
    name: 'ChooseGiftU', component: ChooseGift }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


export default router
