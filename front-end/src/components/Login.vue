<template>
  <v-container _fluid fill-height grid-list-md>
     <v-layout>  
      <v-flex xs12 sm8 offset-sm2 lg6 offset-lg3>
        <v-card>
          <v-card-text>
            <v-layout row>
              <v-flex xs10 offset-xs1 md8 offset-md2>
                <v-card flat>
                  <v-card-title>
                    <h1 class="headline">로그인하기</h1>
                  </v-card-title>
                  <v-card-text>
                    <v-form ref="form" v-model="valid" lazy-validation>
                      <v-text-field
                        prepend-icon="person"
                        autofocus
                        v-model="username"
                        label="Username"
                        :rules="usernameRules"
                        persistent-hint
                        required></v-text-field>             
                      <v-text-field
                        prepend-icon="lock"
                        v-model="password"
                        type="password"
                        label="Password"
                        :rules="passwordRules"
                        persistent-hint
                        hint="로그인에는 항상 포스팅키를 사용하시기를 권장합니다."
                        ></v-text-field>
                    </v-form>
                  </v-card-text>
                  <v-card-actions class='pt-0'>
                    <v-spacer></v-spacer>
                    <v-btn color="primary" :loading="busy" :disabled="busy" @click.prevent="login">로그인</v-btn>
                  </v-card-actions> 
                </v-card>
              </v-flex>
            </v-layout>
          </v-card-text>
        </v-card>
      </v-flex>
     </v-layout>
  </v-container>
</template>
<script>
import steem from 'steem'

export default {
  name: 'login', // 컴포넌트 이름
  data () {
    return {
      valid: false, // 유효성 체크 플래그값
      username: '', // username
      password: '', // 비밀번호
      usernameRules: [ // username 유효성 검사 로직
        v => !!v || 'Username is required'
      ],
      passwordRules: [ // 비밀번호 유효성 검사 로직
        v => (!v || steem.auth.isWif(v)) || 'Password is invalid'
      ],
      busy: false // 로그인 요청 여부 플래그값
    }
  },
  deactivated () {
    this.$destroy()
  },
  methods: {
    login () {
      if (this.$refs.form.validate()) { // 유효성 체크
        // 로그인 로직
        this.busy = true
        // 스팀잇 네트워크에서 username 조회
        steem.api.lookupAccountNamesAsync([this.username])
            .then(usernames => {
            if (!usernames || !usernames[0]) return alert(`"${this.username}" 사용자를 찾을 수 없습니다.`)
        
            // 저장소의 로그인 액션 디스패치~
            this.$store.dispatch('auth/login', {
                username: this.username,
                password: this.password
            })
        
            // 메인 페이지로 이동
                this.$router.go(-1)
        })
        .finally(() => (this.busy = false))
      }
    }
  }
}
</script>