package com.kh.mini.manager.controller;

import java.util.*;

import com.cherry.faq.controller.FaqController;
import com.cherry.main.Main;
import com.cherry.manager.service.ManagerService;
import com.cherry.manager.vo.ManagerVo;
import com.cherry.member.vo.MemberVo;
import com.cherry.notice.controller.NoticeController;
import com.cherry.qna.controller.QnaController;
import com.cherry.town.controller.TownController;
import com.cherry.trade.controller.TradeController;
import com.cherry.trade.vo.TradeVo;

public class ManagerController {
	
	private final ManagerService service;
	private final TradeController trade;
	private final TownController town;
	private final NoticeController notice;
	private final FaqController faq;
	private final QnaController qna;
	
	public ManagerController() {
		service = new ManagerService();
		trade = new TradeController();
		town = new TownController();
		notice = new NoticeController();
		faq = new FaqController();
		qna = new QnaController();
	}
	//관리자 메뉴 선택
	public void managerMenu() {
		System.out.println("===== 관리자 메뉴 선택 =====");
		
		/* 관리자 기능 */
		System.out.print("1: 관리자 로그인");

		String num = Main.SC.nextLine();
		
		switch(num) {
		case "1" :loginManager(); break;

		default : System.out.println("잘못 입력하였습니다.");
		}
	}
	//관리자 페이지 메뉴 선택
	public void adminPage() {
		System.out.println("===== 관리자 페이지 메뉴 선택 =====");
		
		System.out.print(" 1: 관리자 로그아웃");
		System.out.print(" 2: 관리자 회원전체 조회");
		System.out.print(" 3: 관리자 회원 상세 조회(번호/아이디/닉네임)");
		System.out.println(" 4: 관리자 회원 강제 탈퇴");
		
		String num = Main.SC.nextLine();
		
		switch(num) {
		case "1" :logoutManager(); break;
		case "2" :userList(); break;
		case "3" :userDetile(); break;
		case "4" :userKick(); break;
		default : System.out.println("잘못 입력하였습니다.");
		}
	}	

	//관리자 로그인 메뉴 선택
	public void loginMenu() {
		System.out.println("===== 관리자 로그인 메뉴 선택 =====");
		
		System.out.print(" 1: 거래게시판");
		System.out.print(" 2: 동네생활");
		System.out.print(" 3: 공지사항");
		System.out.print(" 4: FAQ");
		System.out.print(" 5: QnA");
		System.out.print(" 6: 관리자페이지");
		System.out.println(" 9: 로그아웃");
		
		String num = Main.SC.nextLine();
		
		switch(num) {
		case "1" :trade.tradeMain(); break;
//		case "2" :town.selectMenu(); break;
		case "3" :notice.selectMenu(); break; 
		case "4" :faq.selectMenu(); break; 
		case "5" :qna.selectMenu(); break;
		case "6" :adminPage(); break;
		case "9" :logoutManager(); break;
		default : System.out.println("잘못 입력하였습니다.");
		}
	}
	
	//관리자 로그인
	private void loginManager() {
		System.out.println("===== 관리자 로그인 ======");
		try {
			if(Main.loginManager != null) {
				System.out.println("이미 로그인 상태입니다.");
				return;
			}
			
			System.out.println("ID : ");
			String id = Main.SC.nextLine();
			System.out.println("PWD : ");
			String pwd = Main.SC.nextLine();
			
			ManagerVo vo = new ManagerVo();
			vo.setManagerId(id);
			vo.setPwd(pwd);
			
			Main.loginManager = service.loginManager(vo); 
			
			if(Main.loginManager == null) {
				throw new Exception();
			}
			System.out.println("관리자 로그인 성공");
			System.out.println(Main.loginManager.getName()+" 님 환영합니다.");
			
			loginMenu();
		}catch(Exception e) {
			System.out.println("관리자 로그인 실패");
			e.printStackTrace();
		}
		
	}
	//관리자 로그아웃
	private void logoutManager() {
		System.out.println("===== 관리자 로그아웃 ======");
		if(Main.loginManager == null) {
			System.out.println("관리자 로그인 상태가 아닙니다");
			return;
		}
		Main.loginManager = null;
		System.out.println("관리자 로그아웃 되었습니다.");
		
	}

	//사용자 회원 전체 조회
	private void userList() {
		System.out.println("=================================== 회원 전체 조회 ===================================");
		try {
			//로그인 검사
			if(Main.loginManager == null) {
				throw new Exception("관리자 로그인부터 진행해주세요");
			}
			List<MemberVo> userList = service.userList();
			
			System.out.println("사용자번호 | 동네번호 | 사용자명 | 아이디 | 닉네임 | 이메일 | 전화번호 | 주소 | 가입일자 | 마지막수정일자 | 탈퇴여부");
			for(MemberVo vo : userList) {
				System.out.println(vo.getMemberNo()+" | "+vo.getAreasName()+" | "+vo.getName()+" | "+vo.getId()+" | "+vo.getNick()+" | "+vo.getEmail()
				+" | "+vo.getPhone()+" | "+vo.getAddress()+" | "+vo.getJoinDate()+" | "+vo.getEditDate()+" | "+vo.getQuitYn());
			}			System.out.println("========================================================================================================================\n");			
			
		}catch(Exception e) {
			System.out.println("회원 조회 실패");
			e.printStackTrace();
		}
	}

	//사용자 회원 상세 조회
	private void userDetile() {
		System.out.println("=================================== 회원 상세 조회 ===================================");
		try {
			//로그인 검사
			if(Main.loginManager == null) {
				throw new Exception("관리자 로그인부터 진행해주세요");
			}
			System.out.print("조회할 회원의 회원번호를 입력해주세요 : ");
			String userNo = Main.SC.nextLine();
			MemberVo vo = service.userDetile(userNo);
			
			System.out.println("사용자번호 | 동네번호 | 사용자명 | 아이디 | 닉네임 | 이메일 | 전화번호 | 주소 | 가입일자 | 마지막수정일자 | 탈퇴여부");
			System.out.println(vo.getMemberNo()+" | "+vo.getAreasName()+" | "+vo.getName()+" | "+vo.getId()+" | "+vo.getNick()+" | "+vo.getEmail()
				+" | "+vo.getPhone()+" | "+vo.getAddress()+" | "+vo.getJoinDate()+" | "+vo.getEditDate()+" | "+vo.getQuitYn());
			System.out.println("========================================================================================================================\n");			
			
		}catch(Exception e) {
			System.out.println("회원 조회 실패");
			e.printStackTrace();
		}
	}

	//사용자 회원 강제 탈퇴
	private void userKick() {
		System.out.println("=================================== 회원 강제 탈퇴 ===================================");
		try {
			//로그인 검사
			if(Main.loginManager == null) {
				throw new Exception("관리자 로그인부터 진행해주세요");
			}
			System.out.print("탈퇴할 회원의 회원번호를 입력해주세요 : ");
			String userNo = Main.SC.nextLine();
			int result = service.userKick(userNo);
			
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("회원 강제 탈퇴를 성공했습니다.");
			
		}catch(Exception e) {
			System.out.println("회원 강제 탈퇴 실패");
			e.printStackTrace();
		}		
	}

}
