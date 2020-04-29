<template>
  <div>
    <v-sheet height="100%">
      <v-calendar ref="calendar" v-model="value" :weekdays="weekday" type="month" :events="cevents"
        event-overlap-mode="stack" :event-overlap-threshold="30" :event-color="getEventColor" @change="getEvents">
      </v-calendar>
    </v-sheet>
  </div>
</template>

<script>
  export default {
    name: 'Calendar',
    props: {
      userdays: {
        type: Array,
        default: () => ([])
      },
    },
    data() {
      return {
        type: 'month',
        mode: 'stack',
        weekday: [0, 1, 2, 3, 4, 5, 6],
        value: '',
        events: [],
        colors: [],
        names: [],
      }
    },
    methods: {
      getEvents() {
        var events = []
        console.log(this.userdays, '처음 받아오는 부분')
        for (var i=0; i < this.userdays.length; i++) {
          console.log(this.userdays[i], 'userdaysddddd')
          events.push({

            color: "orange",
            end: this.userdays[i],
            name: "",
            start: this.userdays[i],
          })
          this.colors.push('orange')
        }
        this.events = events
        console.log(events, 'dsfasdfsad')
      },
      getEventColor(event) {
        return event.color
      },
    },
    watch: {
      userdays: function () {
        this.getEvents()
      }
    },
    computed: {
      cevents() {
        return this.events
      }
    },
  }
</script>

<style>

</style>