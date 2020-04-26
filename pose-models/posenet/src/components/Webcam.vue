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
		<!-- <div id="videoContainer1"></div> -->
		<!-- <div id="videoContainer2"></div> -->
		<!-- <Trainer /> -->
		<!-- {{ capturePoses[0].pose.keypoints }} <br> -->
		<h4>weightedDistance: {{ weightedDistance }}</h4>
		<h4>cosineDistance: {{ cosineDistance }}</h4>
		<h1>cosineSimilarity: {{ cosineSimilarity }}</h1>
	</div>
</template>

<script>
import { poseSimilarity } from 'posenet-similarity';

	// import Trainer from './Trainer.vue'
	export default {
		name: 'Webcam',
		components: {
			// Trainer
		},
		data() {
			return {
				capturePoses: capturePoses,
				videoPoses: videoPoses,
				weightedDistance: 0,
				cosineDistance: 0, 
				cosineSimilarity: 0,
			}
		},
		methods: {
			everySecondTrigger() {
				this.$nextTick(function () {
					window.setInterval(() => {
						this.capturePoses = capturePoses;
						this.videoPoses= videoPoses
						this.weightedDistance = poseSimilarity(this.capturePoses[0].pose, this.videoPoses[0].pose, { strategy: 'weightedDistance' });
						this.cosineDistance = poseSimilarity(this.capturePoses[0].pose, this.videoPoses[0].pose, { strategy: 'cosineDistance' });
						this.cosineSimilarity = poseSimilarity(this.capturePoses[0].pose, this.videoPoses[0].pose, { strategy: 'cosineSimilarity' });
					}, 1000);
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