<template>
	<div id="theater">
		<canvas id="canvas"></canvas>
		<video id="video" controls autoplay>
			<source :src=videoSrc type=video/mp4> 
		</video> 
	</div> 
</template> 

<script>
	export default {
	name: 'Trainer',
		data() {
			return {
				videoSrc: "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
			}
		},
		methods: {
			draw(v, c, w, h) {
				if(v.paused || v.ended) return false;
				c.drawImage(v,0,0,w,h);
				setTimeout(this.draw, 20, v, c, w, h);
			},
			setup() {
				document.addEventListener('DOMContentLoaded', function(){
					var v = document.getElementById('video');
					var canvas = document.getElementById('canvas');
					var context = canvas.getContext('2d');

					var cw = Math.floor(canvas.clientWidth / 100);
					var ch = Math.floor(canvas.clientHeight / 100);
					canvas.width = cw;
					canvas.height = ch;

					v.addEventListener('play', function(){
						this.draw(this,context,cw,ch);
					}, false);

				},false);
			}
		},
		mounted() {

		}
	}
</script>
<style>
	/* #canvas {
		position: absolute;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
		width: 100%;
		height: 100%;
	}
	#video {
		position: absolute;
		top: 50%;
		left: 50%;
		margin: -180px 0 0 -240px;
	} */
</style>