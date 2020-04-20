<script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.7.3/p5.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.7.3/addons/p5.dom.min.js"></script>
<!-- load ml5.js -->
<script src="https://unpkg.com/ml5@0.2.3/dist/ml5.min.js" type="text/javascript"></script>
<!-- calculate similarity between two poses -->
<script src="https://cdn.jsdelivr.net/npm/posenet-similarity/dist/posenet-similarity.min.js"></script>

<template>
	<div>
		<h1>PoseNet demo with Ml5.js</h1>
		<p id="status">Loading Model...</p>
		<div id="videoContainer"></div>
		<!-- <div id="videoContainer2"></div> -->
		<!-- <Trainer /> -->
		{{ poses }}
	</div>
</template>

<script>
	// import Trainer from './Trainer.vue'
	export default {
		name: 'Webcam',
		components: {
			// Trainer
		},
		data() {
			return {
				poses: poses,
			}
		},
		methods: {
			everySecondTrigger() {
				this.$nextTick(function () {
					window.setInterval(() => {
						this.poses = poses
					}, 1);
				})
			}
		},
		mounted() {
			this.everySecondTrigger()
		},
	}
</script>

<style>
	#videoContainer2 {
		width: 640px;
		display: inline-block;
	}
</style>