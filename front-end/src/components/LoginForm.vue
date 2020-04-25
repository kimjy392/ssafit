<template>
  <v-sheet elevation="12">
    <v-responsive :aspect-ratio="15/8">
    <v-row style="height: 100%; width:100%;" class="mx-0">
      
      <v-col cols="8" md="8" class="background">
        <v-row align="center" justify="center" style="height: 100%; width:100%;">
            <div>
              <div class="display-3 white--text mb-3">
                <img src="@/assets/turtle1.gif" alt="turtle" style="height: 100%">
              </div>
              <div class="white--text">
                test
              </div>
            </div>
        </v-row>
      </v-col>

      <v-col cols="4" md="4">
        <v-row align="center" justify="center" style="height: 100%;">
          <div style="width:100%;">
            <div>
            <v-img :src="getImg" class="mx-5"></v-img>
            </div>
            <div>
              <v-form class="px-2 mt-5 text-center" @submit.prevent="login">
                <v-text-field
                style="width:100%; height:100%;"
                  label="Email"
                  name="email"
                  type="text"
                  v-model="credentials.email"
                />
                <v-text-field
                style="width:100%; height:100%;"
                  id="password"
                  label="Password"
                  name="password"
                  type="password"
                  v-model="credentials.password"
                />
                <v-btn type="submit" class="primary">로그인</v-btn>
              </v-form>
            </div>
          </div>
        </v-row>
      </v-col>
    </v-row>
    </v-responsive>
  </v-sheet>      
</template>

<script>

import axios from 'axios'

export default {
  name:'LoginForm',
  data() {
    return {
      credentials: {}
    }
  },
  computed: {
    getImg() {
      return require("../assets/logo.png")
    }
  },
  methods: {
    login()  {
        axios.post('http://i02b104.p.ssafy.io:8197/ssafyvue/api/' + 'login/', this.credentials)
        .then((res) => {
            console.log(res)
            const userdata = {
              user : res.data,
              token : res.headers.authorization
            }
            this.$session.start()
            this.$session.set('jwt', userdata.token)
            this.$store.dispatch('login', userdata)
            this.credentials = {}
            this.$router.push('/main')
        })
        .catch((err) => {
            console.log(err)
        })
    }
  }
  
}
</script>

<style>
.background {  
  background-color: #9fffe9;
  /* background: linear-gradient(to left, #2d8cff, red ); */
}

</style>