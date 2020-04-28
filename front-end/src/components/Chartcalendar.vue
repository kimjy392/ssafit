<template>
  <v-row>
    <v-col xs="12" md="6">
      <Chart></Chart> <!-- 이 부분 차트넣으시면 됩니다! -->
    </v-col>
    <v-col xs="12" md="6">
      <Calendar></Calendar>
    </v-col>
  </v-row>
</template>

<script>
import Calendar from '@/components/Calendar.vue'
import Chart from '@/components/Chart.vue'
export default {
    name : 'Chartcalendar',
    components: {
        Calendar,
        Chart,
    }
}
</script>

<style>

</style>