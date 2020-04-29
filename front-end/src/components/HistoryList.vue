<template>
  <History :userhistory="userhistory"></History>
</template>

<script>
import History from '@/components/History.vue'
export default {
    name: 'HistoryList',
    props: {
      userhistory: {
        type: Array,
        default: () => ([])
      }
    },
    components: {
        History
    },
}
</script>

<style>

</style>