<template>
  <v-container
    id="loginPage"
        class="fill-height"
      fluid
      >
        <v-row
          align="center"
          justify="center"
        >
        <v-col cols="9">
          <div class="imgDiv">
            <v-img class="mx-auto mb-6" :src="getImg" width="400px"></v-img>
          </div>
          <LoginForm></LoginForm>
        </v-col>
      </v-row>
  </v-container>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'

export default {
  name: 'Login',
  components: {
    LoginForm
  },
  methods: {
  },
  computed: {
    getImg() {
      return require("../assets/logo.png")
    }
  },
  mounted() {
    this.$store.dispatch('isLogin')
    .then((res) => {
      if (res) {
        this.$router.push('/')
      }
    })
  },
}
</script>

<style>
  #loginPage {
    background-image: url("../assets/stretch_bg.png");
  }
</style>