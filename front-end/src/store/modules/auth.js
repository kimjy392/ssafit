const state = {
    token : null
}

const mutations = {
    setToken(state, token) {
        state.token = token
    }
}

const actions = {
    login({commit}, payload) {
        commit('setToken', payload)
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