<template>
  <div> 
    <v-hover v-slot:default="{ hover }" open-delay="200">
      <v-card @click="moveDetail(video_id)" 
      v-on:mouseover="mouseover" v-on:mouseleave="mouseleave"
      class="img"
        :elevation="hover ? 16 : 2">
        <v-img :src="thumbnail" class="white--text align-end scale" :gradient="grad" width="100%">
          <v-card-title v-text="title"></v-card-title>
        </v-img>
      </v-card>
    </v-hover>
  </div> 
</template>

<script>
  export default {
    data() {
      return {
        grad: 'to bottom, rgba(0,0,0,.5), rgba(0,0,0,.8)'
      }
    },
    props: {
      video_id: {
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
        this.$router.push({
            name: 'Stretching',
            params: {
              id: video_id
            }
          }
        )
      },
      mouseover: function () {
          this.grad = 'to bottom, rgba(0,0,0,0), rgba(0,0,0,0)'
      },
      mouseleave: function () {
        this.grad = 'to bottom, rgba(0,0,0,.5), rgba(0,0,0,.8)'
      }
    },
  }
</script>
<style scoped>
.scale {
  transform: scale(1);
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -ms-transform: scale(1);
  -o-transform: scale(1);
  transition: all 0.3s ease-in-out;   /* 부드러운 모션을 위해 추가*/
}
.scale:hover {
  transform: scale(1.2);
  -webkit-transform: scale(1.2);
  -moz-transform: scale(1.2);
  -ms-transform: scale(1.2);
  -o-transform: scale(1.2);
}
.img {
  overflow:hidden
}
</style>