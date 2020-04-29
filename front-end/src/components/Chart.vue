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
      :size="270" :thickness="30"
      has-legend legend-placement="top"
      :sections="ssection" :total="100"
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
  props: {
    userscore: {
      type: Object,
    },
    total: {
      type: Number,
      default: 100
    }
  },
  data() { 
    return {
      sections: [
      ],
    }
  },
  methods: {
    setSections() {
      const totalc = this.userscore.excellent + this.userscore.great + this.userscore.good + this.userscore.bad 
      this.sections.push({ label: `EXCELLENT (${this.userscore.excellent})` , value: this.userscore.excellent / totalc * 100, color: 'rgb(255, 209, 87)' })
      this.sections.push({ label: `GREAT (${this.userscore.great})`, value: this.userscore.great / totalc * 100, color: 'rgb(129, 182, 253)' })
      this.sections.push({ label: `GOOD (${this.userscore.good})`, value: this.userscore.good / totalc * 100, color: 'rgb(66, 221, 78)' })
      this.sections.push({ label: `BAD (${this.userscore.bad})`, value: this.userscore.bad  / totalc * 100, color: 'rgb(255, 133, 115)' })
    }
  },
  computed: {
    ssection() {
      return this.sections
    }
  },
  watch: {
    userscore: function() {
      this.setSections()
    }
  }
}
</script>

<style>

</style>