package com.cherry.main;

import java.util.Scanner;

import com.cherry.main.controller.MainController;
import com.cherry.manager.vo.ManagerVo;
import com.cherry.member.vo.MemberVo;
import com.cherry.util.Color;

public class Main {

	   public static final Scanner SC = new Scanner(System.in);	//주석 달기 : 외부 클래스가 접근 가능한 static (프로그램이 실행되면 바로 실행이 되고, 객체 생성 없이 사용이 가능한) 상수인 스캐너 변수 SC 를 생성 
	   public static MemberVo loginMember; //주석 달기 : 외부 클래스가 접근 가능한 static(프로그램이 실행되면 바로 실행이 되고, 객체 생성 없이 사용이 가능한) MemberVo 타입인 loginMember 참조 변수  선언
	   public static ManagerVo loginManager; //주석 달기 : 외부 클래스가 접근 가능한 static(프로그램이 실행되면 바로 실행이 되고, 객체 생성 없이 사용이 가능한) ManagerVo 타입인 loginManager 참조 변수 선언

	   public static void main(String[] args) {

	      MainController controller = new MainController();	//주석 달기 : 출력문 모아둔 메인 컨트롤러 객체 생성
	      
			System.out.println(""
					+ ""
					+ "\r\n"
					+ Color.RED +" █████████╗ "+Color.EXIT+Color.GREEN+"██╗     ██╗"+Color.BLUE+" ████████╗ ████████╗  ████████╗ ██╗     ██╗ "+Color.RED+"  ███╗      ███╗"+Color.YELLOW+"   █████╗   ████████╗  ██╗    ██╗ ████████╗██████████╗\r\n"
					+ Color.RED +"██╔═══════╝ "+Color.EXIT+Color.GREEN+"██║     ██║ "+Color.BLUE+"██╔═════╝ ██╔════██╗ ██╔════██╗╚██    ██╔╝ "+Color.RED+"  ████╗    ████║"+Color.YELLOW+" ██╔════██╗ ██╔════██╗ ██║   ██╔╝ ██╔═════╝╚═══██╔═══╝\r\n"
					+ Color.RED +"██║         "+Color.EXIT+Color.GREEN+"██████████║ "+Color.BLUE+"████████╗ ████████╔╝ ████████╔╝  ╚████╔═╝  "+Color.RED+"  ██╔══████╔═██║"+Color.YELLOW+" █████████║ ████████╔╝ ██████╔╝   ███████═╗    ██║   \r\n"
					+ Color.RED +"██║         "+Color.EXIT+Color.GREEN+"██ ╔════██║ "+Color.BLUE+"██╔═════╝ ██╔════██╗ ██╔════██╗   ╚██╔╝    "+Color.RED+"  ██║  ╚██╔╝ ██║"+Color.YELLOW+" ██╔════██║ ██╔════██╗ ██╔═══██╗  ██╔═════╝    ██║   \r\n"
					+ Color.RED +"╚██████████╗"+Color.EXIT+Color.GREEN+"██ ║    ██║ "+Color.BLUE+"████████╗ ██║    ██║ ██║    ██║    ██║     "+Color.RED+"  ██║   ╚═╝  ██║"+Color.YELLOW+" ██║    ██║ ██║    ██║ ██║    ██╗ ████████╗    ██║   \r\n"
					+ Color.RED +" ╚═════════╝"+Color.EXIT+Color.GREEN+"╚══╝    ╚═╝ "+Color.BLUE+"╚═══════╝ ╚═╝    ╚═╝ ╚═╝    ╚═╝    ╚═╝     "+Color.RED+"  ╚═╝        ╚═╝"+Color.YELLOW+" ╚═╝    ╚═╝ ╚═╝    ╚═╝ ╚═╝    ╚═╝ ╚═══════╝    ╚═╝"+Color.RED+"🍒 "+Color.EXIT+"  \r\n"
					+ "                                                                                                         \r\n"
					+ "" );
	      
			 System.out.println("                                             "+Color.RED +"▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃"+Color.EXIT + "​​​​​                                           ");
			 System.out.println();
	         System.out.println("                                                         " +Color.YELLOW +"➊" + Color.EXIT + "유저   "+  Color.RED +"➋" + Color.EXIT + "관리자");
	         System.out.println("                                                        번호를 입력해주세요 " + Color.CYAN);
	         System.out.print("                                                                "); 
	         String num = Main.SC.nextLine();
	         System.out.println(Color.EXIT);
	         System.out.println("                                             "+Color.RED +"▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃​​​​​▃▃​​​​​▃▃▃"+Color.EXIT + "​​​​​                                           ");
	         
	       //주석 달기 : int num 를 입력 받아 switch문으로 선택 실행 
	         
	         switch(num) {
	         case "1" : while(true) {controller.loginMenu();}	//주석 달기 : 1이 입력 되면 while 반복문 true로 무한 실행. controller 객체에 loginMenu() 메소드 실행
	         case "2" : while(true) {controller.manager.loginManager(); if(Main.loginManager != null) {controller.managerLoginMenu();}} // 주석 달기 : 2가 입력 되면 whlie 반복문을 true로 무한 실행. controller 객체에 manger 객체에 loginManager() 메소드 실행 후 if 조건문 main에 static 변수인 loginManager 값이 널이 아니면 controller 객체에 managerLoginMenu 메소드를 실행 
	         default : System.out.println("잘못 입력하였습니다."); //주석 달기 : 1, 2 문자열이 입력된 경우가 아니면 출력문 실행.
	         }
	      
	   }

}
