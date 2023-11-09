package com.kh.app.main;

import java.util.Scanner;

import com.kh.app.board.controller.BoardController;
import com.kh.app.member.controller.MemberController;
import com.kh.app.member.vo.MemberVo;

public class Main {
	
	public static MemberVo loginMember;

	public static void main(String[] args) {

		System.out.println("로그인 후 게시글 남기는 프로그램");
		MemberController memberController = new MemberController();
		BoardController borderController = new BoardController();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("===================\n");
			System.out.println("1: 회원 메뉴");
			System.out.println("2: 게시판 메뉴");
			String num = sc.nextLine();
			switch(num) {
			case "1" : memberController.selectMenu(); break;
			case "2" : borderController.selectMenu(); break;
			}
		}
	}

}
