package com.cherry.manager.controller;

import java.util.*;

import com.cherry.faq.controller.FaqController;
import com.cherry.main.Main;
import com.cherry.main.controller.MainController;
import com.cherry.manager.service.ManagerService;
import com.cherry.manager.vo.ManagerVo;
import com.cherry.member.vo.MemberVo;
import com.cherry.notice.controller.NoticeController;
import com.cherry.qna.controller.QnaController;
import com.cherry.town.controller.TownController;
import com.cherry.trade.controller.TradeController;
import com.cherry.trade.vo.TradeVo;
import com.cherry.util.Util;

public class ManagerController {
	
	private final ManagerService service;
	
	public ManagerController() {
		service = new ManagerService();
	}
	
	//관리자 페이지 메뉴 선택
	public void adminPage() {
		Boolean x = false;
		while(!x) {
			System.out.println("=========================================== 관리자 페이지 메뉴 선택 ===========================================");
			System.out.print(" 1.관리자 회원전체 조회");
			System.out.print(" 2.관리자 회원 상세 조회(번호/아이디/닉네임)");
			System.out.print(" 3.관리자 회원 강제 탈퇴");
			System.out.println(" 9.뒤로 가기");
			
			System.out.print("번호를 입력해주세요: ");
			String num = Main.SC.nextLine();
			
			switch(num) {
			case "1" :x=userList(); break;
			case "2" :x=userDetile(); break;
			case "3" :x=userKick(); break;
			case "9" :return;
			default : System.out.println("잘못 입력하였습니다.");
			}
		}
	}	
	
	//관리자 로그인
	public void loginManager() {
		try {
			System.out.println("====== 관리자 로그인 ========================");
			if(Main.loginManager != null) {
				System.out.println("이미 로그인 상태입니다.");
				return;
			}
			
			System.out.print("ID : ");
			String id = Main.SC.nextLine();
			System.out.print("PWD : ");
			String pwd = Main.SC.nextLine();
			
			ManagerVo vo = new ManagerVo();
			vo.setManagerId(id);
			vo.setPwd(pwd);
			
			Main.loginManager = service.loginManager(vo); 
			
			if(Main.loginManager == null) {
				throw new Exception();
			}
			System.out.println("============================================= 관리자 로그인 성공 =============================================");
			System.out.println("                                              "+Main.loginManager.getName()+" 님 환영합니다                                            \n");
			
		}catch(Exception e) {
			System.out.println("관리자 로그인 실패");
			e.printStackTrace();
		}
		
	}
	//관리자 로그아웃
	public void logoutManager() {
		System.out.println("===== 관리자 로그아웃 ======");
		if(Main.loginManager == null) {
			System.out.println("관리자 로그인 상태가 아닙니다");
			return;
		}
		System.out.println("관리자 로그아웃 되었습니다.");
		Main.loginManager = null;
		
	}

	//사용자 회원 전체 조회
	public boolean userList() {
		boolean x = true;
		try {
			System.out.println("================================================ 회원 전체 조회================================================");
			//로그인 검사
			if(Main.loginManager == null) {
				throw new Exception("관리자 로그인부터 진행해주세요");
			}
			List<MemberVo> userList = service.userList();
			
			System.out.println("번호 | 동네번호 | 사용자명 | 아이디 |  닉네임  |    이메일    |   전화번호  |        주소        |     가입일자     |  마지막수정일자  | 탈퇴여부 |");
			for(MemberVo vo : userList) {
				String quityn = "일반회원";
				if(vo.getQuitYn().equals("Y")) {
					quityn = "탈퇴회원";
				}
				System.out.println(vo.getMemberNo()+" | "+vo.getAreasName()+" | "+vo.getName()+" | "+vo.getId()+" | "+vo.getNick()+" | "+vo.getEmail()
				+" | "+vo.getPhone()+" | "+vo.getAddress()+" | "+vo.getJoinDate()+" | "+vo.getEditDate()+" | "+quityn+" |");
			}			System.out.println("================================================================================================================\n");			
			x = false;
		}catch(Exception e) {
			System.out.println("회원 조회 실패");
			e.printStackTrace();
		}
		return x;
	}

	//사용자 회원 상세 조회
	public boolean userDetile() {
		boolean x = true;
		try {
			System.out.println("=============================================== 회원 상세 조회 ===============================================");
			//로그인 검사
			if(Main.loginManager == null) {
				throw new Exception("관리자 로그인부터 진행해주세요"); 
			}
			System.out.println("1.번호 2.아이디 3.닉네임");
			System.out.print("번호를 입력해주세요: ");
			String num = Main.SC.nextLine();
			
			switch(num) {
			case "1" : System.out.print("조회할 회원의 회원번호를 입력해주세요 : "); break;
			case "2" : System.out.print("조회할 회원의 아이디를 입력해주세요 : "); break;
			case "3" : System.out.print("조회할 회원의 닉네임을 입력해주세요 : "); break;
			}
			
			String userChoice = Main.SC.nextLine(); 
			
			List<MemberVo> voList = service.userDetile(userChoice,num);
			
			System.out.println("번호 | 동네번호 | 사용자명 | 아이디 |  닉네임  |    이메일    |   전화번호  |        주소        |     가입일자     |  마지막수정일자  | 탈퇴여부 |");
			for(MemberVo vo : voList) {
				String quityn = "일반회원";
				if(vo.getQuitYn().equals("Y")) {
					quityn = "탈퇴회원";
				}
				System.out.println(vo.getMemberNo()+" | "+vo.getAreasName()+" | "+vo.getName()+" | "+vo.getId()+" | "+vo.getNick()+" | "+vo.getEmail()
				+" | "+vo.getPhone()+" | "+vo.getAddress()+" | "+vo.getJoinDate()+"| "+vo.getEditDate()+"| "+quityn+" |");
			}
			System.out.println("============================================================================================================\n");			
			x = false;
		}catch(Exception e) {
			System.out.println("회원 조회 실패");
			e.printStackTrace();
		}
		return x;
	}
	//상세 조회 추가 (아이디/닉네임)

	//사용자 회원 강제 탈퇴
	public boolean userKick() {
		boolean x = true;
		try {
			System.out.println("=================================== 회원 강제 탈퇴 ===================================");
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
			x = false;
		}catch(Exception e) {
			System.out.println("회원 강제 탈퇴 실패");
			e.printStackTrace();
		}
		return x;
	}

}
