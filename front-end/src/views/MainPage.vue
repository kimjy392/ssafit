<template>
  <div>
    <Header></Header>
    <v-form>
      <v-container>
        <v-row>
          <v-col cols="12" sm="6">
            <v-text-field 
            filled 
            prepend-inner-icon="search"
            rounded
            dense
            ></v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </div>
</template>

<script>
  import Header from '@/components/Header.vue'

  export default {
    name: 'Main',
    components: {
      Header
    }
  }
</script>