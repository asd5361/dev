package main;

import java.util.Scanner;

public class Main {
	
	//final : 재할당 불가능 상수일 경우 변수는 대문자로 작성한다.
	static final String BURGER01= "상하이 스파이시";
	static final String BURGER02 = "베이컨 토마토 디럭스";
	static final String BURGER03 = "슈비버거";
	static final String SIDE01 = "감자튀김";
	static final String SIDE02 = "치즈스틱";
	static final String SIDE03 = "코올슬로";
	static final String DRINK01 = "콜라";
	static final String DRINK02 = "사이다";
	static final String DRINK03 = "환타";

	//스캐너 준비
	static Scanner sc = new Scanner(System.in);
	
	//맥도날드 키오스크
	public static void main(String[] args) {
		
		//포장 매장
		System.out.println("1.포장 2.매장");
		int packageType = sc.nextInt();
		
		//메뉴 선택 (버거) 메뉴판 보여주고 입력 받기
		Memu m = new Memu();
		int burger = m.burgerMenu();
		
		//메뉴선택 (사이드)
		int side = m.sideMemu();
		
		//메뉴 선택 (음료)
		int drink = m.drinkMeme();
		
		//결제 
		
		//대기번호 발급
		
		//메뉴명 준비
		String burgerName = null;
		String sideName = null;
		String drinkName = null;
		
		switch(burger) {
			case 1 : burgerName = BURGER01;  break;
			case 2 : burgerName = BURGER02;  break;
			case 3 : burgerName = BURGER03;  break;
			default : System.out.println("잘못 입력하셨습니다.");
		}
		
		switch(side) {
			case 1 : sideName = SIDE01;  break;
			case 2 : sideName = SIDE02;  break;
			case 3 : sideName = SIDE03;  break;
			default : System.out.println("잘못 입력하셨습니다.");
		}
		
		switch(drink) {
			case 1 : drinkName = DRINK01;  break;
			case 2 : drinkName = DRINK02;  break;
			case 3 : drinkName = DRINK03;  break;
			default : System.out.println("잘못 입력하셨습니다.");
		}
		
		//주문확인서 출력
		System.out.println("주문하신 메뉴는");
		System.out.println("햄버거 : "+ burgerName);
		System.out.println("사이드 : "+ sideName);
		System.out.println("음료수 : "+ drinkName);
		System.out.println("입니다.");
		
	}

}
