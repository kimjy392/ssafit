<template>
  <div class="charDiv">
      <img class="charImg" src="@/assets/turtle_fire.gif" alt="">
  </div>
</template>

<script>
export default {
    name: 'CharacterBox',
}
</script>

<style>
  .charDiv {
    width: 250px;
    background-color: white;
    border: 5px solid rgb(253, 122, 58);
  }
  .charImg {
    width: 100%;
    height: 100%;
  }
</style>