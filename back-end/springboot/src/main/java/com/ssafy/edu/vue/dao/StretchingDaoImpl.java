package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Stretching;
import com.ssafy.edu.vue.dto.Test;
import com.ssafy.edu.vue.dto.Video;

@Repository
public class StretchingDaoImpl {
	
	String ns = "ssafy.stretching.";
	@Autowired
	private SqlSession sqlSession;


	public Stretching getVideoPath(int num) {
		return sqlSession.selectOne(ns+"getVideoPath", num);
	}


	public List<Part> getPartList() {
		return sqlSession.selectList(ns+"getPartList");
	}


	public List<Video> getVideoList(int part_id) {
		return sqlSession.selectList(ns+"getVideoList", part_id);
	}


	public List<Video> getAllVideoList() {
		return sqlSession.selectList(ns+"getAllVideoList");
	}


	public List<String> getVideoPart(int video_id) {
		return sqlSession.selectList(ns+"getVideoPart", video_id);
	}
	
}
