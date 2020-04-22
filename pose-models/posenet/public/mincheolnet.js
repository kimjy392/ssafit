var capture;
var capturePoses = []; 
var capturePoseNet;

var video;
var videoPoses = [];
var videoPoseNet;

var similarity;

function setup() {
  capture = createCapture(VIDEO);

  capturePoseNet = ml5.poseNet(capture, modelReady);
  capturePoseNet.on("pose", function(results) {
    capturePoses = results;
  });

  video = createVideo("https://i02b104.p.ssafy.io/video/IMG_1943.mp4");
  video.size(600, 600)
  video.i = 'haha'

  videoPoseNet = ml5.poseNet(video, modelReady);
  videoPoseNet.on("pose", function(results) {
    videoPoses = results;
  });

  video.play()
}

// var s1 = function( sketch ) {
//   sketch.setup = function() {
//     let canvas1 = sketch.createCanvas(500, 500, sketch.WEBGL);
//     canvas1.position(0,0);
//     canvas1.parent('videoContainer')
//     video = sketch.createVideo("test2.mp4");
//     video.size(500, 500)
//   }
//   sketch.draw = function() {
//     //for canvas 1
//     // sketch.background(100);
//     // sketch.rotateX(sketch.frameCount * 0.01);
//     // sketch.rotateZ(sketch.frameCount * 0.01);
//     // sketch.cone(30, 50);
//     // console.log(video, 123123)
//     video.play();
//     image(video, 0, 0, 500, 500);
//   }
// };

// // create a new instance of p5 and pass in the function for sketch 1
// new p5(s1);

// var s2 = function( sketch ) {

//    sketch.setup = function() {
//     let canvas2 = sketch.createCanvas(500, 500, sketch.WEBGL);
//     canvas2.position(500,0);
    
//     capture = sketch.createCapture(VIDEO);
//     capture.size(width, height);
//     capture.hide()
//   }
//   sketch.draw = function() {
//     //for canvas 2
//     sketch.background(100);
//     sketch.rotateX(sketch.frameCount * 0.01);
//     sketch.rotateZ(sketch.frameCount * 0.02);
//     sketch.cone(30, 50);
//   }
// };

// // create the second instance of p5 and pass in the function for sketch 2
// new p5(s2);


// var capture;
// var capturePoseNet;
// var capturePoses = [];

// var video;
// var videofile = "test2.mp4";
// let poseNet;
// let poses = [];
// let skeletons = [];
// var imageScaleFactor = 0.3;
// var outputStride = 16;
// var minConfidence = 0.5;
// var maxPoseDetections = 1;
// var scoreThreshold = 0.5;
// var multiplier = 0.75;


// function setup() {
//   // Webcam
//   const captureCanvas = createCanvas(640, 480);
//   captureCanvas.parent('videoContainer');
//   captureCanvas.position(500, 0)

//   capture = createCapture(VIDEO);
//   capture.size(width, height);
//   capture.hide()

//   capturePoseNet = ml5.poseNet(capture, modelReady);
//   capturePoseNet.on("pose", function(results) {
//     capturePoses = results;
//   });

//   // Video
//   const canvas = createCanvas(640, 480);
//   canvas.parent("videoContainer1");

//   // var myVideo = document.getElementById("myVideo");
//   // myVideo.style.display = "none";

//   video = createVideo(videofile, onLoad);
//   // video = createVideo(videofile, onLoad);
//   video.size(width, height);
  
//   //Posenet
//   poseNet = ml5.poseNet(
//     video,
//     imageScaleFactor,
//     outputStride,
//     minConfidence,
//     maxPoseDetections,
//     scoreThreshold,
//     multiplier
//     );
//     poseNet.on("pose", function(results) {
//       poses = results;
//     });
    
//     // poseNet.on('pose', gotPoses);
//     video.hide();
// }

// function onLoad() {
//   // This function is called when the video loads
//   //  print("start auto play after load");

//   // print("mouse click to start");
//   select("#status").html("model Loaded");
// }

function modelReady() {
  console.log("model ready");
}

// //Pose Net
// function gotPoses(poses) {
//   console.log(poses);
// }

function draw() {
  translate(capture.width, 0);
  scale(-1.0, 1.0);

  image(capture, 0, 0, width, height);
  image(video, 0, 0, width, height);

  // We can call both functions to draw all keypoints and the skeletons
  drawKeypoints();
  // drawSkeleton();
}
// //=======Draw skeleton and keypoints ===/

// // A function to draw ellipses over the detected keypoints
function drawKeypoints() {
  // Loop through all the poses detected
  for (let i = 0; i < capturePoses.length; i++) {
    // let pose1 = capturePoses[i].pose;
    // let pose2 = videoPoses[i].pose;
    // similarity = pns.poseSimilarity(pose1, pose2, { strategy: 'cosineSimilarity' });
    // For each pose detected, loop through all the keypoints
    for (let j = 0; j < capturePoses[i].pose.keypoints.length; j++) {
      // A keypoint is an object describing a body part (like rightArm or leftShoulder)
      let keypoint = capturePoses[i].pose.keypoints[j];
      // Only draw an ellipse is the pose probability is bigger than 0.2
      if (keypoint.score > 0.1) {
        fill(255, 0, 0);
        noStroke();
        ellipse(keypoint.position.x, keypoint.position.y, 10, 10);
      }
    }
  }

  for (let i = 0; i < videoPoses.length; i++) {
    // For each pose detected, loop through all the keypoints
    for (let j = 0; j < videoPoses[i].pose.keypoints.length; j++) {
      // A keypoint is an object describing a body part (like rightArm or leftShoulder)
      let keypoint = videoPoses[i].pose.keypoints[j];
      // Only draw an ellipse is the pose probability is bigger than 0.2
      if (keypoint.score > 0.1) {
        fill(255, 0, 0);
        noStroke();
        ellipse(keypoint.position.x, keypoint.position.y, 10, 10);
      }
    }
  }
}

//   for (let i = 0; i < capturePoses.length; i++) {
//     // For each pose detected, loop through all the keypoints
//     for (let j = 0; j < capturePoses[i].pose.keypoints.length; j++) {
//       // A keypoint is an object describing a body part (like rightArm or leftShoulder)
//       let keypoint = capturePoses[i].pose.keypoints[j];
//       // Only draw an ellipse is the pose probability is bigger than 0.2
//       if (keypoint.score > 0.1) {
//         fill(255, 0, 0);
//         noStroke();
//         ellipse(keypoint.position.x, keypoint.position.y, 10, 10);
//       }
//     }
//   }
// }

// // A function to draw the skeletons
// function drawSkeleton() {
//   // Loop through all the skeletons detected
//   for (let i = 0; i < poses.length; i++) {
//     // For every skeleton, loop through all body connections
//     for (let j = 0; j < poses[i].skeleton.length; j++) {
//       let partA = poses[i].skeleton[j][0];
//       let partB = poses[i].skeleton[j][1];
//       stroke(255, 0, 0);
//       line(
//         partA.position.x,
//         partA.position.y,
//         partB.position.x,
//         partB.position.y
//       );
//     }
//   }
// }

// //======End skeleton ============/
// function mousePressed() {
//   video.loop(); // set the video to loop mode ( and start )
//   print("set loop mode");
// }
