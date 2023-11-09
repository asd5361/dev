package com.kh.app.main;

import com.kh.app.controller.MemberController;

public class Main {

	public static void main(String[] args) {

		System.out.println("===회원 관리 프로그램===");
		//회원가입 로그인 전체 회원 조회
		MemberController mc = new MemberController();
		mc.selectMenu();
		//DAO
		//회원 정보 수정 회원 탈퇴
		
	}

}
