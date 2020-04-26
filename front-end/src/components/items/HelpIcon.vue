<template>
  <div class="ml-5" style="width: 2em;">
    <v-tooltip bottom>
      <template v-slot:activator="{ on }">
        <v-btn icon x-large color="#ff7235" v-on='on' v-on:mouseover='mouseover' v-on:mouseleave="mouseleave"
          @click.stop="dialog = true">
          <v-icon id="helpIcon">{{ questionMark }}</v-icon>
        </v-btn>
      </template>
      <span>도움말</span>
    </v-tooltip>
    <v-dialog elevation-0 v-model="dialog" max-width="70vw">
      <HelpCard></HelpCard>
    </v-dialog>
  </div>
</template>

<script>
  import HelpCard from '@/components/items/HelpCard.vue';

  export default {
    name: 'HelpIcon',
    components: {
      HelpCard,
    },
    data() {
      return {
        dialog: false,
        questionMark: 'far fa-question-circle',
      }
    },
    methods: {
      mouseover() {
        this.questionMark = 'fas fa-question-circle'
      },
      mouseleave() {
        this.questionMark = 'far fa-question-circle'
      }
    }
  }
</script>

<style>
  #helpIcon {
    font-size: 3em;
  }
  .v-dialog {
    box-shadow: none !important;
  }
</style>