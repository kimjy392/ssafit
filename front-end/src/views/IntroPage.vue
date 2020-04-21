<template>
  <div>
    <Header></Header>
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

                <v-btn class="ma-2" color="primary" dark :to="path">로그인
                </v-btn>
              </v-row>
            </v-container>
          </v-theme-provider>
        </v-img>
      </v-row>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'

export default {
	name: 'Intro',
  components: {
    Header,
  },
  data() {
		return {
      path: '/login'
		}
	}
}
</script>

<style>

</style>