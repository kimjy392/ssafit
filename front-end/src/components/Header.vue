<template>
  <v-app-bar 
    class="px-7" 
    app 
    flat 
    color="#556AE9"
    height="100">
    <v-toolbar-title>
      <router-link to="/">
        <v-img contain width="200px" src="../assets/logo_test.png"></v-img>
      </router-link>
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <div class="my-auto mx-2">
        <v-btn 
        text
        color="white"
        >
          GO
        </v-btn>
      </div>
      <div class="my-auto mx-2">
        <v-btn 
        text
        color="white"
        >
          MY PAGE
        </v-btn>
      </div>
      <div class="my-auto mx-2">
        <v-btn 
          color="#FF7033"
          large
          v-for="item in menu" 
          :key="item.title" 
          :to="item.path"
          style="color: white;">
          {{ item.title }}
        </v-btn>
      </div>
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
          title: 'LOG IN',
          path: '/login'
        }]
      }
    }
  }
</script>