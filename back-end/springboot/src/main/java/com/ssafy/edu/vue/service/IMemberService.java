package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.DateStretchingCnt;
import com.ssafy.edu.vue.dto.History;
import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Result;
import com.ssafy.edu.vue.dto.Test;

public interface IMemberService {

	Member login(Member member);

	int getMemberid(String email);

	List<String> getStretchingDate(int memberid);

	String getLatestDate(History latest);

	int getRanking(int memberid);

	Result getScore(int memberid);

	int getMemberStretchingCnt(int memberid);

}
