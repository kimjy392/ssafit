<template>
  <div>
    <Header></Header>
    <div class="ml-auto mr-12" style="width: 3em;">
      <v-tooltip bottom>
        <template v-slot:activator="{ on }">
          <v-btn icon x-large color="#ff7235" v-on='on' v-on:mouseover='mouseover' v-on:mouseleave="mouseleave"
            @click.stop="dialog = true">
            <v-icon id="helpIcon">{{ questionMark }}</v-icon>
          </v-btn>
        </template>
        <span>도움말</span>
      </v-tooltip>
    </div>
    <v-dialog elevation-0 v-model="dialog" max-width="70vw">
      <HelpCard></HelpCard>
    </v-dialog>
    <div>
      <!-- <h1>Score: {{ score }} {{ spaceFlag }} 123123123123123</h1> -->
      <!-- background music -->
      <div>
        <audio autoplay>
          <source src="../assets/backgroundMusic.mp3" type="audio/mpeg">
        </audio>
        <audio id="excellentAudio" crossOrigin="anonymous" loop>
          <source src="../assets/excellent.mp3" type="audio/mpeg">
        </audio>
        <audio id="greatAudio" crossOrigin="anonymous" loop>
          <source src="../assets/great.mp3" type="audio/mpeg">
        </audio>
        <audio id="goodAudio" crossOrigin="anonymous" loop>
          <source src="../assets/good.mp3" type="audio/mpeg">
        </audio>
      </div>
    </div>
    <v-card id="vidioBox" class="mx-auto">
      <div id="videoContainer"></div>
    </v-card>
    <div class='sketch' id="sketch"></div>
    <div class="my-6"></div>
    <div style="text-align: center">
      <v-btn v-if="spaceFlag" id="spacebar" x-large color="#ff7235">
        스페이스바를 누르면 시작합니다!
      </v-btn>
      <v-btn v-if="!spaceFlag" id="spacebar" x-large color="#FF8C00">
        스페이스바를 누르면 멈춥니다!
      </v-btn>
    </div>
    <!-- <h1> {{ cosineSimilarity }} </h1> -->
  </div>
</template>

<script>
  import Header from '@/components/Header.vue';
  import axios from 'axios';
  import sketch from './sktech';
  import p5 from 'p5';
  import {
    poseSimilarity
  } from 'posenet-similarity';
  import HelpCard from '@/components/items/HelpCard.vue'

  export default {
    name: "Stretching",
    components: {
      Header,
      HelpCard,
    },
    data() {
      return {
        cam_poses: 0,
        video_poses: 0,
        cosineSimilarity: 0,
        excellentThresh: 100,
        greatThresh: 100,
        goodThresh: 100,
        score: 'Hmm...',
        questionMark: 'far fa-question-circle',
        dialog: false,
        excellentAudio: null,
        greatAudio: null,
        goodAudio: null,
        spaceFlag: true,
      };
    },
    methods: {
      everySecondTrigger() {
        this.$nextTick(function () {
          window.setInterval(() => {
            this.cam_poses = window.cam_poses
            this.video_poses = window.poses
            try {
              this.cosineSimilarity = poseSimilarity(this.cam_poses[0].pose, this.video_poses[0].pose, {
                strategy: 'cosineSimilarity'
              });
              window.cosineSimilarity = this.cosineSimilarity
              if (window.playFlag === true) {
                if (this.cosineSimilarity >= this.excellentThresh * 0.01) {
                  this.score = 'Excellent'
                  this.excellentAudio.play();
                  this.greatAudio.pause();
                  this.goodAudio.pause();
                } else if (this.cosineSimilarity >= this.greatThresh * 0.01) {
                  this.score = 'Great'
                  this.greatAudio.play()
                  this.excellentAudio.pause();
                  this.goodAudio.pause();
                } else if (this.cosineSimilarity >= this.goodThresh * 0.01) {
                  this.score = 'Good'
                  this.goodAudio.play();
                  this.greatAudio.pause();
                  this.excellentAudio.pause();
                } else {
                  this.score = 'Hmm...'
                  this.greatAudio.pause();
                  this.excellentAudio.pause();
                  this.goodAudio.pause();
                }
              }
            } catch (err) {
              this.score = 'Hmm...'
              this.greatAudio.pause();
              this.excellentAudio.pause();
              this.goodAudio.pause();
            }
          }, 1000);
        });
      },
      getVideo() {
        axios.get('http://i02b104.p.ssafy.io:8197/ssafyvue/api/stretching/detail/' + this.$route.params.id)
          .then((res) => {
            this.excellentThresh = res.data.excellent;
            this.greatThresh = res.data.great;
            this.goodThresh = res.data.good;
            window.excellentThresh = this.excellentThresh;
            window.firstStop = res.data.first_stop;
            window.secondStop = res.data.second_stop;
            window.next = res.data.next;
            window.videoURL = 'https://i02b104.p.ssafy.io/video/' + res.data.file;
            this.myp5 = new p5(sketch, document.getElementById('sketch'))
          })
          .catch((err) => {
            console.log(err)
          })
      },
      pressSpaceBar() {
        var vm = this;
        document.body.onkeyup = function (e) {
          if (e.keyCode == 32) { // when press spacebar
            if (window.playFlag == true) {
              window.playFlag = false
              vm.spaceFlag = true
            } else {
              window.playFlag = true
              vm.spaceFlag = false
            }
          }
        }
      },
      mouseover() {
        this.questionMark = 'fas fa-question-circle'
      },
      mouseleave() {
        this.questionMark = 'far fa-question-circle'
      }
    },
    mounted() {
      if (localStorage.getItem('reloaded')) {
        localStorage.removeItem('reloaded');
      } else {
        localStorage.setItem('reloaded', '1');
        location.reload();
      }
      this.excellentAudio = document.getElementById("excellentAudio");
      this.greatAudio = document.getElementById("greatAudio");
      this.goodAudio = document.getElementById("goodAudio");

      this.pressSpaceBar();
      this.getVideo();
      this.everySecondTrigger();
    },
  };
</script>
<style>
  canvas {
    width: 100px;
    height: 100px;
    background-color: yellow;
    display: inline-block;
  }

  #vidioBox {
    width: 1300px;
    text-align: center;
  }

  #helpIcon {
    font-size: 3em;
  }

  .v-dialog {
    box-shadow: none !important;
  }
</style>