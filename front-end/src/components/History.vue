<template>
  <div >
    <v-row justify="center" height="150px" v-for="i in userhistory.length > 3 ? 3 : userhistory.length" :key="i">
      <v-col cols="4" class="pr-0" height="150px">
        <v-img class="thum-section" height="200" width="200" :src="userhistory[i-1].thumbnail">
        </v-img>
      </v-col>

      <v-col cols="7" class="text-start pl-0 ">
        <v-row style="background-color: white;" class="flex-column ma-0 fill-height px-3 py-3 desc-section"
          justify="center">
          <v-col class="px-0">
            <v-btn icon color="#FF7033">
              <v-icon>mdi-heart</v-icon>
            </v-btn>
            <h3 style="display: inline-block; color:#FF7033;">{{ userhistory[i-1].title }}</h3>
          </v-col>

          <v-col class="px-0 description">
            {{ userhistory[i-1].description }}
          </v-col>

          <v-col class="px-0">
            {{ userhistory[i-1].date }}
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>

<script>
  export default {
    name: 'History',
    props: {
      userhistory: {
        type: Array,
        default: () => ([])
      }
    },
  }
</script>

<style>
  .desc-section {
    border-radius: 0 10px 10px 0 / 0 10px 10px 0;
    font-family: 'Noto Sans KR', sans-serif;
  }

  .thum-section {
    border-radius: 10px 0 0 10px / 10px 0 0 10px;
  }
  .description {
    width:100%;
    height: 100%;
    display:-webkit-box;
    word-break:break-word;
    overflow:hidden; 
    text-overflow: ellipsis;
    -webkit-line-clamp:2;
    -webkit-box-orient:vertical;
  }
</style>