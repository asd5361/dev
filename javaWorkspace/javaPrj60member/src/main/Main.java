package main;

import member.MemberController;

public class Main {

public static void main(String[] args) {
		
		System.out.println("====회원 관리 프로그램=====");
		
		MemberController memberController = new MemberController();
		
		// 회원가입
		//memberController.join();
		
		// 로그인
		memberController.login();

	}

}
