<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <p>{{title}}</p>
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
        title:'',
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
            this.title = response.data.title
            this.video.sources[0].src = response.data.path
            console.log(this.video.sources[0].src)
          })
      }
    }
  }
  
</script>

<style>

</style>
