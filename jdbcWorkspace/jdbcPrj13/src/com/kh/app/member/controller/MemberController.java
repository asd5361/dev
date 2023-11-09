package com.kh.app.member.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.app.board.controller.BoardController;
import com.kh.app.main.Main;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

public class MemberController {

	private final Scanner sc;
	private final MemberService ms;
	
	public MemberController() {
		sc = new Scanner(System.in);
		ms = new MemberService();
	}
	public void selectMenu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 회원 목록 조회");
		System.out.println("4. 회원 탈퇴");
		System.out.println("5. 비밀번호 변경");
		
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		case "3" : printMemberList(); break;
		case "4" : quit();; break;
//		case "5" : editPwd(); break;
			default : System.out.println("잘못 입력하였습니다.");
		}
	}
	//여기부터
	private void quit() {
		// 데이터 준비
		
		try {
			
		//서비스
		}catch(Exception e) {
			
		//결과
		}
		
		
		
		
		
	}
	private void printMemberList() {
		//데이터 준비
		System.out.println("\n==============================\n");
		System.out.println("전체 회원 목록\n");
		//서비스
		try {
			ArrayList<MemberVo> memberList =ms.getMemberList();
			
			//결과
			if(memberList.isEmpty()) {
				System.out.println("회원 목록 없음");
				return;
			}
			for(MemberVo vo : memberList) {
				System.out.println("ID :" + vo.getId());
				System.out.println("닉네임 :"+ vo.getNick());
			}
		}catch(Exception e) {
			System.out.println("회원 조회 실패");
			e.printStackTrace();
		}
		
	}
	public void join() {
		//데이터 준비
		System.out.println("\n==============================\n");
		System.out.println("회원가입 창입니다.값을 입력해주세요");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		System.out.print("NICK : ");
		String nick = sc.nextLine();
		
		MemberVo vo = new MemberVo(); //객체 담기
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNick(nick);
		
		try {
			//서비스
			int result =ms.join(vo);
			//결과
			if(result == 1) {
				System.out.println("회원가입 완료");
				login();
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("회원가입 실패");
			e.printStackTrace();
		}
	}
	
	public void login() {
		//데이터 준비
		System.out.println("\n==============================\n");
		System.out.println("로그인 창입니다. ID와 PWD를 입력해주세요");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		MemberVo vo = new MemberVo(); //객체 담기
		vo.setId(id);
		vo.setPwd(pwd);
		
		//서비스
		MemberVo dbVo;
		try {
			
			dbVo = ms.login(vo);
			
			//결과
			if(dbVo != null) {
				System.out.println(dbVo.getNick()+"님 환영합니다.");
				Main.loginMember = dbVo;	//로그인한 유저 정보

			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
	}
	
	

}
