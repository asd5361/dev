package com.kh.app.member.controller;

import java.util.HashMap;

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
	
}
