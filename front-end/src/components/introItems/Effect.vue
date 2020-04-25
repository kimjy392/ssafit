<template>
  <v-container>

    <h2 class="display-2 font-weight-bold mb-3 text-center">STRETCH</h2>

    <v-responsive
      class="mx-auto mb-8"
      width="56"
    >
      <v-divider class="mb-1"></v-divider>

      <v-divider></v-divider>
    </v-responsive>

    <v-row>
      <v-col cols="6">
        <v-row class="justify-start">
          <v-hover
        v-slot:default="{ hover }"
        open-delay="200"
      >
      <v-sheet :elevation="hover ? 16 : 2">
          <div class="px-3 py-3">
        <span class="title mb-2">스트레스 해소</span>
        <v-divider></v-divider>
        <span>쌓인 스트레스를 마땅히 해소할 무언가가 없다면 스트레칭을 하자. 스트레칭을 하면 스트레스를 받는 상황이나 생각에서 벗어나 몸에 온전히 집중할 수 있다. 또한 스트레스로 인해 긴장된 근육을 이완시키는 데 도움이 되며, 엔도르핀을 방출해 스트레스 지수를 낮추고 평온한 기분을 느낄 수 있다.</span>
          </div>
      </v-sheet>
      </v-hover>
        </v-row>
      </v-col>
      <v-col cols="6">
        <v-row class="justify-start">
        </v-row>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="6">
        <v-row class="justify-start">
        </v-row>
      </v-col>
      <v-col cols="6">
        <v-row class="justify-start">
           <v-hover
        v-slot:default="{ hover }"
        open-delay="200"
      >
          <v-sheet :elevation="hover ? 16 : 2">
          <div class="px-3 py-3">
        <span class="title mb-2">체중 감량</span>
        <v-divider></v-divider>
        <span>다이어트를 하고 있다면 매일 스트레칭을 해보도록 하자. 스트레칭을 하면 신진대사를 올릴 수 있고, 칼로리 소모량도 크게 늘어난다. 다이어트에 도움이 되는 스트레칭 동작은 여러 가지가 있으며, 폼롤러 등의 홈트레이닝 기구를 이용한 스트레칭 동작도 도움이 된다.</span>
          </div>
          </v-sheet>
           </v-hover>
        </v-row>
      </v-col>
    </v-row>

     <v-row>
      <v-col cols="6">
        <v-row class="justify-start">
           <v-hover
        v-slot:default="{ hover }"
        open-delay="200"
      >
          <v-sheet :elevation="hover ? 16 : 2">
          <div class="px-3 py-3">
        <span class="title mb-2">피로 회복</span>
        <v-divider></v-divider>
        <span>피로감이 가시지 않을 때 가벼운 스트레칭을 하면 피로 회복 효과를 기대할 수 있다. 우리 몸은 피로해지면 근육이 조여들어 피로감이 더욱 증가하는데, 이럴 때 스트레칭을 하면 딱딱한 근육을 풀어주는 것은 물론이고 혈류량을 증가시켜 에너지 레벨을 올려준다.</span>
          </div>
          </v-sheet>
           </v-hover>
        </v-row>
      </v-col>
      <v-col cols="6">
        <v-row class="justify-start">
        </v-row>
      </v-col>
    </v-row>

     <v-row>
      <v-col cols="6">
        <v-row class="justify-start">
        </v-row>
      </v-col>
      <v-col cols="6">
        <v-row class="justify-start">
           <v-hover
        v-slot:default="{ hover }"
        open-delay="200"
      >
          <v-sheet :elevation="hover ? 16 : 2">
           <div class="px-3 py-3">
        <span class="title mb-2">자세 교정</span>
        <v-divider></v-divider>
        <span>잘못된 자세를 교정할 때도 스트레칭만큼 좋은 것이 없다. 스트레칭을 하면 좋지 않은 자세를 초래하는 대표적인 원인인 등 근육과 어깨 근육을 풀어주어 도움이 된다. 이 외에도 출산 후 틀어진 골반 교정이나 어깨 비대칭, 거북목 등에 도움이 되는 스트레칭을 꾸준히 하면 자세가 교정되는 효과를 기대할 수 있다.</span>
          </div>
          </v-sheet>
           </v-hover>
        </v-row>
      </v-col>
    </v-row>

    <div></div>

  </v-container>
</template>

<script>
export default {
  name: "Effect",
}
</script>

<style>

</style>