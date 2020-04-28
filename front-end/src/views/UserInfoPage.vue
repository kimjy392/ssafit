<template>
  <div>
      {{ user }}
      asdasd
  </div>
</template>

<script>
export default {
  name: "UserInfoPage",
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
}
</script>

<style>

</style>
