package com.kh.mini.main;

import java.util.Scanner;

import com.kh.jdbc.JDBCTemplate;
import com.kh.mini.board.controller.BoardController;
import com.kh.mini.member.controller.MemberController;
import com.kh.mini.member.vo.MemberVo;

public class Main {

	public static MemberVo loginMember;
	public static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("=========미니 프로젝트=========");

		MemberController mc = new MemberController();
		BoardController bc = new BoardController();
		while(true) {
			System.out.println("1: 맴버 2:게시판 3:나가기");
			String num = SC.nextLine();
			
			switch(num) {
			case "1" : mc.selectMenu(); break;
			case "2" : bc.selectMenu(); break;
			case "3" : return;
			default : System.out.println("잘못 입력 했습니다.");
		}
		}
	}

}
