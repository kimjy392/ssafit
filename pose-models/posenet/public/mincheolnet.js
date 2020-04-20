var video;

var videofile = "test2.mp4";
let poseNet;
let poses = [];
let skeletons = [];
var imageScaleFactor = 0.3;
var outputStride = 16;
var minConfidence = 0.5;
var maxPoseDetections = 1;
var scoreThreshold = 0.5;
var multiplier = 0.75;

function setup() {
  const canvas = createCanvas(640, 480);
  canvas.parent("videoContainer");

  var myVideo = document.getElementById("myVideo");
  myVideo.style.display = "none";

  video = createVideo(
    "https://i02b104.p.ssafy.io/video/stretching.mp4",
    onLoad
  );
  // video = createVideo(videofile, onLoad);

  video.size(width, height);
  //Posenet
  poseNet = ml5.poseNet(
    video,
    imageScaleFactor,
    outputStride,
    minConfidence,
    maxPoseDetections,
    scoreThreshold,
    multiplier
  );

  //poseNet.on('pose', gotPoses);
  poseNet.on("pose", function(results) {
    poses = results;
  });

  video.hide();
}

function onLoad() {
  // This function is called when the video loads
  //  print("start auto play after load");

  // print("mouse click to start");
  select("#status").html("model Loaded");
}

function modelReady() {
  console.log("model ready");
}

//Pose Net
function gotPoses(poses) {
  console.log(poses);
}

function draw() {
  image(video, 0, 0, width, height);

  // We can call both functions to draw all keypoints and the skeletons
  drawKeypoints();
  drawSkeleton();
}
//=======Draw skeleton and keypoints ===/

// A function to draw ellipses over the detected keypoints
function drawKeypoints() {
  // Loop through all the poses detected
  for (let i = 0; i < poses.length; i++) {
    // For each pose detected, loop through all the keypoints
    for (let j = 0; j < poses[i].pose.keypoints.length; j++) {
      // A keypoint is an object describing a body part (like rightArm or leftShoulder)
      let keypoint = poses[i].pose.keypoints[j];
      // Only draw an ellipse is the pose probability is bigger than 0.2
      if (keypoint.score > 0.1) {
        fill(255, 0, 0);
        noStroke();
        ellipse(keypoint.position.x, keypoint.position.y, 10, 10);
      }
    }
  }
}

// A function to draw the skeletons
function drawSkeleton() {
  // Loop through all the skeletons detected
  for (let i = 0; i < poses.length; i++) {
    // For every skeleton, loop through all body connections
    for (let j = 0; j < poses[i].skeleton.length; j++) {
      let partA = poses[i].skeleton[j][0];
      let partB = poses[i].skeleton[j][1];
      stroke(255, 0, 0);
      line(
        partA.position.x,
        partA.position.y,
        partB.position.x,
        partB.position.y
      );
    }
  }
}

//======End skeleton ============/
function mousePressed() {
  video.loop(); // set the video to loop mode ( and start )
  print("set loop mode");
}
