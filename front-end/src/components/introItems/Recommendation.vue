<template>
  <section id="blog">
        <div class="py-12"></div>

        <v-container>
          <h2 class="display-2 font-weight-bold mb-3 text-uppercase text-center white--text">Recommendation Video</h2>

          <v-responsive
            class="mx-auto mb-12"
            width="56"
          >
            <v-divider class="mb-1"></v-divider>
            <v-divider></v-divider>
          </v-responsive>

          <v-row>
            <v-col
              v-for="({ src, text, title, link }, i) in articles"
              :key="i"
              cols="12"
              md="4"
            ><a :href="link" target="_blank">
              <v-img
                :src="require('@/assets/' + src)"
                class="mb-4"
                height="275"
                max-width="100%"
              ></v-img>
            </a>
              <h2
                class="font-weight-black mb-4 text-uppercase white--text"
                v-text="title"
              ></h2>

              <div
                class="title font-weight-light mb-5 white--text"
                v-text="text"
              ></div>
            </v-col>
          </v-row>
        </v-container>

        <div class="py-12"></div>
      </section>
</template>

<script>
export default {
  name: "Recommendation",
  data() {
    return {
      articles: [
          {
            src: 'thumbnail1.jpg',
            title: '거북목 꿀팁',
            text: '거북목이 하면 좋은 20초 마약 마사지',
            link: 'https://www.youtube.com/watch?v=5g9tnM10Plc'
          },
          {
            src: 'thumbnail2.jpg',
            title: '인생의 틀을 깬 재키인생!',
            text: '이달의 JMG, 재키마스터 킹브로/최호근',
            link: 'https://edu.ssafy.com/'
          },
          {
            src: 'thumbnail3.jpg',
            title: '거북목? 딱 15초만 투자하자!',
            text: '피지컬갤러리의 빡빡이 아저씨가 알려주는 거북목 방지 스트레칭',
            link: 'https://www.youtube.com/watch?v=qmP-fOevW1s'
          },
        ],
    }
  }
}
</script>

<style>

</style>