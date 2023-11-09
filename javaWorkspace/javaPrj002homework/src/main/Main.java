package main;

import java.util.Scanner;

import manager.*;

public class Main {

	public static Scanner sc = new Scanner(System.in); 
	
	public static void main(String[] args) {

		System.out.println("카페 키오스크 주문\n");
		
		PrintInfo printInfo = new PrintInfo();
		ScanUser scanUser = new ScanUser();
		Calculate calculate = new Calculate();
		
		// 주문을 하시겠습니까? 안내문
		printInfo.printStart();
		printInfo.printst();
		
		// 선택 메뉴+가격 확인
		printInfo.printmenu();
		
		//메뉴 선택 입력 받기
		String chosemenu = scanUser.UserString();
		
		// 선택 사이즈 확인 
		printInfo.printsize();

		//사이즈 사이즈 입력 받기
		String chosesize = scanUser.UserString();
		
		// 선택 수량 확인 
		printInfo.printamount();
		
		//사이즈 수량 입력 받기
		int choseamount = scanUser.UserInt();
		
		
		// 총 금액 확인
		int sum = calculate.menuSum(chosemenu,chosesize, choseamount);
		printInfo.printSum(sum);
		
		
		// 선택 결제 방법
		printInfo.printCash();
		int chosecash = scanUser.UserInt();
		
		// 마지막 멘트
		printInfo.printlistment(sum,chosecash);
		
		
	}

}
