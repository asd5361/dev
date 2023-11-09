package com.kh.app.controller;

import java.sql.*;
import java.util.*;
import java.util.Scanner;
import com.kh.app.service.MemberService;
import com.kh.app.vo.MemberVo;
import com.kh.app.jdbc.JDBCTemplate;

public class MemberController {
	
	private final Scanner sc;
	private final MemberService ms;
	
	
	public MemberController() {
		this.sc = new Scanner(System.in);
		ms = new MemberService();
	}

	
	//회원가입
	public void join() {
		
		//데이터 준비
		System.out.print("ID :");
		String userId = sc.nextLine();
		System.out.print("PWD :");
		String userPwd = sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(userId);
		vo.setPwd(userPwd);
		
		try {
			//서비스
			int result = ms.join(vo);
			
			//결과처리
			if(result == 1) {
				System.out.println("회원가입 성공");
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("회원가입 실패");			
			e.printStackTrace();
		}
		
	}
	

	//로그인
	public void login() {
		
		//데이터 준비
		System.out.print("ID :");
		String userId = sc.nextLine();
		System.out.print("PWD :");
		String userPwd = sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(userId);
		vo.setPwd(userPwd);
		
		try {
			//서비스 호출
			MemberVo dbVo = ms.login(vo);	
			
			//result (tx,rs)
			if(dbVo != null) {
				System.out.println("로그인 성공");
			}else {
				throw new Exception();
			}			
		}catch(Exception e){
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
		
	}
	
	
	//전체회원조회
	public void printMemberList() {
		
		//데이터 준비
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//서비스호출
			ArrayList<MemberVo> voList = ms.getMemberList();
			
			//결과처리
			for (MemberVo vo : voList) {
				System.out.println(vo.getId()+" | "+vo.getPwd());
			}
			
		}catch(Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}
		
	}
	
	public void selectMenu() {
		System.out.println("1: 회원가입\n2: 로그인\n3: 전체조회");
		String n = sc.nextLine();
		
		switch(n) {
			case "1" : join(); break;
			case "2" : login(); break;
			case "3" : printMemberList(); break;
			default : System.out.println("다시 입력하세요");
		}
	}
	
	
}
