<template>
  <div>
    <h1>{{ categoryName }}</h1>
    <!-- {{ vedioList }} -->
    {{ vedioList}}
    <v-img :src="vedioList[0].thumbnail">

    </v-img>
  </div>
</template>

<script>
  export default {
    props: {
      vedioList: {
        type: Object,
        default: () => ({})
      },
      categoryName: {
        type: String,
        default: ""
      }
    }
  }
</script>

<style>

</style>