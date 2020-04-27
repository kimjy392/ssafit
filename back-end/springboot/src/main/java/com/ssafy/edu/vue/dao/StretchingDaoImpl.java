package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Result;
import com.ssafy.edu.vue.dto.Test;
import com.ssafy.edu.vue.dto.Video;
import com.ssafy.edu.vue.dto.VideoPoint;

@Repository
public class StretchingDaoImpl {
	
	String ns = "ssafy.stretching.";
	@Autowired
	private SqlSession sqlSession;


	public Video getVideo(int video_id) {
		return sqlSession.selectOne(ns+"getVideo", video_id);
	}


	public List<Video> getAllVideoList() {
		return sqlSession.selectList(ns+"getAllVideoList");
	}


	public List<String> getVideoPart(int video_id) {
		return sqlSession.selectList(ns+"getVideoPart", video_id);
	}


	public void setResult(Result result) {
		sqlSession.insert(ns+"setResult", result);
	}


	public int getTodayStretchingCnt() {
		return sqlSession.selectOne(ns+"getTodayStretchingCnt");
	}


	public int getStretchingMem() {
		return sqlSession.selectOne(ns+"getStretchingMem");
	}


	public int getStretchingTime(Integer video_id) {
		return sqlSession.selectOne(ns+"getStretchingTime", video_id);
	}


	public List<Integer> getVideoList() {
		return sqlSession.selectList(ns+"getVideoList");
	}


	public int getVideoStretchingCnt(int video_id) {
		return sqlSession.selectOne(ns+"getVideoStretchingCnt", video_id);
	}


	public VideoPoint getVideoPoint(int video_id) {
		return sqlSession.selectOne(ns+"getVideoPoint", video_id);
	}
	
}
