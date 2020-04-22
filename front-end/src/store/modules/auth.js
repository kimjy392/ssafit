import router from '../../router';
import jwtDecode from 'jwt-decode'

const state = {
    token : null,
    user : {}
}

const mutations = {
    setToken(state, userdata) {
        state.token = userdata.token
        state.user = userdata.user
    },

    deleteToken(state) {
        state.token = null
        state.user = {}
    }
}

const actions = {
    login({commit}, payload) {
        commit('setToken', payload)
    },

    logout({commit}) {
        commit('deleteToken')
        router.push('/')
    },
    
    isLogin({commit}, payload=false) {
      console.log(sessionStorage.getItem('vue-session-key'))
      if (sessionStorage.getItem('vue-session-key')) {
        const jwt = JSON.parse(sessionStorage.getItem('vue-session-key')).jwt
        if (!jwt) {
          console.log('로그인하세요')
          if (!payload) {
            router.push('/login')
            return
          }
        }
        else {
          console.log('로그인되어있어요')
          console.log(jwtDecode(jwt))
          const userdata = {
            token : jwt,
            user : {
              memberid : jwtDecode(jwt).Authorization.memberid,
              email : jwtDecode(jwt).Authorization.email,
              name : jwtDecode(jwt).Authorization.name
            }
          }
          commit('setToken', userdata)
          if (payload) {
            router.push('/main')
          }
          return
        }
      }
      else {
        if (!payload) {
          router.push('/login')
          return
        }
      }
    }
}

const getters = {

}

export default {
    state,
    mutations,
    actions,
    getters
}