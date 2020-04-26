import ml5 from "ml5";

window.cam_poses = [];
window.poses = [];
window.playFlag = false;
window.firstStopFlag = true;
window.secondStopFlag = true;
window.done = false;

document.body.onkeyup = function(e){
  if(e.keyCode == 32){    // when press spacebar
      if( window.playFlag == true) {
        window.playFlag = false
      } else {
        window.playFlag = true
      }
  }
}

function modelReady() {}

export default async function (sketch) {
  var video;
  var cam;
  var videofile = window.videoURL;
  let poseNet;
  let poseNet2;

  function videoLoad() {
    video.hide();
    video.volume(0);

    poseNet2 = ml5.poseNet(video, modelReady);
    poseNet2.on("pose", function (results) {
      window.poses = results;
    });
  }

  sketch.setup = async function () {
    const canvas = sketch.createCanvas(1280, 480);
    // canvas.clear();
    canvas.parent("videoContainer");

    cam = sketch.createCapture(window.VIDEO);
    cam.volume(0);
    cam.hide();

    poseNet = ml5.poseNet(cam, modelReady);
    poseNet.on("pose", function (results) {
      window.cam_poses = results;
    });
    sketch.background(1000);

    video = sketch.createVideo(videofile, videoLoad);
    video.onended(sayDone);
  };
  function sayDone() {
    window.done = true;
    console.log(window.done, window.next);
    window.location = "http://localhost:8080" + window.next;
    // history.back()
  }

  sketch.draw = async function () {
    sketch.translate(1280, 0);
    sketch.scale(-1.0, 1.0);
    sketch.image(cam, 0, 0);
    sketch.image(video, 640, 0);

    if (window.playFlag === true) {
      if (window.done === false) {
        video.play();
      }
    } else {
      video.pause();
    }

    if (Math.floor(video.time()) == window.firstStop && window.firstStopFlag == true){
      window.playFlag = false;
      if (window.cosineSimilarity >= window.excellentThresh * 0.01) {
        window.playFlag = true;
        window.firstStop = false;
      }
    }

    if (Math.floor(video.time()) == window.secondStop && window.secondStopFlag == true){
      window.playFlag = false;
      if (window.cosineSimilarity >= window.excellentThresh * 0.01) {
        window.playFlag = true;
        window.secondStop = false;
      }
    }

    if (window.playFlag === true) {
      drawKeypoints();
      // drawSkeleton();
    }
  };

  sketch.windowResized = function () {
    // width = document.getElementById('sketch').clientWidth;
    // height = document.getElementById('sketch').clientHeight;
    // sketch.resizeCanvas(width, height);
  };

  function drawKeypoints() {
    for (let i = 0; i < window.cam_poses.length; i++) {
      let pose = window.cam_poses[i].pose;

      for (let j = 0; j < pose.keypoints.length; j++) {
        let keypoint = pose.keypoints[j];
        if (keypoint.score > 0.2) {
          sketch.fill(255, 0, 0);
          sketch.noStroke();
          sketch.ellipse(keypoint.position.x, keypoint.position.y, 10, 10);
        }
      }
    }

    for (let i = 0; i < window.poses.length; i++) {
      let pose = window.poses[i].pose;

      for (let j = 0; j < pose.keypoints.length; j++) {
        let keypoint = pose.keypoints[j];
        if (keypoint.score > 0.2) {
          sketch.fill(255, 0, 0);
          sketch.noStroke();
          sketch.ellipse(
            keypoint.position.x + 640,
            keypoint.position.y,
            10,
            10
          );
        }
      }
    }
  }

  // function drawSkeleton() {
  //   for (let i = 0; i < window.cam_poses.length; i++) {
  //     let skeleton = window.cam_poses[i].skeleton;
  //     for (let j = 0; j < skeleton.length; j++) {
  //       let partA = skeleton[j][0];
  //       let partB = skeleton[j][1];
  //       sketch.stroke(255, 0, 0);
  //       sketch.line(
  //         partA.position.x,
  //         partA.position.y,
  //         partB.position.x,
  //         partB.position.y
  //       );
  //     }
  //   }

  //   for (let i = 0; i < window.poses.length; i++) {
  //     let skeleton = window.poses[i].skeleton;
  //     for (let j = 0; j < skeleton.length; j++) {
  //       let partA = skeleton[j][0];
  //       let partB = skeleton[j][1];
  //       sketch.stroke(255, 0, 0);
  //       sketch.line(
  //         partA.position.x + 640,
  //         partA.position.y,
  //         partB.position.x + 640,
  //         partB.position.y
  //       );
  //     }
  //   }
  // }
}