<template>
  
  <v-row justify="center" height="150px">
      <v-col cols="4" class="pr-0" height="150px">
        <v-img
          class="thum-section"
          style="background-color:red;"
          height="200"
          width="200"
          src="@/assets/dog_1.gif"
        ></v-img>
      </v-col>

      <v-col
        cols="7"
        class="text-start pl-0 "
      >
        <v-row
          style="background-color: white;"
          class="flex-column ma-0 fill-height px-3 py-3 desc-section"
          justify="center"
        >
          <v-col class="px-0">
            <v-btn icon color="#FF7033">
              <v-icon>mdi-heart</v-icon>
            </v-btn>
            <h3 style="display: inline-block; color:#FF7033;">제목제목</h3>
          </v-col>

          <v-col class="px-0">
                <!-- <- 이부분 딱 두라인만 나올수있도록! -->
            설명
            설명
          </v-col>

          <v-col class="px-0">
            날짜날짜
            
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  
</template>

<script>
export default {
    name: 'History',
    data() {
      return {
        title: '허리비틀기',
        thumnail : 'https://img.chuing.net/i/QyyVHGH/con-20-1030x781.jpg',
        desicription : 'hihihihi'
      }
  },
  methods: {

  },

}
</script>

<style>
.desc-section {
  border-radius: 0 10px 10px 0 / 0 10px 10px 0;
}
.thum-section {
  border-radius: 10px 0 0 10px / 10px 0 0 10px;
}
</style>