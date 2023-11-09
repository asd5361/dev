package com.kh.mini.main.controller;

public class MainController {

	public TradeController trade;
	public TownController town;
	public NoticeController notice;
	public FaqController faq;
	public QnaController qna;
	public MemberController member;
	public ManagerController manager;
	
	public MainController() {
		trade = new TradeController();
		town = new TownController();
		notice = new NoticeController();
		faq = new FaqController();
		qna = new QnaController();
		member = new MemberController();
		manager = new ManagerController();
		
	}
	// 로그인 창
	public void loginMenu() {
		System.out.println("===== 메뉴선택 =====");
		
		System.out.print(" 1: 회원가입");
		System.out.print(" 2: 로그인");	
		System.out.print(" 3: 아이디 찾기");
		System.out.println(" 4: 비밀번호 찾기");
		
		System.out.print("입력창 : ");
		String num = Main.SC.nextLine();
		
		switch(num) {
		case "1" :member.join(); break;
		case "2" :member.login(); if(Main.loginMember != null) {memberMenu();} break;
		case "3" :member.findId(); break;
		case "4" :member.findPwd(); break;
		default : System.out.println("잘못 입력하였습니다.");
		}
	}

	//로그인 메뉴 선택
	public void memberMenu() {
		try {Util.clearConsole();}catch(Exception e) {}
		while(Main.loginMember != null) {
			System.out.println("===== 로그인 메뉴 선택 =====");
			
			System.out.print(" 1: 거래게시판");
			System.out.print(" 2: 동네생활");
			System.out.print(" 3: 공지사항");
			System.out.print(" 4: FAQ");
			System.out.print(" 5: QnA");
			System.out.print(" 6: 마이페이지");
			System.out.println(" 9: 로그아웃");
			
			System.out.print("입력창 : ");
			String num = Main.SC.nextLine();
			
			switch(num) {
			case "1" :trade.tradeMain(); break;
			case "2" :town.selectMenu(); break; 
			case "3" :notice.selectMenu(); break;
			case "4" :faq.selectMenu(); break;
			case "5" :qna.selectMenu(); break;
			case "6" :member.myPage(); break;
			case "9" :member.logout(); break;
			default : System.out.println("잘못 입력하였습니다.");
			}
		}
		
	}
	
	
	/**************************관리자 영역********************/
	
	
	//관리자 메뉴 선택
//		public void managerMenu() {
//			System.out.println("===== 관리자 메뉴 선택 =====");
//			
//			/* 관리자 기능 */
//			System.out.println("1: 관리자 로그인");
//			System.out.print("입력창 :");
//			String num = Main.SC.nextLine();
//			
//			switch(num) {
//			case "1" :manager.loginManager(); if(Main.loginManager != null) {managerLoginMenu();}break;
//
//			default : System.out.println("잘못 입력하였습니다.");
//			}
//		}

	//관리자 로그인 메뉴 선택
	public void managerLoginMenu() {
		try {Util.clearConsole();}catch(Exception e) {}
		while(Main.loginManager != null) {
			
			System.out.println("===== 관리자 로그인 메뉴 선택 =====");
			
			System.out.print(" 1: 거래게시판");
			System.out.print(" 2: 동네생활");
			System.out.print(" 3: 공지사항");
			System.out.print(" 4: FAQ");
			System.out.print(" 5: QnA");
			System.out.print(" 6: 관리자페이지");
			System.out.println(" 9: 로그아웃");
			
			System.out.print("입력창 :");
			String num = Main.SC.nextLine();
			
			switch(num) {
			case "1" :trade.tradeMain(); break;
			case "2" :town.selectMenu(); break;
			case "3" :notice.selectMenu(); break; 
			case "4" :faq.selectMenu(); break; 
			case "5" :qna.selectMenu(); break;
			case "6" :manager.adminPage(); break;
			case "9" :manager.logoutManager(); break;
			default : System.out.println("잘못 입력하였습니다.");
			}
		}
	}

}
