<template>
  <v-container>
      <v-row>
        <v-col cols="12">
          <!-- rangking and Greeting -->
          <h2 class="display-2 font-weight-bold mb-3 text-uppercase white--text">Rangking, greeting</h2>
          <Rangking></Rangking>
        </v-col>
        <v-col cols="12">
          <!-- chart and calender -->
          <h2 class="display-2 font-weight-bold mb-3 text-uppercase white--text">Chart, Calendar</h2>
          <Chartcalendar></Chartcalendar>
        </v-col>
        <v-col cols="12">
        <h2 class="display-2 font-weight-bold mb-3 text-uppercase white--text">History</h2>
          <HistoryList></HistoryList>
        </v-col>
      </v-row>
      <v-row>
      </v-row>
  </v-container>
</template>

<script>
// import axios from 'axios'
import HistoryList from '@/components/HistoryList.vue'
import Rangking from '@/components/Rangking.vue'
import Chartcalendar from '@/components/Chartcalendar.vue'
export default {
  name: "UserInfoPage",
  components: {
    HistoryList,
    Rangking,
    Chartcalendar
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
