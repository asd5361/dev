package com.kh.mini.main;

import java.util.Scanner;

import com.kh.mini.member.controller.MemberController;
import com.kh.mini.member.vo.MemberVo;


public class Main {

	   public static final Scanner SC = new Scanner(System.in);
	   public static MemberVo loginMember;
	   public static ManagerVo loginManager;
	   
	   public static void main(String[] args) {

	      MainController controller = new MainController();

	      
	         System.out.println("1: 유저 2: 관리자");
	         System.out.print("입력창 : ");
	         String num = Main.SC.nextLine();
	         
	         switch(num) {
	         case "1" : while(true) {controller.loginMenu();}
	         case "2" : while(true) {controller.manager.loginManager(); if(Main.loginManager != null) {controller.managerLoginMenu();}}
	         default : System.out.println("잘못 입력하였습니다.");
	         }
	      
	   }

}
