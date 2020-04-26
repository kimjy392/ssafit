<template>
  <v-app-bar 
    class="px-7" 
    app 
    flat 
    color="#556AE9"
    height="100">
    <v-toolbar-title>
      <router-link to="/">
        <v-img contain width="200px" height="55px" src="@/assets/logo_test.png"></v-img>
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
      <div v-if="isLogin" class="my-auto mx-2">
        <v-btn 
        text
        color="white"
        >
          MY PAGE
        </v-btn>
      </div>
      <div v-if="!isLogin" class="my-auto mx-2">
        <v-btn 
          large
          color="#FF7033"
          key="LOG IN" 
          to="/login"
          style="color: white;">
          LOG IN
        </v-btn>
      </div>
      <div v-if="isLogin" class="my-auto mx-2">
        <v-btn 
          large
          color="#FF7033"
          key="LOG OUT" 
          style="color: white;">
          LOG OUT
        </v-btn>
      </div>
    </v-toolbar-items>
    <HelpIcon></HelpIcon>
  </v-app-bar>
</template>

<script>
  import HelpIcon from '@/components/items/HelpIcon.vue';

  export default {
    name: 'Header',
    components: {
      HelpIcon,
    },
    data() {
      return {
      }
    },
    computed() {
      this.$store.dispatch('isLogin');
    },
    
  }
</script>