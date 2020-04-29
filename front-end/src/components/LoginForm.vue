<template>
  <v-sheet>
    
    <v-responsive :aspect-ratio="15/8">

    <v-row style="height: 100%; width:100%;" class="mx-0 loginRow">
      <v-col cols="6" md="6" class="background pt-12">
        <v-row align="center" justify="center" style="height: 100%; width:100%;">
            <div>
              <div class="display-3 white--text mb-3">
                <img src="@/assets/turtle_test.gif" alt="turtle" style="width: 100%">
              </div>
            </div>
        </v-row>
      </v-col>

      <v-col cols="6" md="6" class="loginCol pt-12">
        <v-row align="center" justify="center" style="height: 100%;"
        class="px-10">
          <div style="width:100%;">
            
            <div>
              <v-form class="px-2" justify="center" @submit.prevent="login" >
                <v-text-field
                light="true"
                color="white"
                style="width:100%; height:100%; text-color=:white;"
                label="Email"
                name="email"
                type="text"
                v-model="credentials.email"
                />
                <v-text-field
                color="white"
                style="width:100%; height:100%;"
                id="password"
                label="Password"
                name="password"
                type="password"
                v-model="credentials.password"
                />
                <div class="d-flex justify-center">
                  <v-btn large color="#FF7033" style="color: white;" type="submit">LOG IN</v-btn>
                </div>
                <div class="my-12"></div>
                <div class="nouserDiv">
                  아직 회원이 아니세요? 
                  <img id="nouserGif" height="44px" src="@/assets/puzzled.gif" alt="animated_puzzled">
                  <br>
                  <v-btn @click="nonMemLogin" color="#FF7033" large outlined="">
                    여기
                  </v-btn>
                  를 눌러 SSA<span id="text-yellow">FIT</span>를 체험해보세요.
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
    },
    nonMemLogin() {
      axios.post('http://i02b104.p.ssafy.io:8197/ssafyvue/api/' + 'login/', this.nonMemcredentials)
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
.loginRow {
  border: 3px solid rgb(58, 79, 206);
  /* box-shadow:2px 2px #768BFE, -2px -2px #768BFE, 1px 1px inset #768BFE, -1px -1px inset rgb(81, 102, 224); */
}
#nouserGif {
  filter: invert(100%);
}
.nouserDiv {
  color: white;
}
#text-yellow {
  color: #FECD00;
}
/* .imgDiv {
  background-color: #556AE9;
  position:absolute; 
  left:50%; 
  transform:translateX(-50%);
  top: -10%;
  z-index: 1000;
} */

</style>