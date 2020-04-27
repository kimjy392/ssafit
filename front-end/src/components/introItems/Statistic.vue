<template>
  <v-container fill-height>
    <h2 class="display-3 font-weight-bold mb-3 white--text">STATISTICS</h2>
    <v-row class="mx-auto mt-12">
      <v-col
        v-for="[title, value] of stats"
        :key="title"
        cols="12"
        md="4"
      >
      <p class="display-1 font-weight-light text-center white--text">{{title}}</p>
        <v-card raised color="#FF7033" width="60%" class="mx-auto d-flex justify-center align-center" evelvaion="14" min-height="10vh">
          <span class="white--text display-1 font-weight-black">{{value}}</span>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Statistic',
  data() {
    return {
    }
  },
  props: {
    statistic : {
      type : Object
    }
  },
  computed: {
    stats() {
      return [
          ['USERS', this.statistic.total_users],
          ['TODAY', this.statistic.total_cnt],
          ['TIMES', this.statistic.total_time],
        ]
    }
  }
}
</script>

<style>

</style>