package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.DateStretchingCnt;
import com.ssafy.edu.vue.dto.LatestDate;
import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Test;

@Repository
public class MemberDaoImpl {
	
	String ns = "ssafy.member.";
	@Autowired
	private SqlSession sqlSession;


	public Member login(Member member) {
		return sqlSession.selectOne(ns+"login", member);
	}

	
	public int getMemberid(String email) {
		return sqlSession.selectOne(ns+"getMemberid", email);
	}

	
	public List<DateStretchingCnt> getDateCnt(int memberid) {
		return sqlSession.selectList(ns+"getDateCnt", memberid);
	}


	public String getLatestDate(LatestDate latest) {
		return sqlSession.selectOne(ns+"getLatestDate", latest);
	}

	
}
