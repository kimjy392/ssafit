<template>
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

</template>

<script>
export default {
  name: 'Chart',
  data() { 
    return {
      sections: [
        { label: 'EXCELLENT', value: 25, color: 'rgb(255, 209, 87)' },
        { label: 'GREAT', value: 25, color: 'rgb(129, 182, 253)' },
        { label: 'GOOD', value: 25, color: 'rgb(66, 221, 78)' },
        { label: 'BAD', value: 25, color: 'rgb(255, 133, 115)' }
      ],
    }
  }
}
</script>

<style>

</style>