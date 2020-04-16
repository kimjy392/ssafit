import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/LoginPage.vue'
import Intro from '@/views/IntroPage.vue'
import Main from '@/views/MainPage.vue'
import About from '@/views/About.vue'

Vue.use(VueRouter)
  const routes = [
  {
    path: '/',
    name: 'Intro',
    component: Intro
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/main',
    name: 'Main',
    component: Main
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

