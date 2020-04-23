package com.ssafy.edu.vue.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Part;
import com.ssafy.edu.vue.dto.Result;
import com.ssafy.edu.vue.dto.Stretching;
import com.ssafy.edu.vue.dto.Video;
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

	@ApiOperation(value = "스트레칭 코치 비디오", response = Null.class)
	@RequestMapping(value = "/stretching", method = RequestMethod.GET)
	public ResponseEntity<List<Video>> stretchingList() throws Exception {
		logger.info("1-------------stretchingList-----------------------------" + new Date());
		Map<String, Object> resultMap = new HashMap<>();
		// part 리스트<번호/부위> -> 각 부분 영상의 정보들 <부위:리스트{돋영상정보}>
//		List<Part> part = stretchingservice.getPartList();
//
//		for (int i = 0; i < part.size(); i++) {
//			List<Video> video = stretchingservice.getVideoList(part.get(i).getPart_id());
//			resultMap.put(part.get(i).getName(), video);
//		}
		
		List<Video> video = stretchingservice.getAllVideoList();
		for (int i = 0; i < video.size(); i++) {
			List<String> part = stretchingservice.getVideoPart(video.get(i).getVideo_id());
			video.get(i).setPart(part);
		}
		

		return new ResponseEntity<List<Video>>(video, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "스트레칭 디테일", response = Integer.class)
	@RequestMapping(value = "/stretching/detail/{video_id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> detail(@PathVariable int video_id) throws Exception {
		logger.info("1-------------detail-----------------------------" + new Date());
		Map<String, Object> resultMap = new HashMap<>();
		
		Video stretching = stretchingservice.getVideoPath(video_id);
		resultMap.put("video_id", stretching.getVideo_id());
		resultMap.put("title", stretching.getTitle());
		resultMap.put("file", stretching.getFile());
		resultMap.put("description", stretching.getDescription());

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "스트레칭 결과 페이지", response = Result.class)
	@RequestMapping(value = "/stretching/result", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> result(@RequestBody Result result) throws Exception {
		logger.info("1-------------result-----------------------------" + new Date());
		Map<String, Object> resultMap = new HashMap<>();
		
		List<Video> video = stretchingservice.getAllVideoList();
		for (int i = 0; i < video.size(); i++) {
			List<String> part = stretchingservice.getVideoPart(video.get(i).getVideo_id());
			video.get(i).setPart(part);
		}
		
		
		return new ResponseEntity<List<Video>>(video, HttpStatus.OK);
	}
	
	

//	@ApiOperation(value = "스트레칭 코치 비디오", response = Integer.class)
//	@RequestMapping(value = "/video/{num}", method = RequestMethod.GET)
//	public ResponseEntity<Map<String, Object>> login(@PathVariable int num) throws Exception {
//		logger.info("1-------------video-----------------------------" + new Date());
//		HttpHeaders headers = new HttpHeaders();
//		Map<String, Object> resultMap = new HashMap<>();
//
//		Stretching stretching = stretchingservice.getVideoPath(num);
//
//		resultMap.put("title", stretching.getTitle());
//		resultMap.put("path", "https://i02b104.p.ssafy.io/video/" + stretching.getFile() + ".mp4");
//
//		return new ResponseEntity<Map<String, Object>>(resultMap, headers, HttpStatus.OK);
//	}
//
//	@ApiOperation(value = "스트레칭 코치 비디오", response = Integer.class)
//	@RequestMapping(value="/contents/{num}", method= RequestMethod.GET) 
//	public String getContentMediaVideo(@PathVariable int num,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
//		
//		Stretching stretching = stretchingservice.getVideoPath(num);
//		File file = new File("/aaa/"+ stretching.getFile());
//
//		RandomAccessFile randomFile = new RandomAccessFile(file, "r");
//		long rangeStart = 0;
//		long rangeEnd = 0;
//		boolean isPart=false;
//		try{
//			long movieSize = randomFile.length();
//			String range = request.getHeader("range");
//			if(range!=null) {
//				if(range.endsWith("-")){
//					range = range+(movieSize - 1);
//
//				}
//				int idxm = range.trim().indexOf("-");
//				rangeStart = Long.parseLong(range.substring(6,idxm));
//				rangeEnd = Long.parseLong(range.substring(idxm+1));
//				if(rangeStart > 0){
//					isPart = true;
//				}
//			}else{
//				 rangeStart = 0;
//				 rangeEnd = movieSize - 1;
//			}
//			long partSize = rangeEnd - rangeStart + 1;
//			response.reset();
//			response.setStatus(isPart ? 206 : 200);
//			response.setContentType("video/mp4");
//			response.setHeader("Content-Range", "bytes "+rangeStart+"-"+rangeEnd+"/"+movieSize); 
//			response.setHeader("Accept-Ranges", "bytes"); 
//			response.setHeader("Content-Length", ""+partSize);
//			OutputStream out = response.getOutputStream();
//			randomFile.seek(rangeStart);
//			int bufferSize = 8*1024;
//			byte[] buf = new byte[bufferSize];
//			do{
//				int block = partSize > bufferSize ? bufferSize : (int)partSize; 
//				int len = randomFile.read(buf, 0, block); 
//				out.write(buf, 0, len); 
//				partSize -= block;
//			}while(partSize > 0);
//		}catch(IOException e){
//			
//		}finally{ 
//			randomFile.close(); 
//		} return null;
//	}


}
