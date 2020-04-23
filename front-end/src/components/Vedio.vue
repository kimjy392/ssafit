<template>
  <v-card @click="moveDetail(vedio_id)">
    <v-img :src="thumbnail" class="white--text align-end" gradient="to bottom, rgba(0,0,0,.5), rgba(0,0,0,.8)"
      width="100%">
      <v-card-title v-text="title"></v-card-title>
    </v-img>
  </v-card>
</template>

<script>
  export default {
    props: {
      vedio_id: {
        type: Number,
        default: 0
      },
      title: {
        type: String,
        default: ""
      },
      file: {
        type: String,
        default: ""
      },
      thumbnail: {
        type: String,
        default: ""
      },
      description: {
        type: String,
        default: ""
      },
      part: {
        type: Array,
        default: () => ([])
      },
    },
    methods: {
      moveDetail(video_id) {
        this.$router.push({name: 'Detail', params:{id: video_id}})
      }
    }
  }
</script>

<style>

</style>