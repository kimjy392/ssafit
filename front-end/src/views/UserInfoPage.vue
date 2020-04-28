<template>
  <div>
      {{ user }}
      asdasd

      <!-- 랭킹 -->
      <v-container>
      <v-row>
        <v-col class="col-4">
          
          <v-img class="max-small" src="@/assets/giphy.gif" alt="dacingWhale">
            <h1 class="ranking text-white">랭킹</h1>
          </v-img>
        </v-col>
        <v-col class="col-8 d-flex align-center">
          <div class="ranking-desc">
            <h2 class="text-white">{{ user.name }}님!</h2>
            <h3 class="text-white dis-inline"><h2 class="text-white dis-inline">(총 유저수)</h2> 중 <h2 class="text-white dis-inline">(랭킹)</h2>번째로 스트레칭을 열심히 하셨네요!</h3>
          </div>
        </v-col>
      </v-row>
    </v-container>

    <!-- 그래프2 -->
    <div>
      <div>
        <v-row>
          <v-col class="col-3">
            <span>
              <span style="background-color: rgb(255, 209, 87); width: 20px; height: 20px;"></span>
            </span>
          </v-col>
          <v-col class="col-3">
            
          </v-col>
          <v-col class="col-3">

          </v-col>
          <v-col class="col-3">

          </v-col>
        </v-row>
      </div>
      <vc-donut
        foreground="grey"
        :size="400" :thickness="30"
        has-legend legend-placement="top"
        :sections="sections" :total="100"
        :start-angle="0" :auto-adjust-text-size="true"
        >
        <div class="d-flex align-center justify-center">
          <v-img width="300px" src="@/assets/donutturtle.jpg"></v-img>
        </div>
      </vc-donut>
  </div>

    <!-- 그래프1 -->
    <div>
      <div class="canlen-title">
        <h2 class="text-white dis-inline">CALENDAR</h2>
        <div>
          <v-img src="@/assets/cal.png" width="100px" height="100px"></v-img>
        </div>
        <div>
          <v-img src="@/assets/calblack.png" width="100px" height="100px"></v-img>
        </div>
      </div>
      <div>
        <v-sheet height="600">
          <v-calendar
            ref="calendar"
            v-model="value"
            :events="events"
            :event-overlap-mode="mode"
            :event-overlap-threshold="30"
            :event-color="getEventColor"
            @change="getEvents"
          ></v-calendar>
        </v-sheet>
      </div>
    </div>
    
  </div>
</template>

<script>
export default {
  
  name: "UserInfoPage",
  components: {

  },
  data() { 
    return {
      sections: [
        { label: 'EXCELLENT', value: 25, color: 'rgb(255, 209, 87)' },
        { label: 'GREAT', value: 25, color: 'rgb(129, 182, 253)' },
        { label: 'GOOD', value: 25, color: 'rgb(66, 221, 78)' },
        { label: 'BAD', value: 25, color: 'rgb(255, 133, 115)' }
      ],
      day: ['2020-04-10', '2020-04-11', '2020-04-20'],
      type: 'month',
      // types: ['month', 'week', 'day', '4day'],
      mode: 'stack',
      // modes: ['stack', 'column'],
      weekday: [0, 1, 2, 3, 4, 5, 6],
      // weekdays: [
      //   { text: 'Sun - Sat', value: [0, 1, 2, 3, 4, 5, 6] },
      //   { text: 'Mon - Sun', value: [1, 2, 3, 4, 5, 6, 0] },
      //   { text: 'Mon - Fri', value: [1, 2, 3, 4, 5] },
      //   { text: 'Mon, Wed, Fri', value: [1, 3, 5] },
      // ],
      value: '',
      events: [],
      colors: ['blue', 'indigo', 'deep-purple', 'cyan', 'green', 'orange', 'grey darken-1'],
      // names: []
      // names: ['Meeting', 'Holiday', 'PTO', 'Travel', 'Event', 'Birthday', 'Conference', 'Party'],
  }},

  methods: {
    // getEvents ({start, end}) {
    getEvents ( s ) {
      const events = this.events
      // const start = `${s} 00:00`
      // const end = `${s} 23:00`
      const a = `${s} 00:00`
      const b = `${s} 23:00`
      const start = '2020-04-10 00:00'
      const end = '2020-04-10 23:00'
      const color = "indigo"
      events.push({
        start: start, 
        end: end, 
        color: color,
        a: a,
        b: b
      })
      this.events = events
      console.log(events)
    },
    getEventColor (event) {
      return event.color
    },
    rnd (a, b) {
      return Math.floor((b - a + 1) * Math.random()) + a
    },
    formatDate (a, withTime) {
      return withTime
        ? `${a.getFullYear()}-${a.getMonth() + 1}-${a.getDate()} ${a.getHours()}:${a.getMinutes()}`
        : `${a.getFullYear()}-${a.getMonth() + 1}-${a.getDate()}`
    },
    check (d) {
      console.log(d)
      for (var i = 0; i < d.length; i ++) {
        console.log(d[i])
        // var param = { d[i], d[i] }
        this.getEvents(d[i])
      }
      console.log('-----')
      console.log(this.events)
    }
  },
  mounted() {
    this.$store.dispatch('isLogin')
    // var d = this.day
    // var dayLen = d.lenght
    // console.log(this.day, dayLen)
    // for (var i = 0; i < dayLen; i ++) {
    //   this.getEvents(this.day[i], this.day[i])
    //   console.log(i)
    // }
    // this.check(this.day)

  },
  computed: {
    user() {
      return this.$store.state.auth.user
    }
  }
}
</script>

<style>
.max-small {
    width: auto; height: auto;
    max-width: 385px;
    max-height: 360px;
    border-radius: 50%;
    border: 3px solid rgb(64, 85, 212);
}
.ranking {
  position: absolute;
  left: 50%; 
  top: 50%;
  transform: translate(-50%,-50%);
}
.text-white {
  color: white;
}
.dis-inline {
  display: inline;
}
.canlen-title {
  background-color: #FF7033;
  border-bottom: solid 6px rgb(239, 98, 27);
}

</style>