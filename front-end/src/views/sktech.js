// import p5 from 'p5'
import ml5 from 'ml5'

function modelReady() {
    // select("#status").html("model Loaded");
  }

window.cam_poses = [];
window.poses = [];

export default async function( sketch ) {

    var width = 0;
    var height = 0;
    
    var video;
    var cam;
    // let cam_poses = [];

    // var videofile = "https://i02b104.p.ssafy.io/video/please.mp4";
    var videofile = window.videoURL;
  
    let poseNet;
    let poseNet2;
    // let poses = [];
    
    sketch.setup = async function() {
        const canvas = sketch.createCanvas(1280, 480);
        canvas.parent("videoContainer");
      
        cam = sketch.createCapture(window.VIDEO);
        // cam.size(640, 480);
        cam.hide();
        poseNet = ml5.poseNet(cam, modelReady);
        poseNet.on("pose", function(results) {
            window.cam_poses = results;
        });
        sketch.background(1000);
      
        video = sketch.createVideo(videofile);
        // video.size(640, 480);
        // video.hide();
        poseNet2 = ml5.poseNet(video, modelReady);
        poseNet2.on("pose", function(results) {
            window.poses = results;
        });
    }

    sketch.draw = async function() {
        //sketch.fill(0);
        //sketch.ellipse(sketch.random(0,width), sketch.random(0,height), 10,10);
        sketch.image(cam, 0, 0);
        sketch.image(video, 640, 0);

        drawKeypoints();
        drawSkeleton();
    }

    sketch.windowResized = function() {
        width = document.getElementById('sketch').clientWidth;
        height = document.getElementById('sketch').clientHeight;
        sketch.resizeCanvas(width, height);
    }

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
          sketch.textSize(32);
          sketch.text(pose.nose.x, 10, 30);
          sketch.scale(-1.0, -1.0);
        }
      
        for (let i = 0; i < window.poses.length; i++) {
          let pose = window.poses[i].pose;
      
          for (let j = 0; j < pose.keypoints.length; j++) {
            let keypoint = pose.keypoints[j];
            if (keypoint.score > 0.2) {
                sketch.fill(255, 0, 0);
                sketch.noStroke();
                sketch.ellipse(keypoint.position.x + 640, keypoint.position.y, 10, 10);
            }
          }
          sketch.textSize(32);
          sketch.text(pose.nose.x, 10, 30);
          sketch.scale(-1.0, -1.0);
        }
      }
      
      function drawSkeleton() {
        for (let i = 0; i < window.cam_poses.length; i++) {
          let skeleton = window.cam_poses[i].skeleton;
          for (let j = 0; j < skeleton.length; j++) {
            let partA = skeleton[j][0];
            let partB = skeleton[j][1];
            sketch.stroke(255, 0, 0);
            sketch.line(
              partA.position.x,
              partA.position.y,
              partB.position.x,
              partB.position.y
            );
          }
        }
      
        for (let i = 0; i < window.poses.length; i++) {
          let skeleton = window.poses[i].skeleton;
          for (let j = 0; j < skeleton.length; j++) {
            let partA = skeleton[j][0];
            let partB = skeleton[j][1];
            sketch.stroke(255, 0, 0);
            sketch.line(
              partA.position.x + 640,
              partA.position.y,
              partB.position.x + 640,
              partB.position.y
            );
          }
        }
      }
}