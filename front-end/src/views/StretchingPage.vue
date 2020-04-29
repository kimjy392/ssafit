<template>
  <div class="stretchPage">
    <Header></Header>
    <div>
      <div style="position: fixed; left: 0; bottom:0; z-index: 2;">
        <audio id="backgroundMusic" autoplay>
          <source src="../assets/backgroundMusic.mp3" type="audio/mpeg">
        </audio>
        <audio v-if="started" autoplay>
          <source src="../assets/papagoStartStretching.mp3" type="audio/mpeg">
        </audio>
        <audio id="excellentAudio" crossOrigin="anonymous">
          <source src="../assets/excellent.mp3" type="audio/mpeg">
        </audio>
        <audio id="greatAudio" crossOrigin="anonymous">
          <source src="../assets/great.mp3" type="audio/mpeg">
        </audio>
        <audio id="goodAudio" crossOrigin="anonymous">
          <source src="../assets/good.mp3" type="audio/mpeg">
        </audio>
        <audio id="badAudio" crossOrigin="anonymous">
          <source src="../assets/bad.mp3" type="audio/mpeg">
        </audio>
        <audio id="measureAudio" crossOrigin="anonymous">
          <source src="../assets/startMeasure.mp3" type="audio/mpeg">
        </audio>
      </div>
    </div>
    <v-img id="effectImgs" class="useAnimated animated mx-auto" width="500" :class="classeffect" :src="getEffectImg"></v-img>
    <!-- <div style="height: 20vh"></div> -->
    <v-card id="videoBox" class="mx-auto">
      <div class="pt-3">
        <span class="stretchingTitle">{{ title }}</span>
        <span class="stretchingDesc">:{{ description }}</span>
      </div>
      <img 
      id="finger" 
      class="useAnimated animated fadeInUp infinite fulse"
      v-if="stretchReady"
      src="@/assets/finger.png" 
      alt="손가락">
      <img id="stretchReadyImg" v-if="stretchReady" src="@/assets/stretch_ready.png" alt="스트레칭 준비">
      <div id="videoContainer"></div>
    </v-card>
    <div class='sketch' id="sketch"></div>
    <div class="my-6"></div>
    <div style="text-align: center">
      <v-btn v-if="spaceFlag" id="spacebar" x-large color="#45b6fe" class="white--text">
        스페이스바를 누르면 시작합니다!
      </v-btn>
      <v-btn v-if="!spaceFlag" id="spacebar" x-large color="#45b6fe" class="white--text">
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
        <div class="container" style="text-align: center; width: 100%;">
          <div class="my-12"></div>
          <div class="scoreLine col-6"><img src="@/assets/Result.png" alt="Result"></div>
          <div class="my-12"></div>
          <div class="row">
            <div class="scoreLine col-6"><img src="@/assets/Excellent.png" alt="Excellent"></div>
            <div class="scoreLine col-6">{{ results['excellentCnt'] }} pt</div>
          </div>
          <div class="row">
            <div class="scoreLine col-6"><img src="@/assets/Great.png" alt="Great"></div>
            <div class="scoreLine col-6">{{ results['greatCnt'] }} pt</div>
          </div>
          <div class="row">
            <div class="scoreLine col-6"><img src="@/assets/Good.png" alt="Good"></div>
            <div class="scoreLine col-6">{{ results['goodCnt'] }} pt</div>
          </div>
          <div class="row">
            <div class="scoreLine col-6"><img src="@/assets/Bad.png" alt="Bad"></div>
            <div class="scoreLine col-6">{{ results['badCnt'] }} pt</div>
          </div>
          <div class="my-12"></div>
          <a @click="moveNext">
            <v-progress-circular
              id="nextBtn"
              :rotate="-90"
              :size="150"
              :width="15"
              :value="timeValue"
              color="white"
            >
            <div>
              <v-icon color="white">fas fa-play</v-icon>
              <br>
              <span>다음영상</span>
            </div>
            </v-progress-circular>
          </a>
          <v-btn x-large rounded color="white" @click="moveMain">끝내기</v-btn>
        </div>
        </v-card>
      </div>
    </v-dialog>
    <img style="z-index: 3;" id="vegetableChar" src="@/assets/hutdool.gif" alt="헛둘">
    <img id="vegetableChar" src="@/assets/vegetable.gif" alt="야채">
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
        title: '',
        description: '',
        cam_poses: 0,
        video_poses: 0,
        cosineSimilarity: 0,
        excellentThresh: 100,
        greatThresh: 100,
        goodThresh: 100,
        score: 'Hmm...',
        effectimg: 'ready.png',
        iseffect: true,
        iseffect2: false,
        excellentAudio: null,
        greatAudio: null,
        goodAudio: null,
        badAudio: null,
        measureAudio: null,
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
        nextPlayInterval : {},
        started: false,
        stopSeconds: 3,
        stretchReady: true,
        imgSrc: '',
        circularMouseOn: false,
      };
    },
    methods: {
      getgreatThresh() {
        return this.greatThresh;
      },
      everySecondTrigger() {
        this.$nextTick(function () {
          const a = window.setInterval(() => {
            this.haveToDisplay = false
            this.time = window.t;
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
              if (window.playFlag === true  && (window.firstStopFlag === false || window.secondStopFlag === false)) {
                this.iseffect = !this.iseffect
                this.iseffect2 = !this.iseffect2
                if (this.cosineSimilarity >= this.excellentThresh * 0.01) {
                  this.score = 'Excellent'
                  this.excellentAudio.play();
                  this.greatAudio.pause();
                  this.goodAudio.pause();
                  this.badAudio.pause();
                  this.effectimg = 'Excellent.png'
                  this.results['excellentCnt'] += 1;
                } else if (this.cosineSimilarity >= this.greatThresh * 0.01) {
                  this.score = 'Great'
                  this.greatAudio.play()
                  this.excellentAudio.pause();
                  this.goodAudio.pause();
                  this.badAudio.pause();
                  this.effectimg = 'Great.png'
                  this.results['greatCnt'] += 1;
                } else if (this.cosineSimilarity >= this.goodThresh * 0.01) {
                  this.score = 'Good'
                  this.goodAudio.play();
                  this.greatAudio.pause();
                  this.excellentAudio.pause();
                  this.badAudio.pause();
                  this.effectimg = 'Good.png'
                  this.results['goodCnt'] += 1;
                } else {
                  this.score = 'Hmm...'
                  this.badAudio.play();
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
                this.badAudio.pause();
              }
            } catch (err) {
              this.score = 'Hmm...'
              this.greatAudio.pause();
              this.excellentAudio.pause();
              this.goodAudio.pause();
              this.badAudio.pause();
              if (window.playFlag === true && (window.firstStopFlag === false || window.secondStopFlag === false)) {
                this.effectimg = 'Bad.png';
                this.results['badCnt'] += 1;
              }
            }
          }, 1600);
        });
      },
      stopPointTrigger() {
        var vm = this;
        this.$nextTick(function () {
          window.setInterval(() => {
            if (window.playFlag === true && window.alarmFlag === true) {
              vm.measureAudio.play();
              this.effectimg = 'count0.png';
              this.getEffectImg();
            }
          }, 1000);
        });
      },
      getVideo() {
        axios.get('http://i02b104.p.ssafy.io:8197/ssafyvue/api/stretching/detail/' + this.$route.params.id)
          .then((res) => {
            this.title = res.data.title
            this.description = res.data.description
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
            if (vm.started === false) {
              vm.spaceFlag = false
              vm.started = true
              vm.stretchReady = false
              setTimeout(function () {
                window.playFlag = true
              }, 3000);
            } else if (window.playFlag === true && window.done === false) {
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
          this.timeValue += 5
        }, 500)
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

      var backgroundMusic = document.getElementById("backgroundMusic");
      backgroundMusic.volume = 0.1;

      this.excellentAudio = document.getElementById("excellentAudio");
      this.greatAudio = document.getElementById("greatAudio");
      this.goodAudio = document.getElementById("goodAudio");
      this.badAudio = document.getElementById("badAudio");
      this.measureAudio = document.getElementById("measureAudio");

      this.pressSpaceBar();
      this.getVideo();
      this.everySecondTrigger();
      this.stopPointTrigger();
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
    },
    circularMouseOver() {
      this.circularMouseOn = true;
    },
    circularMouseleave() {
      this.circularMouseOn = false;
    }
  }
</script>
<style>
  .stretchPage {
    background-image: url('../assets/stretch_bg.png');
  }
  canvas {
    width: 100px;
    height: 100px;
    background-color: yellow;
    display: inline-block;
  }
  #videoBox {
    width: 1300px;
    background-color: #45b6fe;
    text-align: center;
  }
  .scoreLine {
    display: inline;
    max-height: 10vh;
    font-family: 'Audiowide', cursive;
    font-size: 5em;
    color: white;
  }
  .useAnimated {
    position: fixed;
    top: 20vh;
    z-index: 1;
    left: 0;
    right: 0;
  }
  #stretchReadyImg {
    position: absolute;
    left: 10px;
    bottom: 6px;
  }
  #finger {
    position: absolute;
    z-index: 2;
    height: 200px;
    top: 30vh;
    left: 250px;
  }
  .stretchingTitle {
    left: 10vw;
    top: 15vh;
    color: white;
    font-size: 3rem;
    font-family: 'Black Han Sans', sans-serif;
  }
  .stretchingDesc {
    color: white;
    font-size: 2rem;
    font-family: 'Black Han Sans', sans-serif;
  }
  #countImg {
    position: absolute;
    z-index: 2;
    top: 38%;
    left: 0;
    right: 0;
  }
  #countImg > img {
    height: 120px;
  }
  #vegetableChar {
    position: fixed;
    left: 20px;
    width: 340px;
    bottom: -5vh;
  }
  #nextBtn {
    position: fixed;
    top: 40vh;
    margin-left: auto;
    margin-right: auto;
  }
  #effectImgs {
    position: fixed;
    top: 50vh;
    left: 0;
    right: 0;
  }
</style>