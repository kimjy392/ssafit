<template>
  <div>
    <h1>PoseNet demo with Ml5.js</h1>
    <!-- <p id="status">Loading Model...</p> -->
    <h1>{{ cosineSimilarity }}</h1>
    <div id="videoContainer"></div>
    <div class='sketch' id="sketch"></div>
  </div>
</template>

<script>
// import Trainer from './Trainer.vue'
import sketch from './sktech';
import p5 from 'p5';
import { poseSimilarity } from 'posenet-similarity';

export default {
  name: "Detail",
  components: {

  },
  data() {
    return {
      // poses: poses
      cam_poses: 0,
      video_poses: 0,
      cosineSimilarity: 0,
    };
  },
  methods: {
    everySecondTrigger() {
      this.$nextTick(function() {
        window.setInterval(() => {
          this.cam_poses = window.cam_poses
          this.video_poses = window.poses
          this.cosineSimilarity = poseSimilarity(this.cam_poses[0].pose, this.video_poses[0].pose, { strategy: 'cosineSimilarity' });
        }, 1000);
      });
    }
  },
  mounted() {
    this.myp5 = new p5(sketch, document.getElementById('sketch'))
    this.everySecondTrigger();
  },
};
</script>

<style>
/* #videoContainer2 {
  width: 640px;
  display: inline-block;
} */
canvas {
  width: 100px;
  height: 100px;
  background-color: yellow;
  display: inline-block;
}
</style>