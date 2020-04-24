<template>
  <div>
    <Header></Header>
      <section id="hero">
        <v-row no-gutters>
          <v-img
            :min-height="'calc(100vh - ' + $vuetify.application.top + 'px)'"
            src="https://images.unsplash.com/photo-1487017159836-4e23ece2e4cf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1951&q=80"
          >
            <v-theme-provider dark>
              <v-container fill-height>
                <v-row
                  align="center"
                  class="white--text mx-auto"
                  justify="center"
                >
                  <v-col
                    class="white--text text-center"
                    cols="12"
                    tag="h1"
                  >
                    <span
                      class="font-weight-light"
                      :class="[$vuetify.breakpoint.smAndDown ? 'display-1' : 'display-2']"
                    >
                      WELCOME TO
                    </span>

                    <br>

                    <span
                      :class="[$vuetify.breakpoint.smAndDown ? 'display-3': 'display-4']"
                      class="font-weight-black"
                    >
                      VUETIFY
                    </span>

                  </v-col>

                  <v-btn
                    class="align-self-end"
                    fab
                    outlined
                    @click="$vuetify.goTo('#about-me')"
                  >
                    <v-icon>mdi-chevron-double-down</v-icon>
                  </v-btn>
                </v-row>
              </v-container>
            </v-theme-provider>
          </v-img>
        </v-row>
      </section>
      <div class="py-12"></div>
      <Effect></Effect>
      <div class="py-12"></div>
      <Explanation></Explanation>
      <div class="py-12"></div>
      <Statistic></Statistic>
      <div class="py-12"></div>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Effect from '@/components/Effect.vue'
import Explanation from '@/components/Explanation.vue'
import Statistic from '@/components/Statistic.vue'

export default {
	name: 'Intro',
  components: {
    Header,
    Effect,
    Explanation,
    Statistic,
  },
  data() {
		return {
      path: '/login'
		}
  },
  mounted() {
    this.$store.dispatch('isLogin', true)
  }
}
</script>

<style>
  #intro_backimg {
    position: absolute;
    top: -64px;
  }
</style>