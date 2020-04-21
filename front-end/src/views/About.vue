<template>
  <div>
      {{ token }}
      asdasd
  </div>
</template>

<script>
export default {
  name: "About",
  components: {

  },
  data() {
    return {
      token : null
    }
  },
  methods: {
    isLogin() {
       this.$session.start()
      // session에 jwt가 없다면, 즉 토큰이 없다면, 비로그인이라면,
      if (!this.$session.get('jwt')) {
        console.log('로그인되어있어요')
      }
      else {
        // 로그인 되어있다면, vuex token 업데이트
        this.token = this.$session.get('jwt')
      }
    },
  },
  mounted() {
    this.isLogin()
  },
}
</script>

<style>

</style>