package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.DateStretchingCnt;
import com.ssafy.edu.vue.dto.LatestDate;
import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Test;

public interface IMemberService {

	Member login(Member member);

	int getMemberid(String email);

	List<DateStretchingCnt> getDateCnt(int memberid);

	String getLatestDate(LatestDate latest);

	int getRanking(int memberid);

}
