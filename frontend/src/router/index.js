import Vue from 'vue'
import VueRouter from 'vue-router'
import ChooseGift from "@/views/ChooseGift";

Vue.use(VueRouter)

const routes = [
  {
    path: '/about',
    name: 'About Gifter',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/event2',
    name: 'Create Gifter event',
    component: () => import(/* webpackChunkName: "about" */ '../views/Event2.vue')
  },
  {
    path: '/chooseGift',
    name: 'ChooseGift',
    component: () => import(/* webpackChunkName: "about" */ '../views/ChooseGift.vue')
  },

  { path: '/event/:eventId/user/:userId',
    name: 'ChooseGift', component: ChooseGift }

]



const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


export default router
