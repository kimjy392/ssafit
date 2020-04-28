package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.MemberDaoImpl;
import com.ssafy.edu.vue.dto.DateStretchingCnt;
import com.ssafy.edu.vue.dto.Member;


@Service
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	private MemberDaoImpl memberdao;


	@Override
	@Transactional(readOnly=true)
	public Member login(Member member) {
		return memberdao.login(member);
	}


	@Override
	@Transactional(readOnly=true)
	public List<DateStretchingCnt> getDateCnt(int memberid) {
		return memberdao.getDateCnt(memberid);
	}

}
