package com.ssafy.edu.vue.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Stretching;
import com.ssafy.edu.vue.dto.Video;
import com.ssafy.edu.vue.help.BoolResult;
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
public class StretchingController {

	public static final Logger logger = LoggerFactory.getLogger(StretchingController.class);

	@Autowired
	private IStretchingService stretchingservice;
	
	@ApiOperation(value = "스트레칭 코치 비디오", response = Member.class)
	@RequestMapping(value = "/stretching", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> stretchingList() throws Exception {
		logger.info("1-------------stretchingList-----------------------------" + new Date());
		Map<String, Object> resultMap = new HashMap<>();
		//part 리스트<번호/부위> -> 각 부분 영상의 정보들 <부위:리스트{돋영상정보}>
		List<Part> part = stretchingservice.getPartList();
		
		for (int i = 0; i < part.size(); i++) {
			List<Video> video = stretchingservice.getVideoList(part.get(i).getPart_id());
			resultMap.put(part.get(i).getName(), video);
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	@ApiOperation(value = "스트레칭 코치 비디오", response = Member.class)
	@RequestMapping(value = "/video/{num}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> login(@PathVariable int num) throws Exception {
		logger.info("1-------------video-----------------------------" + new Date());
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> resultMap = new HashMap<>();
		
		Stretching stretching = stretchingservice.getVideoPath(num);
		
		resultMap.put("title", stretching.getTitle());
		resultMap.put("path", "https://i02b104.p.ssafy.io/video/"+stretching.getFile()+".mp4");

		return new ResponseEntity<Map<String, Object>>(resultMap, headers, HttpStatus.OK);
	}
	
}
