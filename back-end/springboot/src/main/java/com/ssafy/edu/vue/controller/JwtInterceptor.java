package com.ssafy.edu.vue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.service.IJwtService;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	private static final String HEADER_AUTH = "Authorization";

	@Autowired
	private IJwtService jwtService;

	@Override
	@CrossOrigin(allowedHeaders="Authorization")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);
		Member member = jwtService.get(request);
		System.out.println("login : "+member+" / token : "+token);
		request.setAttribute("loginMember", member);
		return true;
//		if(token != null && jwtService.isUsable(token)){
//			return true;
//		}else{
//			throw new UnauthorizedException();
//		}
	}
}