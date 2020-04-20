const state = {
    username: '',
    password: ''
}

const mutations = {
    login(state, {
        username,
        password
    }) {
        state.username = username
        state.password = password
    }
}

const actions = {
    login({
        commit
    }, auth) {
        commit('login', auth)
    }
}

const getters = {

}

export default {
    namespaced: true,
    state,
    mutations,
    actions,
    getters
}