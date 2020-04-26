<template>
  <div>
      <Header></Header>
			<h1>ㅇㅇ님의 스트레칭 수행 내역입니다!!</h1>
			<h2>2020-04-23 16:25</h2>
			<h3>평균 consine similarity: </h3>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'

  export default {
    name: 'Result',
    components: {
			Header
    },
    data() {
      return {
        tmp: [],
      }
    },
    mounted() {

    }
  }
</script>