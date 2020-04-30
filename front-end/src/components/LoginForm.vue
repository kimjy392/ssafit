<template>
  <v-sheet elevation="13">
    
    <v-responsive :aspect-ratio="15/8">

    <v-row style="height: 100%; width:100%;" class="mx-0">
      <v-col cols="6" md="6" class="background pt-12">
        <v-row align="center" justify="center" style="height: 100%; width:100%;">
            <div>
              <div class="display-3 white--text mb-3">
                <img src="@/assets/turtle_test.gif" alt="turtle" style="width: 100%">
              </div>
            </div>
        </v-row>
      </v-col>

      <v-col cols="6" md="6" class="loginCol pt-12" style="width:100%;">
        <v-row align="center" justify="center" style="height: 100%;"
        class="px-10">
          <div style="width:100%;">
            <div>
              <v-form class="px-2" justify="center" @submit.prevent="login" >
                <div class="text-field-back py-5 px-5 mx-12 mb-5">
                  <v-text-field
                  light
                  style="width:100%; height:100%; text-color=:white;"
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
                </div>
                <div class="d-flex justify-center">
                  <v-btn large color="#FF7033" style="color: white;" type="submit">LOG IN</v-btn>
                </div>
                <div class="my-12"></div>
                <div class="font-nato nouserDiv">
                  <h2>
                  아직 회원이 아니세요? <i class="far fa-surprise"></i>
                  <br>
                  <a @click="nonMemLogin">
                    <span style="color:#FF7033;">여기</span>
                  </a>
                  를 눌러 SSA<span id="text-yellow">FIT</span>를 체험해보세요.
                  </h2>
                </div>
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
      credentials: {},
      nonMemcredentials: {
        email : 'test@naver.com',
        password : 'test'
      }
    }
  },
  // computed: {
  //   getImg() {
  //     return require("../assets/logo.png")
  //   }
  // },
  methods: {
    login()  {
        axios.post('http://i02b104.p.ssafy.io:8197/ssafyvue/api/' + 'login/', this.credentials)
        .then((res) => {
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
        .catch(() => {
        })
    },
    nonMemLogin() {
      axios.post('http://i02b104.p.ssafy.io:8197/ssafyvue/api/' + 'login/', this.nonMemcredentials)
      .then((res) => {
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
    }
  }
  
}
</script>

<style>
.background {  
  background-color: white;
  /* background: linear-gradient(to left, #2d8cff, red ); */
}
.loginCol {
  background-color: rgb(64, 85, 212);
}

#nouserGif {
  filter: invert(100%);
}
.nouserDiv {
  color: white;
  font-weight: 600;
}
#text-yellow {
  color: #FECD00;
}
.font-nato {
  font-family: 'Noto Sans KR', sans-serif;
}
.text-field-back {
  border-radius: 20px 20px;
  background-color: #ffffff;
  /* opacity: 0.7; */
}
</style>