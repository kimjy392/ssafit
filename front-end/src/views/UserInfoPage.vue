<template>
  <div>
      {{ user }}
      asdasd
  </div>
</template>

<script>
export default {
<<<<<<< HEAD:front-end/src/views/About.vue
  name: "About",
  components: {

  },
  data() {
    return {

    }
  },
  methods: {
  },
  mounted() {
    this.$store.dispatch('isLogin')
  },
  computed: {
    user() {
      return this.$store.state.auth.user
    }
  }
=======
name: "UserInfo"
>>>>>>> 0ac539e0400db35eb3931d6c3af0dbbd7ce7b685:front-end/src/views/UserInfoPage.vue
}
</script>

<style>

</style>