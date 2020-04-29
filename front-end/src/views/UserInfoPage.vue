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
    
  </v-img>
  <div id="animal" class="movable">
      <v-img src="@/assets/gom.gif" height="400px" width="400px"></v-img>
    </div>
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
      aniRoute: '',
      animal: ['dog_1.gif', 'dog_2.gif', 'gom.gif']
    }
  },
  methods: {
    // getHistory() {
    //   axios.get('')
    //   .then((res) => {
    //     console.log(res)
    //   })
    // }
    workingAnimal() {
      var x = 0; //Left시작 위치
      var y = 800; //top시작 위치
      var dest_x = 500; //Left종료 위치
      var dest_y = 900;
      var interval = 20; // 1px씩
      
      function moveImage() {
        if(x<dest_x) x = x + interval; 
        if(y<dest_y) y = y + 0;
          
        //ufo이미지 움직이기
        document.getElementById("animal").style.left = x+'px';
        document.getElementById("animal").style.top  = y+'px';
          
      }
      if ((x+interval < dest_x) && (y+0 < dest_y)) {
        //종료 위치가 될때 까지 함수 100마이크로세컨드 계속 호출
        window.setInterval(moveImage(),100);
      }
      // moveImage()
    }
  },
  mounted() {
    this.$store.dispatch('isLogin')
    this.workingAnimal()
    // var rand = Math.random()
    // var idx = 0
    // if (rand <= 1/3) {
    //   idx = 0
    // } else if (rand <= 2/3) {
    //   idx = 1
    // } else {
    //   idx = 2
    // }
    // this.aniRoute = '@/assets/' + this.animal[idx]
    // this.workingAnimal()
  },
  computed: {
    user() {
      return this.$store.state.auth.user
    }
  }
}
</script>

<style>
.movable { 
  position:absolute; 
}
.canlen-title {
  background-color: #FF7033;
  border-bottom: solid 6px rgb(239, 98, 27);
  border-radius: 20px 20px 0px 0px / 20px 20px 0px 0px;
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
