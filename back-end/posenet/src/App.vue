<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <my-video :sources="video.sources" :options="video.options"></my-video>
  </div>
</template>

<script>
import myVideo from 'vue-video'
export default {
    name: 'App',
    data() {
      return {
        path: '',
         video: {
                sources: [{
                    src: 'http://i02b104.p.ssafy.io/video/dance.mp4',
                    type: 'video/mp4'
                }],
                options: {
                    volume: 0.6
                }
         }
      }
    },
    components: {
        myVideo
    }
  }
  
</script>

<style>

</style>
