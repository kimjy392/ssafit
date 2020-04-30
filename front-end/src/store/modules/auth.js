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
      sessionStorage.removeItem('vue-session-key')
      commit('deleteToken')
    },
    
    isLogin({commit}) {
      if (sessionStorage.getItem('vue-session-key')) {
        const jwt = JSON.parse(sessionStorage.getItem('vue-session-key')).jwt
        if (!jwt) {
          return false
        }
        else {
          const userdata = {
            token : jwt,
            user : {
              memberid : jwtDecode(jwt).Authorization.memberid,
              email : jwtDecode(jwt).Authorization.email,
              name : jwtDecode(jwt).Authorization.name
            }
          }
          commit('setToken', userdata)
          return true
        }
      }
      else {
        return false
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