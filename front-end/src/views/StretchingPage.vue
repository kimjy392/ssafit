<template>
  <div>
    <Header></Header>
    <div>
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
    <v-img class="animated mx-auto" width="500" :class="classeffect" :src="getEffectImg"></v-img>
    <v-card id="videoBox" class="mx-auto">
      <div id="videoContainer"></div>
    </v-card>
    <div class='sketch' id="sketch"></div>
    <div class="my-6"></div>
    <div style="text-align: center">
      <v-btn v-if="spaceFlag" id="spacebar" x-large color="#ff7235" class="white--text">
        스페이스바를 누르면 시작합니다!
      </v-btn>
      <v-btn v-if="!spaceFlag" id="spacebar" x-large color="#FF8C00" class="white--text">
        스페이스바를 누르면 멈춥니다!
      </v-btn>
    </div>
    <v-dialog elevation-0 v-model="resultModal">
      <div>
        <v-card
        class="mx-auto"
        width="90vw"
        height="90vh"
        color="rgba(0, 0, 0, 0.7)"
        outlined
        >
        <div class="container" style="text-align: center;">
          <div class="my-12"></div>
          <img class="scoreLine col-6" src="@/assets/Result.png" alt="Result">
          <div class="my-12"></div>
          <div class="row">
            <img class="scoreLine col-6" src="@/assets/Excellent.png" alt="Excellent">
            <div class="scoreLine col-6">{{ results['excellentCnt'] }} pt</div>
          </div>
          <div class="row">
            <img class="scoreLine col-6" src="@/assets/Great.png" alt="Great">
            <div class="scoreLine col-6">{{ results['greatCnt'] }} pt</div>
          </div>
          <div class="row">
            <img class="scoreLine col-6" src="@/assets/Good.png" alt="Good">
            <div class="scoreLine col-6">{{ results['goodCnt'] }} pt</div>
          </div>
          <div class="row">
            <img class="scoreLine col-6" src="@/assets/Bad.png" alt="Bad">
            <div class="scoreLine col-6">{{ results['badCnt'] }} pt</div>
          </div>
          <div class="my-12"></div>
          <v-progress-circular
            :rotate="-90"
            :size="100"
            :width="15"
            :value="timeValue"
            color="white"
            @click="moveNext"
          >
            <v-icon color="white">fas fa-play</v-icon>
          </v-progress-circular>
          <v-btn class="scoreLine col-6" @click="moveNext">다음영상</v-btn>
          <v-btn class="scoreLine col-6" @click="moveMain">종료하기</v-btn>
        </div>
        </v-card>
      </div>
    </v-dialog>
    <!-- <div> {{ cosineSimilarity }} </div> -->
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

  export default {
    name: "Stretching",
    components: {
      Header,
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
        effectimg: 'Bad.png',
        iseffect: true,
        iseffect2: false,
        excellentAudio: null,
        greatAudio: null,
        goodAudio: null,
        spaceFlag: true,
        results: {
          'excellentCnt': 0,
          'greatCnt': 0,
          'goodCnt': 0,
          'badCnt': 0,
        },
        resultModal: false,
        nextURL: '',
        timeValue: 0,
        nextPlayInterval : {}
      };
    },
    methods: {
      getgreatThresh() {
        return this.greatThresh;
      },
      everySecondTrigger() {
        this.$nextTick(function () {
          const a = window.setInterval(() => {
            if (window.done) {
              this.resultModal = true;
              window.clearInterval(a);
              window.playFlag = false;
              this.nextPlaySetInterval();
            }
            this.cam_poses = window.cam_poses
            this.video_poses = window.poses
            try {
              this.cosineSimilarity = poseSimilarity(this.cam_poses[0].pose, this.video_poses[0].pose, {
                strategy: 'cosineSimilarity'
              });

              window.cosineSimilarity = this.cosineSimilarity
              if (window.playFlag === true) {
                this.iseffect = !this.iseffect
                this.iseffect2 = !this.iseffect2
                if (this.cosineSimilarity >= this.excellentThresh * 0.01) {
                  this.score = 'Excellent'
                  this.excellentAudio.play();
                  this.greatAudio.pause();
                  this.goodAudio.pause();
                  this.effectimg = 'Excellent.png'
                  this.results['excellentCnt'] += 1;
                } else if (this.cosineSimilarity >= this.greatThresh * 0.01) {
                  this.score = 'Great'
                  this.greatAudio.play()
                  this.excellentAudio.pause();
                  this.goodAudio.pause();
                  this.effectimg = 'Great.png'
                  this.results['greatCnt'] += 1;
                } else if (this.cosineSimilarity >= this.goodThresh * 0.01) {
                  this.score = 'Good'
                  this.goodAudio.play();
                  this.greatAudio.pause();
                  this.excellentAudio.pause();
                  this.effectimg = 'Good.png'
                  this.results['goodCnt'] += 1;
                } else {
                  this.score = 'Hmm...'
                  this.excellentAudio.pause();
                  this.greatAudio.pause();
                  this.goodAudio.pause();
                  this.effectimg = 'Bad.png'
                  this.results['badCnt'] += 1;
                }
              } else {
                this.excellentAudio.pause();
                this.greatAudio.pause();
                this.goodAudio.pause();
              }
            } catch (err) {
              this.score = 'Hmm...'
              this.greatAudio.pause();
              this.excellentAudio.pause();
              this.goodAudio.pause();
              this.effectimg = 'Bad.png'
              if (window.playFlag === true) {
                this.results['badCnt'] += 1;
              }
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
            window.endOfVideo = res.data.time;
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
            if (window.playFlag === true && window.done === false) {
              window.playFlag = false
              vm.spaceFlag = true
            } else {
              window.playFlag = true
              vm.spaceFlag = false
            }
          }
        }
      },
      moveNext() {
        // this.$router.push(window.next)
        window.location = 'http://localhost:8080' + window.next  
      },
      moveMain() {
        window.location = 'http://localhost:8080/main/'
      },
      nextPlaySetInterval(){
        this.nextPlayInterval = setInterval(() => {
        if (this.timeValue === 100) {
          window.location = 'http://localhost:8080' + window.next  
          }
          console.log(this.timeValue)
          this.timeValue += 20
        }, 1000)
      }
    },
    mounted() {
      this.$store.dispatch('isLogin')
      .then((res) => {
        if (!res) {
          this.$router.push('/login')
        }
      })
      .catch(() => {
        this.$router.push('/')
      })
      this.excellentAudio = document.getElementById("excellentAudio");
      this.greatAudio = document.getElementById("greatAudio");
      this.goodAudio = document.getElementById("goodAudio");

      this.pressSpaceBar();
      this.getVideo();
      this.everySecondTrigger();
    },
    computed: {
      classeffect() {
        // const a = this.effectList[Math.floor(Math.random() * this.effect.length)]
        // return {
        //   bounceIn : this.effectList[0] === a,
        //   jackInTheBox : this.effectList[1] === a,
        //   heartBeat : this.effectList[2] === a
        return {
          bounceIn: this.iseffect,
          jackInTheBox: this.iseffect2
        }
      },
      getEffectImg() {
        return require('../assets/' + this.effectimg)
      },
    },
    destroyed() {
      location.reload();
    },
    beforeDestroy() {
      clearInterval(this.nextPlayInterval)
    }
  }
</script>
<style>
  canvas {
    width: 100px;
    height: 100px;
    background-color: yellow;
    display: inline-block;
  }
  #videoBox {
    width: 1300px;
    text-align: center;
  }
  .scoreLine {
    display: inline;
    max-height: 10vh;
    font-family: 'Audiowide', cursive;
    font-size: 5em;
    color: white;
  }
</style>