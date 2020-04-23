<template>
  <v-app>
    <!-- <v-content id="appStyle"> -->
    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
  export default {
    name: 'App',

    components: {},

    data: () => ({
      //
    }),
  };
</script>

<style>
  /* #appStyle {
  padding: 0 !important;  
} */
</style>