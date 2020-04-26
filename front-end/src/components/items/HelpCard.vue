<template>
  <div style="height: 75vh; width:70vw">
    <v-card
      id="control"
      class="mx-auto"
    >
      <v-btn @click="previousSlide" id="up-button" v-on:mouseover="upmouseover" v-on:mouseleave="upmouseleave">
        <v-icon id="up-arrow" :color="upArrowColor">
          expand_less
        </v-icon>
      </v-btn>
      <hr>
      <v-btn @click="nextSlide" icon id="down-button" v-on:mouseover="downmouseover" v-on:mouseleave="downmouseleave">
        <v-icon id="down-arrow" :color="downArrowColor">
          expand_more
        </v-icon>
      </v-btn>
      <div id="page_block">
        <p class="my-3" id="page_number">0{{ page }}  /  02</p>
      </div>
    </v-card>
    <v-card
      id="explan"
      class="mx-auto"
    >
     <div id="slider">
       <div class="slider_item showing"><img width="100%" height="100%" src="@/assets/help_1.png" alt=""></div>
       <div class="slider_item"><img width="100%" height="100%" src="@/assets/help_2.png" alt=""></div>
     </div>
    </v-card>
  </div>
</template>

<script>
export default {
    name: 'HelpCard',
    data() {
      return {
        SHOWING_CLASS: "showing",
        firstSlide: '',
        lastSlide: '',
        page: 1,
        upArrowColor: '#788afa',
        downArrowColor: '#788afa',
      }
    },
    methods: {
      nextSlide() {
        const currentSlide = document.querySelector(`.${this.SHOWING_CLASS}`)
        
        currentSlide.classList.remove(this.SHOWING_CLASS);
        const nextSlide = currentSlide.nextElementSibling;

        if (nextSlide) {
          nextSlide.classList.add(this.SHOWING_CLASS);
          this.page += 1;
        } else {
          this.firstSlide.classList.add(this.SHOWING_CLASS);
          this.page = 1;
        }
      },
      previousSlide() {
        const currentSlide = document.querySelector(`.${this.SHOWING_CLASS}`)

        currentSlide.classList.remove(this.SHOWING_CLASS);
        const previousSlide = currentSlide.previousElementSibling;

        if (previousSlide) {
          previousSlide.classList.add(this.SHOWING_CLASS);
          this.page -= 1;
        } else {
          this.lastSlide.classList.add(this.SHOWING_CLASS);
          this.page = 5;
        }
      },
      upmouseover() {
        this.upArrowColor = '#FF7033'
      },
      upmouseleave() {
        this.upArrowColor = '#788afa'
      },
      downmouseover() {
        this.downArrowColor = '#FF7033'
      },
      downmouseleave() {
        this.downArrowColor = '#788afa'
      }
    },
    mounted() {
      this.firstSlide = document.querySelector("#slider").firstElementChild,
      this.lastSlide = document.querySelector("#slider").lastElementChild
    }
}
</script>

<style>
  #control { 
    height: 60vh;
    width: 60vw;
    text-align: right;
    position:relative;
    border-radius: 20px;
    border: 5px solid rgb(45, 67, 189);
    background-color: rgb(51, 71, 194);
    top: 15vh;
    left: 5vw;
  }
  #explan {
    height: 60vh;
    width: 60vw;
    position:relative;
    border: 5px solid white;
    border-radius: 25px;
    top: -55vh;
    left: -5vw;
  }
  #up-button {
    display: block;
    height: 30%;
    width: 10vw;
    line-height: 100%;
    border-radius: 0 20px 0 0;
    background-color: rgb(64, 85, 212);
    margin-left: auto;
  }
  #up-arrow {
    font-size: 3.5em !important;
  }
  #down-button {
    display: block;
    height: 30%;
    width: 10vw;
    line-height: 100%;
    border-radius: 0;
    background-color: rgb(64, 85, 212);
    margin-left: auto;
  }
  #down-arrow {
    font-size: 3.5em !important;
  }
  #control > hr {
    width: 10vw;
    border: 1px solid rgb(45, 67, 189);
    margin-left: auto;
  }
  #slider{
    width: 100%;
    height: 100%;
    position:relative;
  }
  .slider_item{
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 20px;
    color: rgb(219, 21, 21);
    font-size: 48px;
    position:absolute;
    z-index:0;
    opacity:0;
  }
  .slider_item:nth-child(odd){
    background-color:white;
  }
  .slider_item:nth-child(even){
    background-color:blueviolet;
  }
  .showing{
    z-index:1;
    opacity:1;
  }
  #page_number {
    font-size: 1.5em;
    color: white;
  }
  #page_block {
    display: block;
    height: 30%;
    width: 10vw;
    text-align: center;
    margin-left: auto;
  }
  #slider > div > img {
    border-radius: 20px;
  }
</style>