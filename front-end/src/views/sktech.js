import ml5 from "ml5";

window.cam_poses = [];
window.poses = [];
window.playFlag = false;
window.firstStopFlag = true;
window.secondStopFlag = true;
window.alarmFlag = false;
window.done = false;

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
  };

  sketch.draw = async function () {
    sketch.translate(1280, 0);
    sketch.scale(-1.0, 1.0);
    sketch.image(cam, 0, 0);
    sketch.image(video, 640, 0);

    // 비디오가 끝났을 때
    if (video.time() >= window.endOfVideo) {
      window.done = true;
      window.playFlag = false
    }

    // spacebar 눌렀을 때
    if (window.playFlag === true) {
      if (window.done === false) {
        video.play();
      }
    } else {
      video.pause();
    }

    // 첫 번째 측정 3~4초전
    if (Math.floor(video.time()) == window.firstStop - 4 && window.alarmFlag === false) {
      window.alarmFlag = true
      setTimeout(function () {
        window.alarmFlag = false
      }, 2000);
    }

    // 두 번째 측정 3~4초전
    if (Math.floor(video.time()) == window.secondStop - 4 && window.alarmFlag == false) {
      window.alarmFlag = true
      setTimeout(function () {
        window.alarmFlag = false
      }, 2000);
    }
    
    // 첫 번째 측정 시작
    if (Math.floor(video.time()) == window.firstStop && window.firstStopFlag == true){
      window.firstStopFlag = false
      setTimeout(function () {
        window.firstStopFlag = true;
      }, 8000);
    }

    // 두 번째 측정 시작
    if (Math.floor(video.time()) == window.secondStop && window.secondStopFlag == true){
      window.secondStopFlag = false;
      setTimeout(function () {
        window.secondStopFlag = true;
      }, 8000);
    }

    if (window.playFlag === true) {
      if (window.firstStopFlag === false || window.secondStopFlag === false) {
        drawKeypoints();
      }
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