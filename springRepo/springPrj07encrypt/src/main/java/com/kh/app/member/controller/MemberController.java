package com.kh.app.member.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService service;
	
	//회원가입
	@PostMapping
	public Map<String, String> join(@RequestBody MemberVo vo) {
		//service 호출
		int result = service.join(vo);
		//map 객체 생성
		Map<String, String> map = new HashMap<>();
		//map string형 메세지 삽입
		map.put("msg", "good");
		//결과가 1이 아닐 때 bab 메세지 삽입
		if(result != 1) {
			map.put("msg","bad");
		}
		return map;
	}
	
	//로그인
	@GetMapping
	public Map<String, Object> login(@RequestBody MemberVo vo) {
		//service 호출
		MemberVo loginMember = service.login(vo);
		//map 객체 생성
		Map<String, Object> map = new HashMap<>();
		//map string형 메세지 삽입
		map.put("msg", "good");
		map.put("loginMember", loginMember);
		//결과가 1이 아닐 때 bab 메세지 삽입
		if(loginMember == null) {
			map.put("msg","bad");
		}
		return map;
	}
	
}
