<template>
  <v-row>
    <v-col xs="12" md="6">
      <Chart></Chart> <!-- 이 부분 차트넣으시면 됩니다! -->
    </v-col>
    <v-col xs="12" md="6">
      <div class="canlen-title d-flex justify-start align-center">
        <h2 class="mx-5 text-white d-inline-block ">CALENDAR</h2>
        <!-- <div class="mx-1">
          <v-img src="@/assets/calblack.png" width="100px" height="100px"></v-img>
        </div> -->
      </div>
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
    },
    props: {
      userrank: {
        type: Array,
      },
    }
}
</script>

<style>
.canlen-title {
  background-color: #FF7033;
  border-bottom: solid 6px rgb(239, 98, 27);
}
</style>