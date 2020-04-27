package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Result;
import com.ssafy.edu.vue.dto.Test;
import com.ssafy.edu.vue.dto.Video;
import com.ssafy.edu.vue.dto.VideoPoint;

public interface IStretchingService {

	Video getVideo(int video_id);

	List<Video> getAllVideoList();

	List<String> getVideoPart(int video_id);

	void setResult(Result result);

	int getTodayStretchingCnt();

	int getStretchingMem();

	int getStretchingTime(int video_id);

	List<Integer> getVideoList();

	int getVideoStretchingCnt(int video_id);

	VideoPoint getVideoPoint(int video_id);

}
