<template>
  <v-content>
    <Header></Header>
    <section id="hero">
      <v-row no-gutters>
        <v-img
          :height="'calc(100vh - ' + $vuetify.application.top + 'px)'"
          src="https://i0.wp.com/www.kintec.net/wp-content/uploads/2017/05/blogheader.jpg?fit=2000%2C1000&ssl=1"
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
                    설명설명
                  </span>

                  <br>

                  <span
                    :class="[$vuetify.breakpoint.smAndDown ? 'display-3': 'display-4']"
                    class="font-weight-black"
                  >
                    설명
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
  </v-content>
</template>

<script>
import Header from '@/components/Header.vue'

export default {
	name: 'Intro',
  components: {
    Header,
  }
}
</script>

<style>

</style>