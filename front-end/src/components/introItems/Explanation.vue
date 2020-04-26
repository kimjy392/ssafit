<template>
  <v-container>
    <h2 class="display-3 font-weight-bold mb-3 white--text">How to use?</h2>
    <div class="py-3"></div>
    <HelpCard class="mx-auto"></HelpCard>
  </v-container>
</template>

<script>
import HelpCard from '@/components/items/HelpCard.vue'

export default {
  name: "Explanation",
  components: {
    HelpCard,
  },
}
</script>

<style>
  #expain {
    width: 70vw;
    height: 40vh;
  }
</style>