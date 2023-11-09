package main;

import member.MemberController;

public class Main {

	public static void main(String[] args) {

		System.out.println("JDBC 복습-회원가입+로그인");
		try {
			MemberController memberController = new MemberController();
			memberController.selectMenu();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}//MAIN 

}
