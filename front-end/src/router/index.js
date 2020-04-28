import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/LoginPage.vue'
import Intro from '@/views/IntroPage.vue'
import Main from '@/views/MainPage.vue'
import UserInfo from '@/views/UserInfoPage.vue'
import Stretching from '@/views/StretchingPage.vue'
import Result from '@/views/ResultPage.vue'

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
    component: Main,
  },
  {
    path: '/userinfo',
    name: 'UserInfo',
    component: UserInfo
  },
  {
    path: '/detail/:id',
    name: 'Stretching',
    component: Stretching,
    props: true
  },
  {
    path: '/result',
    name: 'Result',
    component: Result
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

