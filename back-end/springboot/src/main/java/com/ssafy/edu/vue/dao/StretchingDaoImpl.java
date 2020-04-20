package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Stretching;
import com.ssafy.edu.vue.dto.Test;

@Repository
public class StretchingDaoImpl {
	
	String ns = "ssafy.stretching.";
	@Autowired
	private SqlSession sqlSession;


	public Stretching getVideoPath(int num) {
		return sqlSession.selectOne(ns+"getVideoPath", num);
	}
	
}
