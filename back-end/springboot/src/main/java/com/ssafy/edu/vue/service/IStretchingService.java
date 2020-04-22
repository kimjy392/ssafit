package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Stretching;
import com.ssafy.edu.vue.dto.Test;
import com.ssafy.edu.vue.dto.Video;

public interface IStretchingService {

	Stretching getVideoPath(int num);

	List<Part> getPartList();

	List<Video> getVideoList(int part_id);

	List<Video> getAllVideoList();

	List<String> getVideoPart(int video_id);

}
