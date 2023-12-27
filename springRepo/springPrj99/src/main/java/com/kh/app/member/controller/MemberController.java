package com.kh.app.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	//�α׾ƿ�
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginMember");
		return "redirect:/home";
	}
	
	//ȸ������ (ȭ��)
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	//ȸ������
	@PostMapping("join")
	public String join(MemberVo vo) throws Exception{
		int result = service.join(vo);
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/home";

	}
	//�α���
	@PostMapping("login")
	public String login(MemberVo vo,HttpSession session) throws Exception {
		MemberVo loginMember = service.login(vo);
		if(loginMember == null) {
			throw new Exception();
		}
		session.setAttribute("loginMember", loginMember);
		session.setAttribute("alerMsg", "�α��� ���� !");
		
		return "redirect:/home";

	}
	//ȸ�� ���� ����
	@PostMapping("edit")
	public String edit(MemberVo vo ) throws Exception {
		int result = service.edit(vo);
		if(result != 1) {
			throw new Exception();
		}
		return "redirect:/home";
	}
	//ȸ�� Ż��
	@GetMapping("quit")
	public String quit(MemberVo vo,HttpSession session) throws Exception {
		int result = service.quit(vo);
		if(result != 1) {
			throw new Exception();
		}
		session.removeAttribute("loginMember");
		session.setAttribute("alerMsg", "ȸ�� Ż�� �Ϸ�");
		
		return "redirect:/home";
	}
	
	//ȸ�� ��� ��ȸ
	@GetMapping("list")
	public String list(Model model) {
		List<MemberVo> voList = service.list();

		model.addAttribute("memberVoList", voList);
		return "member/list";
	}
	
}
