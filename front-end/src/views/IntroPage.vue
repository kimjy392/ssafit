<template>
  <div id="intro">
    <Header :isIntro="true"></Header>
      <section id="hero">
        <v-row no-gutters>
          <v-img
          width="100%"
          height="100%"
            src="../assets/intro_bg.png"
          >
          <v-container fill-height>
            <v-row
                  align="center"
                  class="mx-auto"
                  justify="center"
                >
                  <v-col
                    cols="12"
                  >
                    <v-img class="animated fadeInLeft" width="70%" height="70%" src="../assets/logo_test.png"></v-img>
                  </v-col>
                
                  <v-btn
                    class="align-self-end"
                    fab
                    outlined
                    color="white"
                    @click="$vuetify.goTo('#Effect')"
                  >
                    <v-icon color="white">mdi-chevron-double-down</v-icon>
                  </v-btn>
                </v-row>
              </v-container>
          </v-img>
        </v-row>
      </section>
      <div class="py-12"></div>
      <Effect id="Effect"></Effect>
      <div class="py-12"></div>
      <Explanation id="Explanation"></Explanation>
      <div class="py-12"></div>
      <Statistic id="Statistic" :statistic="statistic"></Statistic>
      <div class="py-12"></div>
      <Recommendation id="Recommendation"></Recommendation>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Effect from '@/components/introItems/Effect.vue'
import Explanation from '@/components/introItems/Explanation.vue'
import Statistic from '@/components/introItems/Statistic.vue'
import Recommendation from'@/components/introItems/Recommendation.vue'
import axios from 'axios'
export default {
	name: 'Intro',
  components: {
    Header,
    Effect,
    Explanation,
    Statistic,
    Recommendation,
  },
  data() {
		return {
      path: '/login',
      statistic: {}
		}
  },
  methods: {
    getStatistics() {
      axios.get('http://i02b104.p.ssafy.io:8197/ssafyvue/api/intro/')
      .then((res) => {
        this.statistic = res.data
      })
      .catch(() => {
      })
    }
  },
  mounted() {
    this.$store.dispatch('isLogin')
    this.getStatistics()
  }
}
</script>

<style>
  #intro {
    background-color: #556AE9;
  }
</style>