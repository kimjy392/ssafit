package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Result;
import com.ssafy.edu.vue.dto.Test;
import com.ssafy.edu.vue.dto.Video;

public interface IStretchingService {

	Video getVideoPath(int video_id);

	List<Part> getPartList();

	List<Video> getPartVideoList(int part_id);

	List<Video> getAllVideoList();

	List<String> getVideoPart(int video_id);

	float getBeforeAccuracy(Result result);

	void setResult(Result result);

	int getStretchingCnt();

	int getStretchingMem();

	int getStretchingTime(int video_id);

	List<Integer> getVideoList();

	int getStretchingAllCnt(int video_id);

}
