package com.kh.app.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.sevice.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

	private final MemberService service;
	
	//회원가입
	@PostMapping("join")
	public void insert(MemberVo vo) {
		int result = service.join(vo);
		System.out.println("insert > result ::: "+result);
	}
	
	//회원 목록 조회
	@GetMapping("list")
	public void list() {
		List<MemberVo> voList = service.list();
		for (MemberVo memberVo : voList) {
			System.out.println(memberVo);
		}
	}
	
	//회원 상세 조회
	@GetMapping("detail")
	public void detail(String no) {
		MemberVo vo = service.detail(no);
		System.out.println(vo);
	}
	
	//회원 삭제
	@GetMapping("delete")
	public void delete(String no) {
		int result = service.delete(no);
		System.out.println("delete > result ::: "+result);
	}
	
	//회원 정보 수정
	@PostMapping("update")
	public void update(MemberVo vo) {
		int result = service.update(vo);
		System.out.println("update > result ::: "+result);
		
	}
}
