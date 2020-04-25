<template>
  <div>
      <Header></Header>
			<h1>ㅇㅇ님의 스트레칭 수행 내역입니다!!</h1>
			<h2></h2>
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