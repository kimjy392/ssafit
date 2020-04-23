package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.MemberDaoImpl;
import com.ssafy.edu.vue.dao.StretchingDaoImpl;
import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Result;
import com.ssafy.edu.vue.dto.Stretching;
import com.ssafy.edu.vue.dto.Video;


@Service
public class StretchingServiceImpl implements IStretchingService {
	
	@Autowired
	private StretchingDaoImpl stretchingdao;


	@Override
	@Transactional(readOnly=true)
	public Video getVideoPath(int video_id) {
		return stretchingdao.getVideoPath(video_id);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Part> getPartList() {
		return stretchingdao.getPartList();
	}


	@Override
	@Transactional(readOnly=true)
	public List<Video> getVideoList(int part_id) {
		return stretchingdao.getVideoList(part_id);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Video> getAllVideoList() {
		return stretchingdao.getAllVideoList();
	}


	@Override
	@Transactional(readOnly=true)
	public List<String> getVideoPart(int video_id) {
		return stretchingdao.getVideoPart(video_id);
	}


	@Override
	@Transactional(readOnly=true)
	public float getBeforeAccuracy(Result result) {
		return stretchingdao.getBeforeAccuracy(result);
	}


	@Override
	@Transactional()
	public void setResult(Result result) {
		stretchingdao.setResult(result);
	}

}
