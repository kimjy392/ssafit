<template>
  <div>
    <v-app-bar app>
      <v-toolbar-title><router-link to="/"><v-img
          contain
          max_height="70%"
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

    <v-navigation-drawer
      app
      v-model="drawer"
      relative
      temporary
      right="right"
      class="hidden-md-and-up"
    >
      <v-list-item>
        <v-list-item-avatar>
          <v-img src="http://mblogthumb1.phinf.naver.net/20160620_24/2323203_1466376988859pWkg0_JPEG/attachImage_1009133083.jpeg?type=w800"></v-img>
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title>Jun</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>
       <v-list>
        <v-list-item
          v-for="item in menu" :key="item.title">
            <router-link :to="item.path" style="text-decoration:none;"><v-list-item-title  style="color:black;">{{ item.title }}</v-list-item-title></router-link>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
   
    </div>
</template>

<script>
export default {
    name: 'Header',
    data() {
		return {
      drawer: null,
      menu: [
            { title: 'Home', path:'/'},
            { title: 'Login', path:'/login' }
          ]
		}
	}
}
</script>
