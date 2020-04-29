<template>
  <div >
   <v-sheet height="100%">
      <v-calendar
        ref="calendar"
        v-model="value"
        :weekdays="weekday"
        type="month"
        :events="events"
        event-overlap-mode="stack"
        :event-overlap-threshold="30"
        :event-color="getEventColor"
        @change="getEvents"
      ></v-calendar>
    </v-sheet>
  </div>
</template>

<script>
export default {
    name: 'Calendar',
    data() {
      return {
        type: 'month',
        mode: 'stack',
        weekday: [0, 1, 2, 3, 4, 5, 6],
        value: '',
        events: [],
        colors: ['blue', 'indigo', 'deep-purple', 'cyan', 'green', 'orange', 'grey darken-1'],
        names: ['Meeting', 'Holiday', 'PTO', 'Travel', 'Event', 'Birthday', 'Conference', 'Party'],
      }
    },
    methods: {
       getEvents () {
        const events = [
                  {
                    color:"indigo",
                    end:"2020-4-25",
                    name:"Good",
                    start:"2020-4-26",
                  },
                  {
                    color:"indigo",
                    end:"2020-4-02",
                    name:"Good",
                    start:"2020-4-03",
                  },
                  {
                    color:"indigo",
                    end:"2020-4-09",
                    name:"Good",
                    start:"2020-4-05",
                  }
                ]
        this.events = events
      },
      getEventColor (event) {
        return event.color
      },
    }
}
</script>

<style>

</style>