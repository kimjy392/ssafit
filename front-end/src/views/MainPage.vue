<template>
  <div>
    <Header></Header>
    <v-form>
      <v-container>
        <v-row>
          <v-col cols="12" sm="6">
            <v-text-field filled prepend-inner-icon="search" rounded dense></v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
    <div>
      <v-row>
        <!-- {{ vedioList }} -->
        <vedio-list v-for="(value, key) in vedioList" :categoryName="key" :vedioList="value" :key="key">
        </vedio-list>
      </v-row>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import Header from '@/components/Header.vue'
  import vedioList from '@/components/VedioList.vue'

  export default {
    name: 'Main',
    components: {
      Header,
      vedioList
    },
    data() {
      return {
        vedioList: {},
      }
    },
    mounted() {
      axios.get('http://i02b104.p.ssafy.io:8197/ssafyvue/api/' + 'stretching')
        .then(response => {
          this.vedioList = response.data
          console.log(response.data)
        })
        .catch(error => {
          console.log(error)
        })
    }
  }
</script>