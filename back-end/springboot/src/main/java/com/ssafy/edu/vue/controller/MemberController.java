package com.ssafy.edu.vue.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.DateStretchingCnt;
import com.ssafy.edu.vue.dto.LatestDate;
import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Result;
import com.ssafy.edu.vue.dto.Video;
import com.ssafy.edu.vue.service.IJwtService;
import com.ssafy.edu.vue.service.IMemberService;
import com.ssafy.edu.vue.service.IStretchingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/humans/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000, exposedHeaders = "Authorization", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@Api(value = "Stretching", description = "Resouces Management 2020")
public class MemberController {

	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private IMemberService memberservice;
	@Autowired
	private IJwtService jwtService;
	@Autowired
	private IStretchingService stretchingservice;
	
	@ApiOperation(value = "로그인", response = Member.class)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestBody Member member) throws Exception {
		logger.info("1-------------login-----------------------------" + new Date());
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> resultMap = new HashMap<>();
		
		Member login = memberservice.login(member);
		
		if(login==null)
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		
		String token = jwtService.create(login);
		headers.set("Authorization", token);
		
		resultMap.put("memberid", login.getMemberid());
		resultMap.put("email", login.getEmail());
		resultMap.put("name",login.getName()); 

		return new ResponseEntity<Map<String, Object>>(resultMap, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "마이페이지-이번달 스트레칭한 날짜", response = Member.class)
	@RequestMapping(value = "/mypage/calendar/{memberid}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> calendar(@PathVariable int memberid) throws Exception {
		logger.info("1-------------calendar-----------------------------" + new Date());
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println(memberid);
		List<String> stretching_date = memberservice.getStretchingDate(memberid);
		System.out.println(stretching_date);
		resultMap.put("stretching_date", stretching_date);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "마이페이지-history(동영상 기록)", response = Member.class)
	@RequestMapping(value = "/mypage/history/{memberid}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> history(@PathVariable int memberid) throws Exception {
		logger.info("1-------------history-----------------------------" + new Date());
		Map<String, Object> resultMap = new HashMap<>();
		
		List<Video> video = stretchingservice.getAllVideoList();
		PriorityQueue<LatestDate> pq = new PriorityQueue<>();
		
		for (int i = 0; i < video.size(); i++) {
			//기록 없으면?
			LatestDate latest = new LatestDate(video.get(i).getVideo_id(), memberid);
			String latestDate = memberservice.getLatestDate(latest);
			if(latestDate==null) continue;
			latest.setDate(latestDate);
			pq.add(latest);
		}
		
		LatestDate[] history = new LatestDate[pq.size()];
		for (int i = 0; i < history.length; i++) {
			history[i] = pq.poll();
		}
		resultMap.put("history", history);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "마이페이지-랭킹", response = Member.class)
	@RequestMapping(value = "/mypage/ranking/{memberid}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> ranking(@PathVariable int memberid) throws Exception {
		logger.info("1-------------ranking-----------------------------" + new Date());
		Map<String, Object> resultMap = new HashMap<>();
		
		int total_users = stretchingservice.getStretchingMem();
		//기록 없으면?
		int rank = memberservice.getRanking(memberid);
		resultMap.put("total_users", total_users);
		resultMap.put("rank", rank);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "마이페이지-점수별 개수", response = Member.class)
	@RequestMapping(value = "/mypage/score/{memberid}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> score(@PathVariable int memberid) throws Exception {
		logger.info("1-------------score-----------------------------" + new Date());
		Map<String, Object> resultMap = new HashMap<>();
		
		Result score = memberservice.getScore(memberid);
		//없으면?
		resultMap.put("excellent", score.getExcellent());
		resultMap.put("great", score.getGreat());
		resultMap.put("good", score.getGood());
		resultMap.put("bad", score.getBad());

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
}
