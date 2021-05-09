import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import ChooseGift from "@/views/ChooseGift";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/event',
    name: 'Event',
    component: () => import(/* webpackChunkName: "about" */ '../views/Event.vue')
  },

  {
    path: '/event2',
    name: 'Event2',
    component: () => import(/* webpackChunkName: "about" */ '../views/Event2.vue')
  },
  {
    path: '/chooseGift',
    name: 'ChooseGift',
    component: () => import(/* webpackChunkName: "about" */ '../views/ChooseGift.vue')
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
