package main;

import java.util.*;

public class Employee {

	private final List<Menu> menuList = new ArrayList<Menu>();
	private int totalPrice;
	public void startWork() {
		prepareMenu();
		showMenu();
		order();
		pay();
	}

//	메뉴판 준비
	private void prepareMenu() {
		menuList.add(new Menu("야채김밥",3000));
		menuList.add(new Menu("참치김밥",5000));
		menuList.add(new Menu("소고기김밥",5500));
		menuList.add(new Menu("돈까스김밥",6000));
		
	}
	
//	메뉴판 보여주기
	private void showMenu() {
//		System.out.println(menuList.get(0).getName());
		
		for(Menu menu : menuList) {
			System.out.println(menu);
		}
	}

//	주문받기
	private void order() {
		System.out.print("  주문하실 메뉴의 번호를 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		switch(str) {
			case "1" : totalPrice = 3000; break;
			case "2" : totalPrice = 5000; break;
			case "3" : totalPrice = 5500; break;
			case "4" : totalPrice = 6000; break;
			default : System.out.println("잘못 골랐음");
		}
	}

//	결제하기
	private void pay() {
		System.out.println("\n 총 결제하실 금액은 "+totalPrice+"원 입니다.");
		
	}
	
}
