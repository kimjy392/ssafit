<template>
	<div>
		<Header></Header>
		<h1>PoseNet demo with Ml5.js</h1>
		<p id="status">Loading Posenet Model...</p>
		<h1>코사인 유사도: {{ cosineSimilarity }}</h1>
		<p id="countdown"></p>
		<div id="videoContainer"></div>
		<div class='sketch' id="sketch"></div>
	</div>
</template>

<script>
	import Header from '@/components/Header.vue'
	import axios from 'axios'
	import sketch from './sktech';
	import p5 from 'p5';
	import { poseSimilarity } from 'posenet-similarity';

	export default {
		name: "Detail",
		components: {
			Header
		},
		data() {
			return {
				// poses: poses
				cam_poses: 0,
				video_poses: 0,
				cosineSimilarity: 0,
			};
		},
		methods: {
			everySecondTrigger() {
				this.$nextTick(function () {
					window.setInterval(() => {
						this.cam_poses = window.cam_poses
						this.video_poses = window.poses
						try {
							this.cosineSimilarity = poseSimilarity(this.cam_poses[0].pose, this.video_poses[0].pose, { strategy: 'cosineSimilarity'});
						}
						catch(err) {
							console.log(11)
						}
					}, 1000);
				});
			},
			getVideo() {
				axios.get('http://i02b104.p.ssafy.io:8197/ssafyvue/api/stretching/detail/' + this.$route.params.id)
					.then((res) => {
						window.videoURL = 'https://i02b104.p.ssafy.io/video/' + res.data.file
						this.myp5 = new p5(sketch, document.getElementById('sketch'))
					})
					.catch((err) => {
						console.log(err)
					})
			},
			timer() {
				var timeleft = 9
				var downloadTimer = setInterval(function () {
					if (timeleft <= 0) {
						clearInterval(downloadTimer);
						document.getElementById("countdown").innerHTML = "Started!!!";
					} else {
						document.getElementById("countdown").innerHTML = 'Coaching will start within ' + timeleft +
							" seconds remaining";
					}
					timeleft -= 1;
				}, 1000);
			}
		},
		mounted() {
			this.timer();
			this.getVideo()
			this.everySecondTrigger();
		},
	};
</script>

<style>
	/* #videoContainer2 {
  width: 640px;
  display: inline-block;
} */
	canvas {
		width: 100px;
		height: 100px;
		background-color: yellow;
		display: inline-block;
	}
</style>