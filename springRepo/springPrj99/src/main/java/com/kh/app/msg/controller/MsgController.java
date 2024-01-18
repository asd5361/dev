package com.kh.app.msg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.vo.BoardVo;


@RestController
@RequestMapping("msg")
public class MsgController {
	
	private Logger log =LoggerFactory.getLogger(MsgController.class);
	
	@GetMapping
	public void m01(String str) {
		System.out.println("str :"+str);
	}
	
	//빌더 객체 만들기
	@PostMapping
	public void m02(String str) {
		
		BoardVo
			.builder()
			.no("777")
			.title("zz")
			.content("xxx")
			.build();
		
		System.out.println("str : "+str);
	}
}
