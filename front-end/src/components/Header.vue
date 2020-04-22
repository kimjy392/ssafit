<template>
  <v-app-bar app>
    <v-toolbar-title><router-link to="/"><v-img
        contain
        width="50px"
        src="../assets/logo.png"
      ></v-img></router-link></v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="hidden-sm-and-down">
        <v-btn
        v-for="item in menu"
        :key="item.title"
        :to="item.path"
        >{{ item.title }}</v-btn>
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
      menu: [
            { title: 'Login', path:'/login' }
          ]
		}
	}
}
</script>
