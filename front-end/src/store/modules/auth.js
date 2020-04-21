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