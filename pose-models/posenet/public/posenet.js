var video;
var poseNet;
var poses = [];

var playing = false;
var v;
var button;
var poseNet2;
var poses2 = [];


function modelReady(){
  select('#status').html('model Loaded')
}

function setup() {
    const canvas = createCanvas(840, 680);
    canvas.parent('videoContainer');
  
    video = createCapture(VIDEO);
    video.size(width, height);
    video.hide()

    // const canvas2 = createCanvas(640, 480);
    // canvas2.position(500, 0)
    // canvas2.parent('videoContainer')
    // v = createVideo(["https://ak1.picdn.net/shutterstock/videos/1028899901/preview/stock-footage-happy-carefree-african-american-millennial-girl-having-fun-at-home-listening-to-good-music-playing.mp4"]);
    // v.size(width, height);
    // button = createButton('play');
    // button.mousePressed(toggleVid);
    // v.hide()

    poseNet = ml5.poseNet(video, modelReady);
    poseNet.on('pose', function(results) {
      poses = results;
    });

    // poseNet2 = ml5.poseNet(v, modelReady);
    // poseNet2.on('pose', function(results) {
    //   poses2 = results;
    // });
}

function draw() {
  translate(video.width, 0);
  scale(-1.0, 1.0); 
  image(video, 0, 0, width, height);

  // translate(v.width, 0);
  // scale(-1.0, 1.0); 
  // image(v, 0, 0, width, height);

  // We can call both functions to draw all keypoints and the skeletons
  drawKeypoints();
  drawSkeleton();
}

// A function to draw ellipses over the detected keypoints
function drawKeypoints()  {
  // Loop through all the poses detected
  for (let i = 0; i < poses.length; i++) {
    // For each pose detected, loop through all the keypoints
    let pose = poses[i].pose;

    // console.log('nose: ', pose.nose.x, pose.nose.y)
    // const cosineSimilarity = pns.poseSimilarity(pose, pose, { strategy: 'cosineSimilarity' });
    // console.log('asdf', cosineSimilarity)
    for (let j = 0; j < pose.keypoints.length; j++) {
      // A keypoint is an object describing a body part (like rightArm or leftShoulder)
      let keypoint = pose.keypoints[j];
      // Only draw an ellipse is the pose probability is bigger than 0.2
      if (keypoint.score > 0.2) {
        fill(255, 0, 0);
        noStroke();
        ellipse(keypoint.position.x, keypoint.position.y, 10, 10);
      }
    }
    textSize(32);
    text(pose.nose.x, 10, 30);
    scale(-1.0, -1.0);
  }
}

// A function to draw the skeletons
function drawSkeleton() {
  // Loop through all the skeletons detected
  for (let i = 0; i < poses.length; i++) {
    let skeleton = poses[i].skeleton;
    // For every skeleton, loop through all body connections
    for (let j = 0; j < skeleton.length; j++) {
      let partA = skeleton[j][0];
      let partB = skeleton[j][1];
      stroke(255, 0, 0);
      line(partA.position.x, partA.position.y, partB.position.x, partB.position.y);
    }
  }
}