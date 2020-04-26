<template>
  <div id="videoDiv">
    <v-row class="justify-space-around">
      <div class="mx-2" v-on:mouseover="mouseover1" v-on:mouseleave="mouseleave1">
        <v-btn text style="height: 100px;">
          <v-img
            class="vtnImg"
            :class="hoverClass1"
            width="100px"
            height="100px"
            src="@/assets/turtle.png"
          >
          </v-img>
        </v-btn>
      </div>
      <div class="mx-2" v-on:mouseover="mouseover2" v-on:mouseleave="mouseleave2">
        <v-btn text style="height: 100px;">
          <v-img
            class="vtnImg"
            :class="hoverClass2"
            width="100px"
            height="100px"
            src="@/assets/spine.png"
          >
          </v-img>
        </v-btn>
      </div>
      <div class="mx-2" v-on:mouseover="mouseover3" v-on:mouseleave="mouseleave3">
        <v-btn text style="height: 100px;">
          <v-img 
            class="vtnImg"
            :class="hoverClass3"
            width="100px"
            height="100px"
            src="@/assets/hello.png"
          >
          </v-img>
        </v-btn>
      </div>
      <div class="mx-2" v-on:mouseover="mouseover4" v-on:mouseleave="mouseleave4">
        <v-btn text style="height: 100px;">
          <v-img 
            class="vtnImg"
            :class="hoverClass4"
            width="100px"
            height="100px"
            src="@/assets/male.png"
          >
          </v-img>
        </v-btn>
      </div>
    </v-row>
    <v-container fluid>
      <v-row dense>
        <v-col class="videoComp" v-for="videoEle in videoList" :key="videoEle.video_id" cols="4">
          <Video :video_id="videoEle.video_id" :title="videoEle.title" :file="videoEle.file"
            :thumbnail="videoEle.thumbnail" :description="videoEle.description" :part="videoEle.part"></Video>
        </v-col>
      </v-row>
    </v-container>


  </div>
</template>

<script>
  import Video from '@/components/Video.vue'

  export default {
    data() {
      return {
        // icons: ['tutle.png', 'spine.png', 'hello.png', 'male.png'],
        hoverClass1: '',
        hoverClass2: '',
        hoverClass3: '',
        hoverClass4: '',
      }
    },
    methods: {
      mouseover1: function () {
        this.hoverClass1 = "animated infinite tada"
      },
      mouseleave1: function () {
        this.hoverClass1 = ""
      },
      mouseover2: function () {
        this.hoverClass2 = "animated infinite tada"
      },
      mouseleave2: function () {
        this.hoverClass2 = ""
      },
      mouseover3: function () {
        this.hoverClass3 = "animated infinite tada"
      },
      mouseleave3: function () {
        this.hoverClass3 = ""
      },
      mouseover4: function () {
        this.hoverClass4 = "animated infinite tada"
      },
      mouseleave4: function () {
        this.hoverClass4 = ""
      },
    },
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
  .vtnImg {
    filter: invert(100%);
  }
  .videoComp {
    padding: 20px;
  }
</style>