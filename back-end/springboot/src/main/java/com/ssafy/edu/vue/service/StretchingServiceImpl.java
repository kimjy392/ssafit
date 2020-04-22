package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.MemberDaoImpl;
import com.ssafy.edu.vue.dao.StretchingDaoImpl;
import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Stretching;
import com.ssafy.edu.vue.dto.Video;


@Service
public class StretchingServiceImpl implements IStretchingService {
	
	@Autowired
	private StretchingDaoImpl stretchingdao;


	@Override
	@Transactional(readOnly=true)
	public Stretching getVideoPath(int num) {
		return stretchingdao.getVideoPath(num);
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

}
