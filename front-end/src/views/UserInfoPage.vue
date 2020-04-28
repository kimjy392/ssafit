<template>
  <v-container>
    
    <Header></Header>
    <v-img
          width="100%"
          height="50%"
            src="../assets/intro_bg.png"
          >
    <div>
      <h1 class="display-2 font-weight-bold my-12 text-uppercase white--text">MY PAGE</h1>
    </div>
    <v-row>
      <v-col cols="12">
        <!-- rangking and Greeting -->
        <Rangking></Rangking>
      </v-col>
      <v-col cols="12">
        <!-- chart and calender -->
        
        <Chartcalendar></Chartcalendar>
      </v-col>
      <v-col cols="12">
      
        <HistoryList></HistoryList>
      </v-col>
    </v-row>
    <v-row>
    </v-row>
  </v-img>
  </v-container>
</template>

<script>
// import axios from 'axios'
import Header from '@/components/Header.vue'
import HistoryList from '@/components/HistoryList.vue'
import Rangking from '@/components/Rangking.vue'
import Chartcalendar from '@/components/Chartcalendar.vue'
export default {
  name: "UserInfoPage",
  components: {
    HistoryList,
    Rangking,
    Chartcalendar,
    Header,
  },
  data() {
    return {

    }
  },
  methods: {
    // getHistory() {
    //   axios.get('')
    //   .then((res) => {
    //     console.log(res)
    //   })
    // }
  },
  mounted() {
    this.$store.dispatch('isLogin')
  },
  computed: {
    user() {
      return this.$store.state.auth.user
    }
  }
}
</script>

<style>

</style>
