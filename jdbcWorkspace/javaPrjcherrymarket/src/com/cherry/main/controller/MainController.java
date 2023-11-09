package com.cherry.main.controller;

import com.cherry.faq.controller.FaqController;
import com.cherry.main.Main;
import com.cherry.manager.controller.ManagerController;
import com.cherry.member.controller.MemberController;
import com.cherry.notice.controller.NoticeController;
import com.cherry.qna.controller.QnaController;
import com.cherry.town.controller.TownController;
import com.cherry.trade.controller.TradeController;
import com.cherry.util.Util;

public class MainController {	
	public TradeController trade;	//주석 달기 : 외부 클래스에서 접근 가능한 여러 Controller 타입인 참조 변수들 선언
	public TownController town;
	public NoticeController notice;
	public FaqController faq;
	public QnaController qna;
	public MemberController member;
	public ManagerController manager;
	
	public MainController() {
		trade = new TradeController(); //주석 달기 : 선언한 참조 변수들 초기화
		town = new TownController();
		notice = new NoticeController();
		faq = new FaqController();
		qna = new QnaController();
		member = new MemberController();
		manager = new ManagerController();
		
	}
	// 로그인 창
	public void loginMenu() {
		try {Util.clearConsole();} catch (Exception e) {}	// 주석 달기 : try catch문()으로 예외 처리한 Util 객체의 clearConsole 메소드 실행
		System.out.println("====== 메뉴 선택 ===============================");	//주석 달기 : switch 문 선택지에 설명을 위한 출력문
		System.out.print(" 1.회원가입");
		System.out.print(" 2.로그인");	
		System.out.print(" 3.아이디 찾기");
		System.out.println(" 4.비밀번호 찾기");
		
		System.out.print("번호를 입력해주세요: ");	
		String num = Main.SC.nextLine();		// 주석 달기 : 문자열 타입의 num 변수에 Main 클래스의 SC 라는 static 변수의 nextLine() 메소드 실행. (문자 입력 받는 스캐너)
		
		switch(num) {	
		case "1" :member.join(); break;			//주석 달기 : memeber 객체의 join() 메소드 실행. 실행이 끝나면 switch 문 나가기.
		case "2" :member.login(); if(Main.loginMember != null) {memberMenu();} break; //주석 달기 : memeber 객체의 login() 메소드 실행. 이후 조건문 실행. main 클래스의 loginMember static 변수가 null이 아닌 경우 memberMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
		case "3" :member.findId(); break; 		//주석 달기 : memeber 객체의 findId() 메소드 실행. 실행이 끝나면 switch 문 나가기.
		case "4" :member.findPwd(); break; 		//주석 달기 : memeber 객체의 findPwd() 메소드 실행. 실행이 끝나면 switch 문 나가기.
		default : System.out.println("잘못 입력하였습니다.");
		}
	}

	//로그인 메뉴 선택
	public void memberMenu() {
		while(Main.loginMember != null) {	//주석 달기 : while 반복문 main 클래스의 loginMember static 변수가 null이 아닌 경우에 반복 실행
			System.out.println("=========================================== 로그인 메뉴선택 ===========================================");	//주석 달기 : switch 문 선택지를 설명 하기 위한 출력문
			System.out.print(" 1.거래게시판");
			System.out.print(" 2.동네생활");
			System.out.print(" 3.공지사항");
			System.out.print(" 4.FAQ");
			System.out.print(" 5.QnA");
			System.out.print(" 6.마이페이지");
			System.out.println(" 9.로그아웃");
			
			System.out.print("번호를 입력해주세요: ");
			String num = Main.SC.nextLine();	// 문자열 타입 num 변수에 main 클래스에 있는 SC static 변수에 nextLine() 메소드를 실행하여 문자열 입력 받기
			
			switch(num) {	
			case "1" :trade.tradeMain(); break;		//주석 달기 : trade 객체의 tradeMain() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "2" :town.selectMenu(); break; 	//주석 달기 : town 객체의 selectMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "3" :notice.selectMenu(); break;	//주석 달기 : notice 객체의 selectMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "4" :faq.selectMenu(); break;		//주석 달기 : faq 객체의 selectMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "5" :qna.selectMenu(); break;		//주석 달기 : qna 객체의 selectMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "6" :member.myPage(); break;		//주석 달기 : member 객체의 myPage() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "9" :member.logout(); break;		//주석 달기 : member 객체의 logout() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			default : System.out.println("잘못 입력하였습니다.");
			}
		}
		
	}
	
	
	/**************************관리자 영역********************/

	//관리자 로그인 메뉴 선택
	public void managerLoginMenu() {
		while(Main.loginManager != null) {	//주석 달기 : while 반복문 main 클래스의 loginManager static 변수가 null이 아닌 경우에 반복 실행
			
			System.out.println("=========================================== 관리자 로그인 메뉴 선택===========================================");	//주석 달기 : switch 문 선택지를 설명 하기 위한 출력문
			System.out.print(" 1.거래게시판");
			System.out.print(" 2.동네생활");
			System.out.print(" 3.공지사항");
			System.out.print(" 4.FAQ");
			System.out.print(" 5.QnA");
			System.out.print(" 6.관리자페이지");
			System.out.println(" 9.로그아웃");
			
			System.out.print("번호를 입력해주세요: ");
			String num = Main.SC.nextLine();		// 문자열 타입 num 변수에 main 클래스에 있는 SC static 변수에 nextLine() 메소드를 실행하여 문자열 입력 받기
			
			switch(num) {
			case "1" :trade.tradeMain(); break;		//주석 달기 : trade 객체의 tradeMain() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "2" :town.selectMenu(); break;		//주석 달기 : town 객체의 selectMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "3" :notice.selectMenu(); break; 	//주석 달기 : notice 객체의 selectMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "4" :faq.selectMenu(); break; 		//주석 달기 : faq 객체의 selectMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "5" :qna.selectMenu(); break;		//주석 달기 : qna 객체의 selectMenu() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "6" :manager.adminPage(); break;	//주석 달기 : manager 객체의 adminPage() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			case "9" :manager.logoutManager(); break; //주석 달기 : manager 객체의 logoutManager() 메소드 실행. 실행이 끝나면 switch 문 나가기.
			default : System.out.println("잘못 입력하였습니다.");
			}
		}
	}
}
