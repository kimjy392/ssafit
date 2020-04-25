<template>
  <v-container fill-height>
    <v-row class="mx-auto">
      <v-col
        v-for="[value, title] of stats"
        :key="title"
        cols="12"
        md="3"
      >
        <div class="text-center">
          <div
            class="display-3 font-weight-black mb-4"
            v-text="value"
          ></div>

          <div
            class="title font-weight-regular text-uppercase"
            v-text="title"
          ></div>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Statistic',
  data() {
    return {
      stats: [
          ['24k', 'Github Stars'],
          ['330+', 'Releases'],
          ['1m', 'Downloads/mo'],
          ['5m', 'Total Downloads'],
        ],
    }
  }
}
</script>

<style>

</style>