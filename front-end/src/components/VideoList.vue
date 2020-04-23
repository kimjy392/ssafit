<template>
  <div id="videoDiv">

      <v-container fluid>
        <v-row dense>
          <v-col v-for="videoEle in videoList" :key="videoEle.video_id" cols="4">
            <Video
              :video_id="videoEle.video_id"
              :title="videoEle.title"
              :file="videoEle.file"
              :thumbnail="videoEle.thumbnail"
              :description="videoEle.description"
              :part="videoEle.part"
            ></Video>
          </v-col>
        </v-row>
      </v-container>


  </div>
</template>

<script>
  import Video from '@/components/Video.vue'

  export default {
    components: {
      Video
    },
    props: {
      videoList: {
        type: Array,
        default: () => ([])
      },
    },
  }
</script>

<style scoped>
#videoDiv {
  margin-top: 50px;
  margin-left: 100px;
  margin-right: 100px;
}

</style>