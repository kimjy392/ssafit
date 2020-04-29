<template>
  <v-container>
    
    <Header></Header>
    <v-img
          width="100%"
          height="50%"
            src="../assets/intro_bg.png"
          >
    <div>
      <h1 class="display-2 font-weight-bold my-12 text-uppercase white--text">
        MY PAGE  <i class="fas fa-user-astronaut"></i>
      </h1>
    </div>
    <v-row justify="space-around">
      <v-col cols="7" class="py-0">
        <v-row>
          <v-col cols="12" class="border-3d">
            <!-- ranking -->
            <Rangking></Rangking>
          </v-col>
        </v-row>
        <v-row justify="space-between" class="mt-12">
          <v-col cols="6" class="border-3d px-5 py-5">
            <!-- calendar -->
            <div class="canlen-title d-flex justify-start align-center" style="height: 200px;">
              <h2 class="mx-5 text-white d-inline-block ">CALENDAR</h2>
            </div>
            <div class="back-white" height="100%">
              <Calendar></Calendar>
            </div>
          </v-col>
          <v-col cols="5" class="border-3d"> 
            <!-- chart -->
            <Chart></Chart>
          </v-col>
        </v-row>        
      </v-col>
      <v-col cols="4" class="border-3d m-5 p-12">
        <!-- history -->
        <h2 class="display-2 font-weight-bold my-12 text-uppercase white--text">HISTORY</h2>
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
// import Chartcalendar from '@/components/Chartcalendar.vue'
import Calendar from '@/components/Calendar.vue'
import Chart from '@/components/Chart.vue'
export default {
  name: "UserInfoPage",
  components: {
    HistoryList,
    Rangking,
    // Chartcalendar,
    Header,
    Calendar,
    Chart,
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
.canlen-title {
  background-color: #FF7033;
  border-bottom: solid 6px rgb(239, 98, 27);
}
.back-white {
  background-color: rgb(246, 246, 249);
  border-radius: 20px 20px 20px 20px;
}
.border-3d {
  border-radius: 2em;
  border: 3px solid rgb(87, 107, 234);
  box-shadow:1px 1px #768BFE, -1px -1px rgb(81, 102, 224), 1px 1px inset #768BFE, -1px -1px inset rgb(81, 102, 224);
}
</style>
