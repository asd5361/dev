package com.kh.app.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("rest/member")
@ResponseBody
@RequiredArgsConstructor
@CrossOrigin("*")
public class MemberRestController {

	private final MemberService service;
	
	
	@PostMapping("join")
	public HashMap<String, String> join(@RequestBody MemberVo vo) throws Exception {
//		중복 선택을 확인하기 위해 사용
//		Thread.sleep(3000);
		System.out.println("fetch를 통해 받은 VO 데이터"+vo);
		int result = service.join(vo);
		HashMap<String, String> map = new HashMap<String, String>();
		if(result == 1) {
			map.put("msg", "good");
		}else{
			map.put("msg", "bad");			
		}
		return map;
	}
	
	@PostMapping("login")
	public HashMap<String,Object> login(@RequestBody MemberVo vo, HttpSession session){
		System.out.println("fetch를 통해 받은 VO 데이터"+vo);
		MemberVo loginMember = service.login(vo);		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "good");
		map.put("loginMember", loginMember);
		
		if(loginMember == null) {
			map.put("msg", "bad");			
		}
		return map;
	}
	
}
