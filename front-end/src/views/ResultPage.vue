<template>
  <div>
      <Header></Header>
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