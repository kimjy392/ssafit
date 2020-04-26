<template>
  <div>
    <Header></Header>
    <div class="ml-auto mr-12" style="width: 3em;">
      <v-tooltip bottom>
        <template v-slot:activator="{ on }">
          <v-btn 
            icon x-large color="#ff7235" 
            v-on='on' 
            v-on:mouseover='mouseover' 
            v-on:mouseleave="mouseleave"
            @click.stop="dialog = true"
          >
            <v-icon id="helpIcon">{{ questionMark }}</v-icon>
          </v-btn>
        </template>
        <span>도움말</span>
      </v-tooltip>
    </div>
    <v-dialog elevation-0 v-model="dialog" max-width="70vw">
      <HelpCard></HelpCard>
    </v-dialog>
    <h1>Score: {{ score }}</h1>
    <v-img class="animated mx-auto" width="500" height="200" :class="classeffect" :src="getEffectImg"></v-img>
    <v-card id="vidioBox" class="mx-auto">
      <div id="videoContainer"></div>
    </v-card>
    <div class='sketch' id="sketch"></div>
    <div class="my-6"></div>
    <div style="text-align: center">
      <v-btn x-large color="#ff7235">
        시작하려면 스페이스바를 누르세요
      </v-btn>
    </div>
    <h1> {{ cosineSimilarity }} </h1>
    <audio controls autoplay>
      <source src="../assets/backgroundMusic.mp3" type="audio/mpeg">
    </audio>
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
        effectimg: 'Bad.png',
        iseffect : true,
        iseffect2 : false
      };
    },
    methods: {
      getgreatThresh(){
        return this.greatThresh;
      },
      everySecondTrigger() {
        this.$nextTick(function () {
          window.setInterval(() => {
            this.cam_poses = window.cam_poses
            this.video_poses = window.poses
            try {
              this.cosineSimilarity = poseSimilarity(this.cam_poses[0].pose, this.video_poses[0].pose, {
                strategy: 'cosineSimilarity'
              });
              this.iseffect = !this.iseffect
              this.iseffect2 = !this.iseffect2
              window.cosineSimilarity = this.cosineSimilarity
              if (this.cosineSimilarity >= this.excellentThresh * 0.01) {
                this.score = 'Excellent'
                this.effectimg = 'Excellent.png'
              } else if (this.cosineSimilarity >= this.greatThresh * 0.01) {
                this.score = 'Great'
                this.effectimg = 'Great.png'
              } else if (this.cosineSimilarity >= this.goodThresh * 0.01) {
                this.score = 'Good'
                this.effectimg = 'Good.png'
              } else {
                this.score = 'Hmm...'
                this.effectimg = 'Bad.png'
              }
            } catch (err) {
              this.score = 'Hmm...'
              this.effectimg = 'Bad.png'
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
      mouseover() {
        this.questionMark = 'fas fa-question-circle'
      },
      mouseleave() {
        this.questionMark = 'far fa-question-circle'
      },
    },
    mounted() {
      if (localStorage.getItem('reloaded')) {
        localStorage.removeItem('reloaded');
      } else {
        localStorage.setItem('reloaded', '1');
        location.reload();
      }
      this.getVideo()
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
          bounceIn : this.iseffect,
          jackInTheBox : this.iseffect2
        }
      },
      getEffectImg() {
        return require('../assets/' + this.effectimg)
      } 
    }
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