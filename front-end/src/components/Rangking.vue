<template>
  
  <v-container>
    <v-row>
      <v-col class="col-4">
        <v-img class="max-small" src="@/assets/giphy.gif" alt="dacingWhale">
          <h1 class="ranking text-white">랭킹</h1>
        </v-img>
      </v-col>
      <v-col class="col-8 d-flex align-center">
        <div class="ranking-desc">
          <h2 class="text-white">{{ user.name }}님!</h2>
          <h3 class="text-white dis-inline"><h2 class="text-white dis-inline">(총 유저수)</h2> 중 <h2 class="text-white dis-inline">(랭킹)</h2>번째로 스트레칭을 열심히 하셨네요!</h3>
        </div>
      </v-col>
    </v-row>
  </v-container>
  
</template>

<script>
export default {
    name: 'Rangking',
    computed: {
      user() {
        return this.$store.state.auth.user
      }
    }
}
</script>

<style>
.max-small {
    width: auto; height: auto;
    max-width: 385px;
    max-height: 360px;
    border-radius: 50%;
    border: 3px solid rgb(64, 85, 212);
}
.ranking {
  position: absolute;
  left: 50%; 
  top: 50%;
  transform: translate(-50%,-50%);
}
.text-white {
  color: white;
}
.dis-inline {
  display: inline;
}
</style>