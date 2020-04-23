<template>
  <v-app-bar class="px-7" app flat color="rgba(0, 0, 0, 0)">
    <v-toolbar-title>
      <router-link to="/">
        <v-img contain width="40px" src="../assets/logo.png"></v-img>
      </router-link>
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <v-btn text color="#2d8cff" v-for="item in menu" :key="item.title" :to="item.path">{{ item.title }}</v-btn>
    </v-toolbar-items>
    <v-app-bar-nav-icon class="hidden-md-and-up" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
  </v-app-bar>
</template>

<script>
  export default {
    name: 'Header',
    data() {
      return {
        drawer: null,
        menu: [{
          title: '로그인',
          path: '/login'
        }]
      }
    }
  }
</script>