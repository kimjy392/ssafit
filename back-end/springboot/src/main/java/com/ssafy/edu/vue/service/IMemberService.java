package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.DateStretchingCnt;
import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Test;

public interface IMemberService {

	Member login(Member member);

	List<DateStretchingCnt> getDateCnt(int memberid);

}
