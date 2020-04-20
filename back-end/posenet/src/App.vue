<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <my-video :sources="video.sources" :options="video.options"></my-video>
  </div>
</template>

<script>
import axios from 'axios'
import myVideo from 'vue-video'
export default {
    name: 'App',
    data() {
      return {
        path: '',
         video: {
                sources: [{
                    src: '',
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
    },
    mounted() {
      this.getVideo()
    },
    methods: {
      getVideo() {
        axios.get('http://i02b104.p.ssafy.io:8197/ssafyvue/api/video/1')
          .then( response => {
            console.log(response.data)
            this.path = response.data.path
          })
      }
    }
  }
  
</script>

<style>

</style>
