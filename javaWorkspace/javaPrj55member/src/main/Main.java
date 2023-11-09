package main;


import member.controller.MemberManager;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("회원 관리 프로그램");
		
		MemberManager mm = new MemberManager();
		
		while(true) {
			try {
				mm.showMenu();
			} catch (Exception e) {
				String errorMsg = e.getMessage();
				System.out.println("\n예외가 발생했습니다");
				System.out.println(errorMsg);
			}
		}
		
	}

}
